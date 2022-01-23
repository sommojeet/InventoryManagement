/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exavalu.im.servlets;

import com.exavalu.im.pojos.User;
import com.exavalu.im.services.OrderServices;
import com.exavalu.im.services.UserService;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sommo
 */
public class LoginServlet extends HttpServlet {
    
    //Servlet is a special java class which understands http protocol 
    //you servlet should always extend HttpServlet 
    // what is HttpServlet? - this inherits some methods like
    //init, service, destroy - these methods are called Servlet Lifecycle Methods 
    //Can you figure out other classes which are similar to GenericServlet? 

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //here I will validate user id and password 
        //if valid then I will forward the user to my dashboard
        //else I will forward the user to login page again
        
        //I have to catch username and password, my user has submitted from
        // the frontend. 
        
        String userName=request.getParameter("userName");
        String password=request.getParameter("password");
        
        //So, now I need to call a java service in my server or
        //external server
        User myUser = new User();
        myUser.setUserName(userName);
        myUser.setPassword(password);
        
        User  validUser = UserService.validateLoginCredentials(myUser);
        
        if(validUser.isValidUser())
        {
            //go to dashboard, which is either html or jsp
            HttpSession session = request.getSession();
            session.setAttribute("validUser", validUser); //Why? 
            
            //Now we need to get the orders here
            ArrayList orders = OrderServices.getAllOrders();
            request.setAttribute("orders", orders);
            
            //This is the usual way of sending data to front end - html or jsp 
            request.getRequestDispatcher("dashboard.jsp").forward(request, response);
            
        }
        else
        {
            //go to login page again
            String errorMsg = "Either your userid or password is wrong. Please try again!!";
            request.setAttribute("ErrorMsg", errorMsg);
            request.getRequestDispatcher("loginPage.jsp").forward(request, response);
        }
        
        
    }

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
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
