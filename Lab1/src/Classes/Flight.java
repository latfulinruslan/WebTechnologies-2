package Classes;


import java.util.UUID;

public class Flight {
    public String id;
    public String sourceAirport;
    public String destinationAirport;
    public String date;
    public FlightStatus flightStatus;
    public Plane plane;

    public Flight (String id,
                   String sourceAirport,
                   String destinationAirport,
                   String date,
                   FlightStatus flightStatus,
                   Plane plane) {
        this.id = id;
        this.sourceAirport = sourceAirport;
        this.destinationAirport = destinationAirport;
        this.date = date;
        this.flightStatus = flightStatus;
        this.plane = plane;
    }

    public Flight(String sourceAirport,
                  String destinationAirport,
                  String date,
                  FlightStatus flightStatus,
                  Plane plane) {
        this.id = getId();
        this.sourceAirport = sourceAirport;
        this.destinationAirport = destinationAirport;
        this.date = date;
        this.flightStatus = flightStatus;
        this.plane = plane;
    }

    private static String getId() {
        return UUID.randomUUID().toString();
    }

}
