/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exavalu.im.services;

import com.exavalu.im.core.ConnectionManager;
import com.exavalu.im.pojos.Customer;
import com.exavalu.im.pojos.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author sommo
 */
public class CustomerServices {

    public static ArrayList getAllCustomers() {
        ArrayList customers = new ArrayList();
        Connection con = null;
        try {

            con = ConnectionManager.getConnection();
            String sql = "SELECT * FROM customer";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Customer customer = new Customer();

                customer.setCustomerId(rs.getInt("customerId"));
                customer.setCustomerName(rs.getString("customerName"));
                customer.setCustomerAddress(rs.getString("customerAddress"));

                customers.add(customer);

            }
            System.out.println("Total number of customers = " + customers.size());

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return customers;
    }

    public static Customer getCustomer(String customerId) {

        Customer customer = new Customer();
        Connection con = null;
        try {

            con = ConnectionManager.getConnection();
            String sql = "SELECT * FROM customer where customerId=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, customerId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                customer.setCustomerId(rs.getInt("customerId"));
                customer.setCustomerName(rs.getString("customerName"));
                customer.setCustomerAddress(rs.getString("customerAddress"));

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return customer;
    }

    public static boolean saveCustomer(Customer customer) {

        boolean success = false;
        Connection con = null;
        try {

            con = ConnectionManager.getConnection();
            String sql = "UPDATE orderinventories.customer SET customerName =?, "
                    + "customerAddress = ? WHERE customerId = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, customer.getCustomerName());
            ps.setString(2, customer.getCustomerAddress());
            ps.setInt(3, customer.getCustomerId());

            int row = ps.executeUpdate();

            if (row > 0) {

                success = true;

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return success;

    }

}
