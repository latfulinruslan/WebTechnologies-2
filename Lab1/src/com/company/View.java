package com.company;

import Classes.Flight;
import Classes.FlightStatus;
import Classes.Plane;
import helpers.DataManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class View {

    public static void showMainMenu() {
        System.out.println("Main menu:");
        System.out.println("1. Show flights.");
        System.out.println("2. Add new flight");
        System.out.println("3. Delete flight");
        System.out.println("4. Update flight");
        System.out.println("0. Exit.");
    }

    public static void showFlights(List<Flight> flights) {
        int index = 1;
        for(Flight flight: flights) {
            System.out.println(index + " From: " + flight.getSourceAirport() +
                    " To: " + flight.getDestinationAirport() +
                    " Date: " + flight.getDate() +
                    " Status: " + flight.getFlightStatus() +
                    " Plane: " + flight.getPlane().getModel() +
                    " Places: " + flight.getPlane().getCountOfPlaces());
            index += 1;
        }
    }

    public static void getNewFlight(Flight flight) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter source airport");
        flight.setSourceAirport(in.readLine());
        System.out.println("Enter destination airport");
        flight.setDestinationAirport(in.readLine());
        System.out.println("Enter date");
        flight.setDate(in.readLine());
        flight.setFlightStatus(FlightStatus.OPEN);
        System.out.println("Enter plane model");
        flight.setPlaneModel(in.readLine());
        System.out.println("Enter count of places");
        flight.setPlanePlaceCount(Integer.valueOf(in.readLine()));
    }

    public static int getDeleteIndex() throws IOException {
        System.out.println("What flight you prefer to delete?");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        return Integer.valueOf(in.readLine());
    }

    public static int getUpdateIndex() throws IOException {
        System.out.println("What flight you prefer to update?");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        return Integer.valueOf(in.readLine());
    }

    public static void getUpdatedFlight(Flight flight) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("What you want to update?");

        System.out.println("1. Source airport");
        System.out.println("2. Destination airport");
        System.out.println("3. Date");
        System.out.println("4. Status(1:OPEN, 2:CANCELLED, 3:DEPARTED)");
        System.out.println("5. Plane model");
        System.out.println("6. Count of places");
        System.out.println("0. Exit.");

        String answer = in.readLine();

        switch (answer) {
            case "1":
                System.out.println("Input new source airport");
                flight.setSourceAirport(in.readLine());
                break;
            case "2":
                System.out.println("Input new destination airport");
                flight.setDestinationAirport(in.readLine());
                break;
            case "3":
                System.out.println("Input new date: ");
                flight.setDate(in.readLine());
                break;
            case "4":
                System.out.println("Input new status of flight: ");
                String newStatus = in.readLine();
                switch (newStatus) {
                    case "1":
                        flight.setFlightStatus(FlightStatus.OPEN);
                        break;
                    case "2":
                        flight.setFlightStatus(FlightStatus.CANCELLED);
                        break;
                    case "3":
                        flight.setFlightStatus(FlightStatus.DEPARTED);
                        break;
                }
                break;
            case "5":
                System.out.println("Input new plane model: ");
                flight.setPlaneModel(in.readLine());
                break;
            case "6":
                System.out.println("Input new count of places: ");
                flight.setPlanePlaceCount(Integer.valueOf(in.readLine()));
                break;
            case "0":
                break;
        }
    }

}
