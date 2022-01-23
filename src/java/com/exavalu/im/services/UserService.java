/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exavalu.im.services;

import com.exavalu.im.core.ConnectionManager;
import com.exavalu.im.pojos.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author sommo
 */
public class UserService {

    public static User validateLoginCredentials(User user) {
        Connection con = null;
        try {
            boolean valid = true;

            String userName = user.getUserName();
            String password = user.getPassword();
            //we need to connect to database or other system and validate user with
            //this userName and password
            con = ConnectionManager.getConnection();
            System.out.println("Got the connection.........................." + con);
            String sql = "SELECT userName,password,firstName,lastName,email,phoneNumber FROM users"
                    + " where userName=? and password=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, userName);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user.setUserName(rs.getString("userName"));
                user.setPassword(rs.getString("password"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setEmail(rs.getString("email"));
                user.setPhoneNumber(rs.getString("phoneNumber"));
                user.setValidUser(valid);
            } else {
                valid = false;
                user.setValidUser(valid);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    //report the error in a log file
                }
            }
        }
        return user;
    }

    public static boolean registerUser(User myUser) {
        Connection con = null;
        boolean success = false;
        try {

            con = ConnectionManager.getConnection();

            String sql = "INSERT INTO users (userName, password, firstName, lastName, email, phoneNumber)\n"
                    + "VALUES (?,?,?,?,?,?)";

            String userName = myUser.getUserName();
            String password = myUser.getPassword();
            String firstName = myUser.getFirstName();
            String lastName = myUser.getLastName();
            String email = myUser.getEmail();
            String phoneNumber = myUser.getPhoneNumber();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, userName);
            ps.setString(2, password);
            ps.setString(3, firstName);
            ps.setString(4, lastName);
            ps.setString(5, email);
            ps.setString(6, phoneNumber);

            int row = ps.executeUpdate();

            if (row > 0) {
                success = true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                //report the error in a log file
            }
        }

        return success;
    }

}
