/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vio.web;

import com.vio.db.config.PasswordEncoder;
import com.vio.domain.Cart;
import com.vio.domain.User;
import com.vio.service.UserServiceImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author arito
 */
@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String url = "/login.jsp?error=true";
        final String USER_USERNAME = request.getParameter("username");
        final String USER_PASSWORD = request.getParameter("password");
        if(isMatch(USER_PASSWORD, USER_USERNAME)){
            createSession(USER_USERNAME, request);
            url = "/index.jsp";
        } else {
            request.setAttribute("error", "Invalid username or password");
        }
        
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
        
    }
    
    
    protected boolean isMatch(String login, String username){
        final UserServiceImpl service = new UserServiceImpl();
        PasswordEncoder encoder = null;
        try{
            encoder = new PasswordEncoder();
        } catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        User user = service.findByUsername(username);
        if(user == null){
            return false;
        }
        
        final String ENCODED_PASSWORD = encoder.encode(login);
        if(ENCODED_PASSWORD.equals(service.findByUsername(username).getPassword())){
            return true;
        }
        
        return false;
    }

    protected void createSession(String username, HttpServletRequest request){
        final UserServiceImpl service = new UserServiceImpl();
        final User user_ = service.findByUsername(username);
        final Cart cart = new Cart();
        if(user_ == null){
            return;
        }
        final HttpSession session = request.getSession(true);
        session.setAttribute("user", user_);
        session.setAttribute("cart", cart);
    }

}
