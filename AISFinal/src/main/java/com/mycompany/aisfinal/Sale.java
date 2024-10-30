/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aisfinal;

/**
 *
 * @author 2167543
 */
public class Sale {

    public Sale(Automobile vehicle1, Customer customer1, String calculateTotalPrice, int day, int month, int year) {
    }
    private Automobile vehicle;
    private Customer customer;
    private double salesPrice;
    private int dateDay;
    private int dateMonth;
    private int dateYear;

    public Automobile getVehicle() {
        return vehicle;
    }

    public void setVehicle(Automobile vehicle) {
        this.vehicle = vehicle;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(double salesPrice) {
        this.salesPrice = salesPrice;
    }

    public int getDateDay() {
        return dateDay;
    }

    public void setDateDay(int dateDay) {
        this.dateDay = dateDay;
    }

    public int getDateMonth() {
        return dateMonth;
    }

    public void setDateMonth(int dateMonth) {
        this.dateMonth = dateMonth;
    }

    public int getDateYear() {
        return dateYear;
    }

    public void setDateYear(int dateYear) {
        this.dateYear = dateYear;
    }
}


