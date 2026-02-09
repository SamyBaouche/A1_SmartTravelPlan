package travel;

import java.util.Objects;

public class Flight extends Transportation {

    private String airlineName;
    private double luggageAllowance;

    private final static double BASE_FLIGHT_PRICE = 400;

    public Flight() {
        super("", "", "");
        this.luggageAllowance = 0.0;
    }

    public Flight(String companyName, String departureCity,
                  String arrivalCity, double luggageAllowance) {

        super(companyName, departureCity, arrivalCity);
        this.luggageAllowance = luggageAllowance;
    }

    public Flight(Flight other) {
        super(other);
        this.airlineName = other.airlineName;
        this.luggageAllowance = other.luggageAllowance;
    }

    public double getLuggageAllowance() {
        return luggageAllowance;
    }

    public void setLuggageAllowance(double luggageAllowance) {
        this.luggageAllowance = luggageAllowance;
    }

    @Override
    public String toString() {
        return "Flight [" + super.toString() +
                ", Airline: " + airlineName +
                ", Luggage: " + luggageAllowance + "kg]";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        if (!super.equals(o)) return false;

        Flight other = (Flight) o;
        return Double.compare(luggageAllowance, other.luggageAllowance) == 0 && Objects.equals(airlineName, other.airlineName);
    }


    @Override
    public double calculateCost(int numberOfDays) {
        //Implemented luggageAllowance into the cost calcul
        return BASE_FLIGHT_PRICE + (luggageAllowance * 5);
    }
}
