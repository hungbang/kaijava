/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataHelp;

import java.sql.Date;

/**
 *
 * @author PHI LONG
 */
public class Orders {
    private int orderID;
    private int customerID;
    private int employeeID;
    private Date orderDate;
    private boolean status;
    private Date shippedDate;
    private double freight;
    private String shipName;
    private String shipAddress;
    private String shipCity;
    private String shipRegion;
    private String shipZipCode;
    private String shipCountry;

    /**
     * @return the orderID
     */
    public int getOrderID() {
        return orderID;
    }

    /**
     * @param orderID the orderID to set
     */
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    /**
     * @return the customerID
     */
    public int getCustomerID() {
        return customerID;
    }

    /**
     * @param customerID the customerID to set
     */
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    /**
     * @return the employeeID
     */
    public int getEmployeeID() {
        return employeeID;
    }

    /**
     * @param employeeID the employeeID to set
     */
    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    /**
     * @return the orderDate
     */
    public Date getOrderDate() {
        return orderDate;
    }

    /**
     * @param orderDate the orderDate to set
     */
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * @return the status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * @return the shippedDate
     */
    public Date getShippedDate() {
        return shippedDate;
    }

    /**
     * @param shippedDate the shippedDate to set
     */
    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }

    /**
     * @return the freight
     */
    public double getFreight() {
        return freight;
    }

    /**
     * @param freight the freight to set
     */
    public void setFreight(double freight) {
        this.freight = freight;
    }

    /**
     * @return the shipName
     */
    public String getShipName() {
        return shipName;
    }

    /**
     * @param shipName the shipName to set
     */
    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    /**
     * @return the shipAddress
     */
    public String getShipAddress() {
        return shipAddress;
    }

    /**
     * @param shipAddress the shipAddress to set
     */
    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    /**
     * @return the shipCity
     */
    public String getShipCity() {
        return shipCity;
    }

    /**
     * @param shipCity the shipCity to set
     */
    public void setShipCity(String shipCity) {
        this.shipCity = shipCity;
    }

    /**
     * @return the shipRegion
     */
    public String getShipRegion() {
        return shipRegion;
    }

    /**
     * @param shipRegion the shipRegion to set
     */
    public void setShipRegion(String shipRegion) {
        this.shipRegion = shipRegion;
    }

    /**
     * @return the shipZipCode
     */
    public String getShipZipCode() {
        return shipZipCode;
    }

    /**
     * @param shipZipCode the shipZipCode to set
     */
    public void setShipZipCode(String shipZipCode) {
        this.shipZipCode = shipZipCode;
    }

    /**
     * @return the shipCountry
     */
    public String getShipCountry() {
        return shipCountry;
    }

    /**
     * @param shipCountry the shipCountry to set
     */
    public void setShipCountry(String shipCountry) {
        this.shipCountry = shipCountry;
    }
    //order constructor

    public Orders(int orderID, int customerID, int employeeID, Date orderDate, boolean status, Date shippedDate, double freight, String shipName, String shipAddress, String shipCity, String shipRegion, String shipZipCode, String shipCountry) {
	this.orderID = orderID;
	this.customerID = customerID;
	this.employeeID = employeeID;
	this.orderDate = orderDate;
	this.status = status;
	this.shippedDate = shippedDate;
	this.freight = freight;
	this.shipName = shipName;
	this.shipAddress = shipAddress;
	this.shipCity = shipCity;
	this.shipRegion = shipRegion;
	this.shipZipCode = shipZipCode;
	this.shipCountry = shipCountry;
    }

    public Orders() {
    }
    
    
}
