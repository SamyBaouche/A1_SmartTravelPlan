package travel;

import java.util.Objects;

public abstract class  Transportation {

    private String transportId;
    private String companyName;
    private String departureCity;
    private String arrivalCity;

    private static int idCounter = 3001;

    public Transportation() {
        this.transportId = "TR" + idCounter;
        idCounter++;

        this.companyName = "";
        this.departureCity = "";
        this.arrivalCity = "";
    }

    public Transportation (String companyName,
                          String departureCity, String arrivalCity) {

        this.transportId = "TR" + idCounter;
        idCounter++;

        this.companyName = companyName;
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
    }

    public Transportation (Transportation other) {
        this.transportId = "TR" + idCounter;
        idCounter++;

        this.companyName = other.companyName;
        this.departureCity = other.departureCity;
        this.arrivalCity = other.arrivalCity;
    }

    public String getTransportId() {
        return transportId;
    }

    public void setTransportId(String transportId) {
        this.transportId = transportId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    @Override
    public String toString() {
        return "ID: " + transportId +
                ", Company: " + companyName +
                ", Route: " + departureCity + " -> " + arrivalCity;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Transportation other = (Transportation) o;
        return  Objects.equals(companyName, other.companyName)
                && Objects.equals(departureCity, other.departureCity)
                && Objects.equals(arrivalCity, other.arrivalCity);
    }

    public abstract double calculateCost(int numberOfDays);

}
