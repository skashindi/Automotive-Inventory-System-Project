/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aisfinal;

/**
 *
 * @author 2167543
 */
public class Truck extends Automobile {

    public Truck(String make, String model, String features, double price, double dealerMarkup, double bedLength1, boolean quadCab1, boolean superCab1) {
    }
    private double bedLength;
    private boolean quadCab;
    private boolean superCab;

    public double getBedLength() {
        return bedLength;
    }

    public void setBedLength(double bedLength) {
        this.bedLength = bedLength;
    }

    public boolean isQuadCab() {
        return quadCab;
    }

    public void setQuadCab(boolean quadCab) {
        this.quadCab = quadCab;
    }

    public boolean isSuperCab() {
        return superCab;
    }

    public void setSuperCab(boolean superCab) {
        this.superCab = superCab;
    }
}

