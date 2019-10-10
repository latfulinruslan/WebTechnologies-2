package Classes;

import helpers.DataManager;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.io.IOException;

public class Airport {

    List<Flight> flights;

    public Airport(List<Flight> flights) {
        this.flights = flights;
    }

    public void showMainMenu() {
        System.out.println("Main menu:");
        System.out.println("1. Show flights.");
        System.out.println("2. Add new flight");
        System.out.println("3. Delete flight");
        System.out.println("4. Update flight");
        System.out.println("0. Exit.");
    }

    public void showFlights() throws IOException{
        flights = DataManager.Decode();
        int index = 1;
        for(Flight flight: flights) {
            System.out.println(index + " From: " + flight.sourceAirport +
                                       " To: " + flight.destinationAirport +
                                       " Date: " + flight.date +
                                       " Status: " + flight.flightStatus +
                                       " Plane: " + flight.plane.getModel() +
                                       " Places: " + flight.plane.getCountOfPlaces());
            index += 1;
        }

    }

    public void addNewFlight() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter source airport");
        String sourceAirport = in.readLine();
        System.out.println("Enter destination airport");
        String destinationAirport = in.readLine();
        System.out.println("Enter date");
        String date = in.readLine();
        System.out.println("Enter plane model");
        String planeModel = in.readLine();
        System.out.println("Enter count of places");
        String countOfPlaces = in.readLine();

        flights.add(new Flight(sourceAirport, destinationAirport, date, FlightStatus.OPEN, new Plane(planeModel, Integer.valueOf(countOfPlaces))));
        DataManager.updateData(flights);
    }

    public void deleteFlight() throws IOException {
        System.out.println("What flight you prefer to delete?");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int answer = Integer.valueOf(in.readLine());
        flights.remove(answer - 1);
        DataManager.updateData(flights);
    }

    public void updateFlight() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Input flight id: ");
        int flightId = Integer.valueOf(in.readLine()) - 1;
        Flight gettedFlight = flights.get(flightId);

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
                gettedFlight.sourceAirport = in.readLine();
                break;
            case "2":
                System.out.println("Input new destination airport");
                gettedFlight.destinationAirport = in.readLine();
                break;
            case "3":
                System.out.println("Input new date: ");
                gettedFlight.date = in.readLine();
                break;
            case "4":
                System.out.println("Input new status of flight: ");
                String newStatus = in.readLine();
                switch (newStatus) {
                    case "1":
                        gettedFlight.flightStatus = FlightStatus.OPEN;
                        break;
                    case "2":
                        gettedFlight.flightStatus = FlightStatus.CANCELLED;
                        break;
                    case "3":
                        gettedFlight.flightStatus = FlightStatus.DEPARTED;
                        break;
                }
                break;
            case "5":
                System.out.println("Input new plane model: ");
                gettedFlight.plane.setModel(in.readLine());
                break;
            case "6":
                System.out.println("Input new count of places: ");
                gettedFlight.plane.setCountOfPlaces(Integer.valueOf(in.readLine()));
                break;
        }

        DataManager.updateData(flights);
    }
}
