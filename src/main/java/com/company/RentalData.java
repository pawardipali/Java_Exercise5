package com.company;

import java.util.Map;

public class RentalData {
    String customerName;
    Vehicle vehicleData;
    String rentalStart;
    String rentalEnd;

    public RentalData(String customerName, Vehicle vehicleData, String rentalStart, String rentalEnd) {
        this.customerName = customerName;
        this.vehicleData = vehicleData;
        this.rentalStart = rentalStart;
        this.rentalEnd = rentalEnd;
    }

    public RentalData(){

    }

    public String getCustomerName() {
        return customerName;
    }

    public Vehicle getVehicleData() {
        return vehicleData;
    }

    public String getRentalStart() {
        return rentalStart;
    }

    public String getRentalEnd() {
        return rentalEnd;
    }
    public void getRentalDetails(){
        System.out.println(" Customer Name : "+ getCustomerName());
        System.out.println(" Vehicle Data : "+getVehicleData());
        System.out.println(" Rental Start Date : "+getRentalStart());
        System.out.println(" Rental End Date : "+getRentalEnd());

    }
    public String toString(){
        return getCustomerName() + " "+getVehicleData()+ " "+getRentalStart()+" "+getRentalEnd();
    }
    public Map<Integer,RentalData> AddRentedVehicleData(Map<Integer,RentalData> rentalDataMap){
        try{

            rentalDataMap.put(vehicleData.id, this);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return rentalDataMap;
    }
    public void PrintRentalVehicleDetails( Map<Integer,RentalData> rentalDataMap){
        for(Map.Entry m:rentalDataMap.entrySet()){
            System.out.println(m.getValue());
        }

    }
}
