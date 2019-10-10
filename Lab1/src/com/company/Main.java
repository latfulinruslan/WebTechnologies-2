package com.company;

import Classes.Airport;
import Classes.Flight;

import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException{
        List<Flight> flights = new ArrayList<>();
        Airport airport = new Airport(flights);

        boolean work = true;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        while (work) {
            Controller.showMainMenu();

            String result = in.readLine();
            switch (result) {
                case "1":
                    Controller.showFlights();
                    break;
                case "2":
                    Controller.addNewFlight();
                    break;
                case "3":
                    Controller.deleteFlight();
                case "4":
                    Controller.updateFlight();
                    break;
                case "0":
                    work = false;
                    break;
            }
        }
    }
}
