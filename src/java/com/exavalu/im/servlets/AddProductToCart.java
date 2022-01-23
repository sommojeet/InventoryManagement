/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exavalu.im.servlets;

import com.exavalu.im.pojos.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sommo
 */
public class AddProductToCart extends HttpServlet {

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
        String productId = request.getParameter("productId");
        String quantity = request.getParameter("quantity");

        //We want to use Session to hold our cart
        if (request.getSession().getAttribute("Cart") == null) {
            ArrayList cart = new ArrayList();
            Product product = new Product();
            product.setProductId(Integer.parseInt(productId));
            product.setQuantityOrdered(Integer.parseInt(quantity));
            cart.add(product);
            request.getSession().setAttribute("Cart", cart);
        } 
        else 
        {
            ArrayList cart =(ArrayList) request.getSession().getAttribute("Cart");
            
            Product product = new Product();
            product.setProductId(Integer.parseInt(productId));
            product.setQuantityOrdered(Integer.parseInt(quantity));
            cart.add(product);
            request.getSession().setAttribute("Cart", cart);
        }
        ArrayList cart =(ArrayList) request.getSession().getAttribute("Cart");
        PrintWriter out = response.getWriter();
        out.println(cart.size());
        System.out.println("Items in cart="+cart.size());
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
