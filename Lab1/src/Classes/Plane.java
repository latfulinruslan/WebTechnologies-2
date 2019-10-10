package Classes;

public class Plane {
    private String model;
    private int countOfPlaces;

    public Plane(String model, int countOfPlaces) {
        this.model = model;
        this.countOfPlaces = countOfPlaces;
    }

    public String getModel() {
        return model;
    }

    public int getCountOfPlaces() {
        return countOfPlaces;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setCountOfPlaces(int countOfPlaces) {
        this.countOfPlaces = countOfPlaces;
    }
}
