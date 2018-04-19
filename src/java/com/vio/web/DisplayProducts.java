/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vio.web;

import com.vio.domain.Product;
import com.vio.domain.User;
import com.vio.service.ProductServiceImpl;
import com.vio.service.UserServiceImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author arito
 */
@WebServlet(name = "DisplayProducts", urlPatterns = {"/products"})
public class DisplayProducts extends HttpServlet {



    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        final ProductServiceImpl service = new ProductServiceImpl();
        String url = "/products.jsp";
        final Set<Product> products = service.getProducts();
        request.setAttribute("products", products); 
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
       
    }

    

}
