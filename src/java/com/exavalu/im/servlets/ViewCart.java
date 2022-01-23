/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exavalu.im.servlets;

import com.exavalu.im.pojos.Order;
import com.exavalu.im.pojos.Product;
import com.exavalu.im.pojos.User;
import com.exavalu.im.services.CustomerServices;
import com.exavalu.im.services.OrderServices;
import com.exavalu.im.services.ProductServices;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sommo
 */
public class ViewCart extends HttpServlet {

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
            
            ArrayList cart = (ArrayList) request.getSession().getAttribute("Cart");
            if(cart==null)
            {
                String emptyCart = "Cart is Empty! Please add products";
                request.getSession().setAttribute("EmptyCart", emptyCart);
                request.getRequestDispatcher("placeOrder.jsp").forward(request, response);
            }
            ArrayList productsOrdered = ProductServices.getOrderedProducts(cart);
            
            Order order = new Order();
            order.setProducts(productsOrdered); 
            Iterator itr = productsOrdered.iterator();
            double totalAmount=0.00;
            double totalTax=0.00;
            while (itr.hasNext())
            {
                Product prod = (Product)itr.next();
                totalAmount=totalAmount+prod.getPrice();
                totalTax = totalTax+prod.getProductTax();
            }
            order.setOrderValue(totalAmount);
            order.setTaxAmount(totalTax);
            
            
            request.getSession().setAttribute("order", order);
            request.getSession().setAttribute("products", productsOrdered);
            
            ArrayList countries = OrderServices.getCountries();
            request.setAttribute("countries", countries);
            
            ArrayList customers = CustomerServices.getAllCustomers();
            request.setAttribute("customers", customers);
            
            
//            ArrayList cart =(ArrayList) request.getSession().getAttribute("Cart");
//            request.getSession().setAttribute("Cart", cart);
            
            request.getRequestDispatcher("placeOrder.jsp").forward(request, response);
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
