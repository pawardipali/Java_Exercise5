package com.company;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) throws ParseException {

        Map<Integer, RentalData> rentalDataMap = new HashMap<Integer, RentalData>();

        boolean flag = true;
        System.out.println("*******************************************");
        System.out.println("Welcome to the Car Rental Management System");
        System.out.println("*******************************************");
        System.out.println("Press 1 to add rental data");
        System.out.println("Press 2 to get List of rentel vehicles and rented data");
        System.out.println("Press 3 to get List of available vehicle and data");
        try {

            while (flag) {
                Scanner scan = new Scanner(System.in);
                System.out.print("Enter Your Choice : ");
                int choice = scan.nextInt();
                scan.nextLine();
                switch (choice) {
                    case 1:
                        System.out.println("Enter the data ");
                        int min = 2000;
                        int max = 4000;
                        int id = (int)(Math.random()*(max-min+1)+min);
                        System.out.print("Enter the name of customer: ");
                        String customerName = scan.nextLine();
                        System.out.print("Enter the brand of vehicle: ");
                        String brand = scan.nextLine();
                        System.out.print("Enter the model of vehicle: ");
                        String model = scan.nextLine();
                        System.out.print("Enter the no of seats vehicle: ");
                        Integer noOfSeats = scan.nextInt();
                        scan.nextLine();
                        System.out.print("Enter the license plate of vehicle: ");
                        String licensePlate = scan.nextLine();
                        System.out.print("Enter the rentalStart: ");
                        String rentalStart = scan.nextLine();
                        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(rentalStart);
                        System.out.println(rentalStart+"\t"+date1);
                        System.out.print("Enter the rentalEnd: ");
                        String rentalEnd = scan.nextLine();
                        Date date2=new SimpleDateFormat("dd/MM/yyyy").parse(rentalEnd);
                        System.out.println(rentalEnd+"\t"+date2);
                        Vehicle vehicle=new Vehicle(id,brand,model,noOfSeats,licensePlate);
                        RentalData rentalData=new RentalData(customerName,vehicle,rentalStart,rentalEnd);
                        rentalData.AddRentedVehicleData(rentalDataMap);
                        break;
                    case 2:
                        System.out.println("The list of Rented Vehicles:");
                        RentalData rentalData1 = new RentalData();
                        rentalData1.PrintRentalVehicleDetails(rentalDataMap);
                        //code to be executed;
                        break;  //optional
                    case 3:
                        System.out.println("The list of available Vehicles: ");
                        Vehicle v=new Vehicle();
                        v.getAllVehicles(rentalDataMap);
                        break;
                    default:
                        flag = false;
                        break;
                }
            }
        }
        catch(Exception e)
            {
                e.printStackTrace();
            }
        }
}
