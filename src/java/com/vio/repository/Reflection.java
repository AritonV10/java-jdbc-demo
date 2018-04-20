  public Object save(Object object) {
        
        
        Class<?> clazz = null;
        Field[] clazz_fields_ = null;
        Map<String, Object> clazz_v = new HashMap<>();
        StringBuffer db_table_columns_buffer = new StringBuffer();
        StringBuffer object_values = new StringBuffer();
        try{
            clazz = object.getClass();
            clazz_fields_ = new Field[clazz.getDeclaredFields().length];
            clazz_fields_ = clazz.getDeclaredFields();
        } catch (Exception e){
            e.printStackTrace();
        }
        
        Object[] b = new Object[clazz_fields_.length];
        int i = 0;
        if(clazz_fields_.length > 0){
            for(Field f : clazz_fields_){
                f.setAccessible(true);
                clazz_v.put(f.getName(), f.getType());
                try{
                    b[i] = f.get(object);
                    i++;
                } catch (IllegalAccessException e){
                    e.printStackTrace();
                }
                
            }
            String DB_TABLE_NAME = null;
            String[] DB_TABLE_COLUMNS = null;
            int db_table_counter_ = 0;
            DatabaseMetaData db = null;
            PreparedStatement statement = null;
            Connection connection = null;
            ResultSet result = null;
            String[] _table = null;
           
            try{
                int NUMBER_OF_RECORDS = 0;
                String[] t_c = {"TABLE"};
                int p = 0;
                connection = CONNECTION_POOL.getConnection();
                db = connection.getMetaData();
                result = db.getTables(null, null, "%", t_c);
                System.out.println(t_c.length+ " fetch size");
                 _table = new String[10];
                while(result.next()){
                    System.out.println(_table.length + " table size");
                    _table[p] = result.getString(3);
                    System.out.println(result.getString(3));
                    p++;
                }
                
               
                
            } catch (SQLException ex) {
                Logger.getLogger(CRUDReflection.class.getName()).log(Level.SEVERE, null, ex);
            }
            
             for(String s : _table){
                    if(object.getClass().getSimpleName().toLowerCase().contains(s.toLowerCase())){
                        DB_TABLE_NAME = s;
                        break;
                    }
                }
            
            try{
                final String QUERY = "SELECT * FROM " + DB_TABLE_NAME;
                System.out.println(QUERY);
                statement = connection.prepareStatement(QUERY);
                result = statement.executeQuery();
                ResultSetMetaData rsmd_ = result.getMetaData();
                int columns_size = rsmd_.getColumnCount();
                System.out.println(columns_size);
                DB_TABLE_COLUMNS = new String[columns_size - 2];
                for(int k = 1; k <= columns_size; k++){
                    DB_TABLE_COLUMNS[k-2] = rsmd_.getColumnName(k);
                    System.out.println(DB_TABLE_COLUMNS[k-2] + " DB_TABLE_COLUMN");
                    db_table_columns_buffer.append(rsmd_.getColumnName(k));
                    System.out.println(rsmd_.getColumnName(k) + " rsmd");
                    db_table_columns_buffer.append(",");
                }
                
                System.out.println(db_table_columns_buffer.toString() + " buffer");
                
            } catch (SQLException ex) {
                Logger.getLogger(CRUDReflection.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            final StringBuffer buff = new StringBuffer();
            for(int j = 0; j < db_table_columns_buffer.length(); j++){
                buff.append("?");
                buff.append(",");
            }
            
            buff.deleteCharAt(buff.length());
            db_table_columns_buffer.deleteCharAt(db_table_columns_buffer.length());
            
            final String INSERT_QUERY = "INSERTO INTO " + DB_TABLE_NAME +"("+db_table_columns_buffer+")"+" VALUES("+buff+")";
            
            try{
                statement = connection.prepareStatement(INSERT_QUERY);
                int m = 1;
                for(Object val : b){
                    if(val instanceof String){
                        statement.setString(m, val.toString());
                        m++;
                        continue;
                    }
                    if(val instanceof Integer){
                         statement.setInt(m, Integer.parseInt(val.toString()));
                        m++;
                        continue;
                    }
                    if(val instanceof Boolean){
                         statement.setBoolean(m, ((Boolean) val).booleanValue());
                        m++;
                        continue;
                    }
                    if(val instanceof Double){
                         statement.setDouble(m, ((Double) val).doubleValue());
                        m++;
                        continue;
                    }
                    if(val instanceof Float){
                         statement.setFloat(m, ((Float) val).floatValue());
                        m++;
                        continue;
                    }
                    
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(CRUDReflection.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                CONNECTION_POOL.closeConnection(connection);
                try {
                    statement.close();
                    result.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CRUDReflection.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }
            
        }
        
        
        return object;
    }
