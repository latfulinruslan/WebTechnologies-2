package com.company;
import Classes.Flight;

import helpers.DataManager;
import java.util.List;
import java.io.IOException;

public class Controller {

    public static void showMainMenu() {
        View.showMainMenu();
    }

    public static void showFlights() throws IOException {
        List<Flight> flights;
        flights = DataManager.Decode();

        View.showFlights(flights);
    }

    public static void addNewFlight() throws IOException{
        List<Flight> flights;
        flights = DataManager.Decode();

        Flight newFlight = new Flight();
        View.getNewFlight(newFlight);

        flights.add(newFlight);
        DataManager.updateData(flights);
    }

    public static void deleteFlight() throws IOException {
        List<Flight> flights;
        flights = DataManager.Decode();

        int index = View.getDeleteIndex();

        flights.remove( index - 1);
        DataManager.updateData(flights);
    }

    public static void updateFlight() throws IOException {
        List<Flight> flights;
        flights = DataManager.Decode();

        int flightId = View.getUpdateIndex() - 1;
        Flight gettedFlight = flights.get(flightId);

        View.getUpdatedFlight(gettedFlight);

        DataManager.updateData(flights);
    }

}
