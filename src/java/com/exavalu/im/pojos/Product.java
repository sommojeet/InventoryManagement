/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exavalu.im.pojos;

/**
 *
 * @author sommo
 */
public class Product {
    
    private int productId;
    private String productName;
    private String productMake;
    private double price;
    private double productTax;
    private int availability;
    private int quantityOrdered;
    private String message;

    /**
     * @return the productId
     */
    public int getProductId() {
        return productId;
    }

    /**
     * @param productId the productId to set
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }

    /**
     * @return the productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName the productName to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * @return the productMake
     */
    public String getProductMake() {
        return productMake;
    }

    /**
     * @param productMake the productMake to set
     */
    public void setProductMake(String productMake) {
        this.productMake = productMake;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the availability
     */
    public int getAvailability() {
        return availability;
    }

    /**
     * @param availability the availability to set
     */
    public void setAvailability(int availability) {
        this.availability = availability;
    }

    /**
     * @return the quantityOrdered
     */
    public int getQuantityOrdered() {
        return quantityOrdered;
    }

    /**
     * @param quantityOrdered the quantityOrdered to set
     */
    public void setQuantityOrdered(int quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the productTax
     */
    public double getProductTax() {
        return productTax;
    }

    /**
     * @param productTax the productTax to set
     */
    public void setProductTax(double productTax) {
        this.productTax = productTax;
    }
    
}
