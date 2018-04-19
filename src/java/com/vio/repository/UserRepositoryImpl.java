/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vio.repository;


import com.mysql.jdbc.Field;
import com.vio.db.config.ConnectionPool;
import com.vio.db.config.PasswordEncoder;
import com.vio.domain.User;
import com.vio.repository.UserRepository;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.catalina.core.ApplicationContext;


/**
 *
 * @author arito
 */
public class UserRepositoryImpl implements UserRepository {
    
    /**
     * @see ConnectionPool
     */
    private final ConnectionPool pool = ConnectionPool.getInstance();
   
    
    @Override
    public Set<User> findAll() {
        final String SELECT_FROM = "SELECT user_username, user_password, user_email FROM user";
        Connection connection = null;
        ResultSet result = null;
        PreparedStatement statement = null;
        Set<User> users = new HashSet<>();
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = pool.getConnection();
            statement = connection.prepareStatement(SELECT_FROM);
            result = statement.executeQuery();
            while(result.next()){
                final String USER_USERNAME = result.getString("user_username");
                final String USER_EMAIL = result.getString("user_email");
                final String USER_PASSWORD = result.getString("user_password");
                final User user = new User();
                user.setEmail(USER_EMAIL);
                user.setPassword(USER_PASSWORD);
                user.setUsername(USER_USERNAME);
                users.add(user);
            }
            
        } catch (SQLException ex){
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try{
                if(connection != null && statement != null && result != null){
                    statement.close();
                    result.close();
                    pool.closeConnection(connection);
                }
            } catch (SQLException ex){
                for(Throwable t : ex){
                    t.printStackTrace();
                }
            }
        }
        
        return users;
    }

    @Override
    public User findById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User update(User object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User save(User user) {
        final String SAVE_QUERY = "INSERT INTO user (user_username, user_password, user_email) VALUES(?,?,?)";
        Connection connection = null;
        PreparedStatement statement = null;
        PasswordEncoder passwordEncoder = null;
        try{
            
            try{
                passwordEncoder = new PasswordEncoder();
            } catch (NoSuchAlgorithmException e){
                e.printStackTrace();
            }
            
            connection = pool.getConnection();
            statement = connection.prepareStatement(SAVE_QUERY);
            statement.setString(1, user.getUsername());
            statement.setString(2, passwordEncoder.encode(user.getPassword()));
            statement.setString(3, user.getEmail());
            statement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(UserRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try{
                pool.closeConnection(connection);
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return user;
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User findByUsername(String username) {
        final String FIND_USER = "SELECT * FROM user WHERE user_username=?";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        Optional<User> userOptional = null;
        Optional<User> notFound = null;
        try{
            String USERNAME;
            String EMAIL;
            String PASSWORD;
            connection = pool.getConnection();
            statement = connection.prepareStatement(FIND_USER);
            statement.setString(1, username);
            result = statement.executeQuery();
            int i = 1;
            while(result.next()){
                final User user = new User();
                USERNAME = result.getString("user_username");
                EMAIL = (String) result.getString("user_email");
                PASSWORD = (String) result.getString("user_password");
                user.setEmail(EMAIL);
                user.setPassword(PASSWORD);
                user.setUsername(USERNAME);
              
                System.out.println(user.getUsername());
                return user;
            }
            
     
           
           
        } catch (SQLException ex) {
            Logger.getLogger(UserRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
             statement.close();
             result.close();
             pool.closeConnection(connection);   
        }
        
         return null;
    }

}
