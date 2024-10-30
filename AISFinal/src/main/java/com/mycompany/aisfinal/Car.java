/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aisfinal;

/**
 *
 * @author 2167543
 */
public class Car extends Automobile {

    public Car(String make, String model, String features, double price, double dealerMarkup, boolean spoiler1, boolean sunroof1, int numDoors1) {
    }
    private boolean spoiler;
    private boolean sunroof;
    private int numDoors;

    public boolean isSpoiler() {
        return spoiler;
    }

    public void setSpoiler(boolean spoiler) {
        this.spoiler = spoiler;
    }

    public boolean isSunroof() {
        return sunroof;
    }

    public void setSunroof(boolean sunroof) {
        this.sunroof = sunroof;
    }

    public int getNumDoors() {
        return numDoors;
    }

    public void setNumDoors(int numDoors) {
        this.numDoors = numDoors;
    }
}

