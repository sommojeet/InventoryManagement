/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exavalu.im.pojos;

import java.util.ArrayList;

/**
 *
 * @author sommo
 */
public class Order {

    private int orderId;
    private String orderDate;
    private double orderValue;
    private int customerId;
    private double taxAmount;
    private String destinationCity;
    private String destinationCountry;
    private String customerName;
    private ArrayList<Product> products;

    /**
     * @return the orderId
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * @param orderId the orderId to set
     */
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    /**
     * @return the orderDate
     */
    public String getOrderDate() {
        return orderDate;
    }

    /**
     * @param orderDate the orderDate to set
     */
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * @return the destinationCity
     */
    public String getDestinationCity() {
        return destinationCity;
    }

    /**
     * @param destinationCity the destinationCity to set
     */
    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    /**
     * @return the destinationCountry
     */
    public String getDestinationCountry() {
        return destinationCountry;
    }

    /**
     * @param destinationCountry the destinationCountry to set
     */
    public void setDestinationCountry(String destinationCountry) {
        this.destinationCountry = destinationCountry;
    }

    /**
     * @return the customerName
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * @param customerName the customerName to set
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * @return the customerId
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId the customerId to set
     */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    /**
     * @return the orderValue
     */
    public double getOrderValue() {
        return orderValue;
    }

    /**
     * @param orderValue the orderValue to set
     */
    public void setOrderValue(double orderValue) {
        this.orderValue = orderValue;
    }

    /**
     * @return the taxAmount
     */
    public double getTaxAmount() {
        return taxAmount;
    }

    /**
     * @param taxAmount the taxAmount to set
     */
    public void setTaxAmount(double taxAmount) {
        this.taxAmount = taxAmount;
    }

    /**
     * @return the products
     */
    public ArrayList<Product> getProducts() {
        return products;
    }

    /**
     * @param products the products to set
     */
    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

}
