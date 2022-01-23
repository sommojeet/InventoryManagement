/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exavalu.im.servlets;

import com.exavalu.im.pojos.Order;
import com.exavalu.im.pojos.User;
import com.exavalu.im.services.OrderServices;
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
public class SaveOrder extends HttpServlet {

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
        HttpSession session = request.getSession();
        User validUser = (User) session.getAttribute("validUser");
        if (validUser != null && validUser.isValidUser()) {
            Order order = new Order();
            order.setCustomerName(request.getParameter("customerName"));
            order.setDestinationCity(request.getParameter("destinationCity"));
            order.setDestinationCountry(request.getParameter("destinationCountry"));
            order.setOrderDate(request.getParameter("orderDate"));
            order.setOrderId(Integer.parseInt(request.getParameter("orderId")));
            order.setOrderValue(Double.parseDouble(request.getParameter("orderValue")));
            order.setTaxAmount(Double.parseDouble(request.getParameter("taxAmount")));

            boolean success = OrderServices.saveOrder(order);
            if(success)
            {
                request.setAttribute("MSG", "Order updated successfully");
            }
            else
            {
                request.setAttribute("MSG", "Something went wrong!! Order was not updated");
            }
            ArrayList orders = OrderServices.getAllOrders();
            request.setAttribute("orders", orders);
            request.getRequestDispatcher("orders.jsp").forward(request, response);
        } else {
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
