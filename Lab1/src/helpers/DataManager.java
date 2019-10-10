package helpers;

import Classes.Flight;
import Classes.FlightStatus;
import Classes.Plane;

import java.io.*;
import java.util.*;

public class DataManager {
    public static void updateData(List<Flight> flights) throws IOException {
        List<List<String>> rows = new LinkedList<>(Arrays.asList());
        for (Flight flight : flights) {
            rows.add(Arrays.asList(flight.getId(),
                    flight.getSourceAirport(),
                    flight.getDestinationAirport(),
                    flight.getDate(),
                    flight.getFlightStatus().name(),
                    flight.getPlane().getModel(),
                    Integer.toString(flight.getPlane().getCountOfPlaces())));
        }

        FileWriter csvWriter = new FileWriter("flights.csv");
        csvWriter.append("Id");
        csvWriter.append(";");
        csvWriter.append("Source");
        csvWriter.append(";");
        csvWriter.append("Destination");
        csvWriter.append(";");
        csvWriter.append("Date");
        csvWriter.append(";");
        csvWriter.append("Status");
        csvWriter.append(";");
        csvWriter.append("Plane");
        csvWriter.append(";");
        csvWriter.append("CountOfPlaces");
        csvWriter.append("\n");

        for (List<String> rowData : rows) {
            csvWriter.append(String.join(";", rowData));
            csvWriter.append("\n");
        }

        csvWriter.flush();
        csvWriter.close();
    }

    public static List<Flight> Decode() throws IOException {
        BufferedReader csvReader = new BufferedReader(new FileReader("flights.csv"));
        String row;
        int iteration = 0;
        List<Flight> flights = new ArrayList<>();
        while ((row = csvReader.readLine()) != null) {
            if(iteration == 0) {
                iteration++;
                continue;
            }
            String[] data = row.split(";");
            flights.add(new Flight(data[0], data[1], data[2], data[3], FlightStatus.valueOf(data[4]),new Plane(data[5], Integer.valueOf(data[6]))));
        }
        csvReader.close();
        return flights;
    }
}
