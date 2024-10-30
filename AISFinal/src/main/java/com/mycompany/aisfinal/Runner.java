/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aisfinal;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;



/**
 *
 * @author 2167543
 */
public class Runner {
   
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the Automotive Inventory System\n");

        System.out.print("How many vehicles does your dealership hold? ");
        int totalSpots = input.nextInt();
        input.nextLine();

        Dealership dealership = new Dealership("My Dealership", new Address("123 Main St", "City", "State", "Country", "12345"));
        dealership.createLot(totalSpots);

        int choice;
        do {
            System.out.println("\nPlease choose from the options below:");
            System.out.println("0 – Add vehicles");
            System.out.println("1 – Sale a vehicle");
            System.out.println("2 – End and Save");

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 0:
                    addVehicles(input, dealership);
                    break;
                case 1:
                    saleVehicle(input, dealership);
                    break;
                case 2:
                    endAndSave(input, dealership);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 2);

        input.close();
    }

    private static void addVehicles(Scanner input, Dealership dealership) {
        System.out.print("How many vehicles would you like to add? ");
        int numVehicles = input.nextInt();
        input.nextLine();

        for (int i = 0; i < numVehicles; i++) {
            System.out.println("Let's add vehicle " + i);
            System.out.println("What type of vehicle is this?");
            System.out.println("0 – Car");
            System.out.println("1 – Truck");

            int vehicleType;
            do {
                vehicleType = input.nextInt();
                input.nextLine();
                if (vehicleType != 0 && vehicleType != 1) {
                    System.out.println("Invalid input – only 0 or 1 allowed");
                    System.out.println("Please choose again:");
                }
            } while (vehicleType != 0 && vehicleType != 1);

            if (vehicleType == 0) {
                addCar(input, dealership);
            } else {
                addTruck(input, dealership);
            }
        }
    }

    private static void addCar(Scanner input, Dealership dealership) {
        System.out.print("What is the car’s make? ");
        String make = input.nextLine();

        System.out.print("What is the car’s model? ");
        String model = input.nextLine();

        System.out.print("What features does the car have? ");
        String features = input.nextLine();

        System.out.print("What is the car’s price? ");
        double price = input.nextDouble();
        input.nextLine();

        System.out.print("What is the dealer markup on the car? ");
        double dealerMarkup = input.nextDouble();
        input.nextLine();

        System.out.print("Does the car have a spoiler? (y/n): ");
        boolean spoiler = input.nextLine().equalsIgnoreCase("y");

        System.out.print("Does the car have a sunroof? (y/n): ");
        boolean sunroof = input.nextLine().equalsIgnoreCase("y");

        System.out.print("How many doors does this car have? ");
        int numDoors = input.nextInt();
        input.nextLine();

        Car car = new Car(make, model, features, price, dealerMarkup, spoiler, sunroof, numDoors);
        dealership.addVehicle(car);
    }

    private static void addTruck(Scanner input, Dealership dealership) {
        System.out.print("What is the truck’s make? ");
        String make = input.nextLine();

        System.out.print("What is the truck’s model? ");
        String model = input.nextLine();

        System.out.print("What features does the truck have? ");
        String features = input.nextLine();

        System.out.print("What is the truck’s price? ");
        double price = input.nextDouble();
        input.nextLine();

        System.out.print("What is the dealer markup on the truck? ");
        double dealerMarkup = input.nextDouble();
        input.nextLine();

        System.out.print("What is the truck’s bed length? ");
        double bedLength = input.nextDouble();
        input.nextLine();

        System.out.print("Is the truck a quad cab? (y/n): ");
        boolean quadCab = input.nextLine().equalsIgnoreCase("y");

        System.out.print("Is the truck a super cab? (y/n): ");
        boolean superCab = input.nextLine().equalsIgnoreCase("y");

        Truck truck = new Truck(make, model, features, price, dealerMarkup, bedLength, quadCab, superCab);
        dealership.addVehicle(truck);
    }

    private static void saleVehicle(Scanner input, Dealership dealership) {
        if (dealership.getAvailableSpots() == dealership.getTotalSpots()) {
            System.out.println("There are no vehicles currently stored on the lot");
            return;
        }

        System.out.println("Please select a vehicle from the following list:");
        dealership.displayAvailableVehicles();

        System.out.print("Which vehicle would you like to sell? ");
        int chosenSpot = input.nextInt();
        input.nextLine();

        Automobile vehicle = dealership.getAvailableVehicle(chosenSpot);
        if (vehicle == null) {
            System.out.println("Invalid spot number. No vehicle found.");
            return;
        }

        System.out.println("The sale’s price for this " + vehicle.getMake() + " " + vehicle.getModel() + " is $" + vehicle.calculateTotalPrice());
        System.out.print("What is the customer’s name? ");
        String customerName = input.nextLine();

        System.out.print("What day is it? ");
        int day = input.nextInt();
        input.nextLine();

        System.out.print("What month is it? (1-12) ");
        int month = input.nextInt();
        input.nextLine();

        System.out.print("What year is it? ");
        int year = input.nextInt();
        input.nextLine();

        Customer customer = new Customer(customerName);
        Sale sale = new Sale(vehicle, customer, vehicle.calculateTotalPrice(), day, month, year);
        dealership.makeSale(sale);
        System.out.println("The " + vehicle.getMake() + " " + vehicle.getModel() + " has been sold to " + customerName);
    }

    private static void endAndSave(Scanner input, Dealership dealership) {
        System.out.print("Save file name: ");
        String fileName = input.nextLine();

        try (FileWriter writer = new FileWriter(fileName)) {
            String salesInfo = dealership.generateReceipts();
            writer.write(salesInfo);
            System.out.println("Saved sales information to " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while saving the file.");
        }
    }
}
