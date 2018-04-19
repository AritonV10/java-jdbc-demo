/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vio.web;

import com.vio.domain.User;
import com.vio.service.UserServiceImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author arito
 */
@WebServlet(name = "RegisterController", urlPatterns = {"/register"})
public class RegisterController extends HttpServlet {

 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String url = "/register.jsp";
        final UserServiceImpl service = new UserServiceImpl();
        final String USER_USERNAME = request.getParameter("username");
        final String USER_EMAIL = request.getParameter("email");
        final String USER_PASSWORD = request.getParameter("password");
        
        if(USER_USERNAME != null && USER_EMAIL != null && USER_PASSWORD != null){
            if(isUsernameAvailable(USER_USERNAME) == true){
                final User user = service.registerUser(createUser(USER_USERNAME, USER_PASSWORD, USER_EMAIL));
                createSession(user, createCookie(user), request, response);
                url = "/index.jsp";
            }
        }
        
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    
    
    
    
    
    
    protected static void createSession(User user, Cookie cookie, HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession(true);
        session.setAttribute("user", user);
        response.addCookie(cookie);
    }
    
    protected static Cookie createCookie(User user){
        String USER_USERNAME = user.getUsername();
        Cookie cookie = new Cookie("user", USER_USERNAME);
        cookie.setMaxAge(30 * 60 * 24);
        return cookie;
    }
    
    protected static User createUser(String username, String password, String email){
        final User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setUsername(username);
        
        return user;
    }
    
    protected static boolean isUsernameAvailable(String username){
        final UserServiceImpl service = new UserServiceImpl();
        
        User user = service.findByUsername(username);
        if(user == null){
            return true;
        }
        
        return false;
    }

}
