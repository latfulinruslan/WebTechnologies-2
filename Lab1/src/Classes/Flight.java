package Classes;


import java.util.UUID;

public class Flight {
    private String id;
    private String sourceAirport;
    private String destinationAirport;
    private String date;
    private FlightStatus flightStatus;
    private Plane plane;

    public Flight() {}

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
        this.id = getUniqueId();
        this.sourceAirport = sourceAirport;
        this.destinationAirport = destinationAirport;
        this.date = date;
        this.flightStatus = flightStatus;
        this.plane = plane;
    }

    private static String getUniqueId() {
        return UUID.randomUUID().toString();
    }

    public void setSourceAirport(String sourceAirport) {
        this.sourceAirport = sourceAirport;
    }

    public void setDestinationAirport(String destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    public void setFlightStatus(FlightStatus flightStatus) {
        this.flightStatus = flightStatus;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPlaneModel(String planeModel) {
        this.plane.setModel(planeModel);
    }

    public void setPlanePlaceCount(int placeCount) {
        this.plane.setCountOfPlaces(placeCount);
    }

    public String getSourceAirport() {
        return sourceAirport;
    }

    public String getDestinationAirport() {
        return destinationAirport;
    }

    public String getDate() {
        return date;
    }

    public FlightStatus getFlightStatus() {
        return flightStatus;
    }

    public Plane getPlane() {
        return plane;
    }

    public String getId() {
        return id;
    }
}
