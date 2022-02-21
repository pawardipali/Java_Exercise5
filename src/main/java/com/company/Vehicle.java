package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class Vehicle {
    int id;
    String brand;
    String model;
    int noOfSeats;
    String licensePlate;
    ArrayList<Vehicle> vehicleDetails = new ArrayList<>();

    public Vehicle(int id, String brand, String model, int noOfSeats, String licensePlate) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.noOfSeats = noOfSeats;
        this.licensePlate = licensePlate;
    }

    public Vehicle(){

    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }

    public String getLicensePlate() {
        return licensePlate;
    }
    public void getDescription(){
        System.out.println("Vehicle id : "+getId());
        System.out.println("Vehicle brand : "+getBrand());
        System.out.println("Vehicle model : "+getModel());
        System.out.println("Vehicle no of seats : "+getNoOfSeats());
        System.out.println("Vehicle license plate : "+getLicensePlate());
    }
    public String toString(){
        return getId() + " "+getBrand()+ " "+getModel()+" "+getNoOfSeats()+" "+getLicensePlate()/*+" "+getResult()*/;
    }
    public void getAllVehicles(Map<Integer,RentalData> rentalDataMap) throws IOException {
        String line = "";
        String splitBy = ",";
        BufferedReader br  = new BufferedReader(new FileReader("C:/Users/lenovo/Exercise5/src/main/resources/vehicle.csv"));
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] vehicle = line.split(splitBy);// use comma as separator
                int id= Integer.parseInt(vehicle[0]);
                String brand=vehicle[1];
                String model=vehicle[2];
                int noOfSeats= Integer.parseInt(vehicle[3]);
                String licensePlate=vehicle[4];
                Vehicle v=new Vehicle(id,brand,model,noOfSeats,licensePlate);
                vehicleDetails.add(v);

            }
//            ArrayList<Integer> keyList = rentalDataMap.keySet();
        for(Vehicle v:vehicleDetails) {
            for (Integer m : rentalDataMap.keySet()) {
                if (v.getId() == m) {
                    System.out.println("it is not available");

                }
            }
            System.out.println("Vehicle with id " +v.getId() + "  is  available");
        }

    }
}
