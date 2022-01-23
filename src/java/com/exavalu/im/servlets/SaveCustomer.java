/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exavalu.im.servlets;

import com.exavalu.im.pojos.Customer;
import com.exavalu.im.pojos.User;
import com.exavalu.im.services.CustomerServices;
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
public class SaveCustomer extends HttpServlet {

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
        
        //we need to get the submitted values for customer
        //we will send the values wrapped in a customer object 
        // to the service layer for saving into the database
        
        Customer customer = new Customer();
        
        String customerId = request.getParameter("customerId");
        
        customer.setCustomerId(Integer.parseInt(customerId));
        customer.setCustomerName(request.getParameter("customerName"));
        customer.setCustomerAddress(request.getParameter("customerAddress"));
             
        
        HttpSession session = request.getSession();
        User  validUser = (User)session.getAttribute("validUser");
        if(validUser !=null && validUser.isValidUser())
        {
            boolean success = CustomerServices.saveCustomer(customer);
            request.setAttribute("MSG", "Customer Updated Successfully");
            ArrayList customers = CustomerServices.getAllCustomers();
            request.setAttribute("customers", customers);
            request.getRequestDispatcher("customers.jsp").forward(request, response);
        }
        else
        {
            String errorMsg = "You are not loggedin. Please login here.";
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
