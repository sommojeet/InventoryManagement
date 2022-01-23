/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exavalu.im.services;

import com.exavalu.im.core.ConnectionManager;
import com.exavalu.im.pojos.Country;
import com.exavalu.im.pojos.Order;
import com.exavalu.im.pojos.State;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sommo
 */
public class OrderServices {

    public static ArrayList getAllOrders() {
        ArrayList orders = new ArrayList();
        Connection con = null;
        try {

            con = ConnectionManager.getConnection();
            String sql = "select * from orders o,customer c "
                    + "where o.customerId=c.customerId ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Order order = new Order();

                order.setCustomerId(rs.getInt("customerId"));
                order.setCustomerName(rs.getString("customerName"));
                order.setDestinationCity(rs.getString("destinationCity"));
                order.setDestinationCountry(rs.getString("destinationCountry"));
                order.setOrderDate(rs.getString("orderDate"));
                order.setOrderId(rs.getInt("orderId"));
                DecimalFormat df = new DecimalFormat("0.00");
                order.setOrderValue(Double.parseDouble(df.format(rs.getDouble("orderValue"))));
                order.setTaxAmount(Double.parseDouble(df.format(rs.getDouble("taxAmount"))));

                orders.add(order);

            }
            System.out.println("Total number of orders = " + orders.size());

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return orders;
    }

    public static Order getOrder(String strOrderId) {
        Order order = new Order();
        Connection con = null;
        try {

            con = ConnectionManager.getConnection();
            String sql = "select * from orders o,customer c "
                    + "where o.customerId=c.customerId and orderId=? ";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, strOrderId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                order.setCustomerId(rs.getInt("customerId"));
                order.setCustomerName(rs.getString("customerName"));
                order.setDestinationCity(rs.getString("destinationCity"));
                order.setDestinationCountry(rs.getString("destinationCountry"));
                order.setOrderDate(rs.getString("orderDate"));
                order.setOrderId(rs.getInt("orderId"));
                DecimalFormat df = new DecimalFormat("0.00");
                order.setOrderValue(Double.parseDouble(df.format(rs.getDouble("orderValue"))));
                order.setTaxAmount(Double.parseDouble(df.format(rs.getDouble("taxAmount"))));
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
        return order;
    }

    public static boolean saveOrder(Order order) {
        boolean success = false;

        Connection con = null;
        try {

            con = ConnectionManager.getConnection();
            String sql = "UPDATE orders SET orderDate = ?,orderValue = ?,"
                    + "taxAmount =?,destinationCity =?,destinationCountry = ? "
                    + "WHERE orderId =?  ";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, order.getOrderDate());
            ps.setDouble(2, order.getOrderValue());
            ps.setDouble(3, order.getTaxAmount());
            ps.setString(4, order.getDestinationCity());
            ps.setString(5, order.getDestinationCountry());
            ps.setInt(6, order.getOrderId());

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

    public static boolean saveOrder(Order order, ArrayList products) {
        boolean success = false;

        Connection con = null;
        try {

            con = ConnectionManager.getConnection();
            String sql = "INSERT INTO orders (orderDate,orderValue,taxAmount,customerId,"
                    + "destinationCity,destinationCountry) "
                    + "VALUES (?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String strDate = formatter.format(date);

            ps.setString(1, strDate);
            ps.setDouble(2, order.getOrderValue());
            ps.setDouble(3, order.getTaxAmount());
            ps.setInt(4, order.getCustomerId());
            ps.setString(5, order.getDestinationCity());
            ps.setString(6, order.getDestinationCountry());

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

    public static ArrayList getCountries() {
        ArrayList countries = new ArrayList();
        Connection con = null;
        try {

            con = ConnectionManager.getConnection();
            String sql = "SELECT * FROM countries";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Country country = new Country();
                country.setCountryCode(rs.getString("CountryCode"));
                country.setCountryName(rs.getString("name"));
                countries.add(country);
            }

        } catch (SQLException ex) {

        }
        return countries;
    }

    public static ArrayList getStates(String countryCode) {

        ArrayList states = new ArrayList();
        Connection con = null;
        try {

            con = ConnectionManager.getConnection();
            String sql = "SELECT * FROM states where countryCode=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, countryCode);
            System.out.println("SQL=====" + ps);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                State state = new State();
                state.setCountryCode(rs.getString("CountryCode"));
                state.setStateName(rs.getString("StateName"));
                state.setStateCode(rs.getString("StateCode"));
                states.add(state);
            }

        } catch (SQLException ex) {

        }
        System.out.println("Number of states=====" + states.size());
        return states;
    }
}
