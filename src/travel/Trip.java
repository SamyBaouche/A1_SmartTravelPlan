package travel;

import client.Client;
import com.sun.jdi.connect.Transport;

public class Trip {

    private String tripID;
    private String destination;
    private int durationInDays;
    private double basePrice;
    private Client clientAssociated;

    private Accommodation accommodation;
    private Transportation transportation;

    private static int tripIdCounter = 2001;

    public Trip(String destination, int durationInDays, double basePrice, Client client) {
        this.tripID = "T" + tripIdCounter++;
        this.destination = destination;
        this.durationInDays = durationInDays;
        this.basePrice = basePrice;
        this.clientAssociated = client;
    }

    public Trip () {
        this.tripID = "T" + tripIdCounter++;
        this.destination = "";
        this.durationInDays = 0;
        this.basePrice = 0;
    }


    public Trip(Trip trip) {
        this.tripID = "T" + tripIdCounter++;
        this.destination = trip.getDestination();
        this.durationInDays = trip.getDurationInDays();
        this.basePrice = trip.getBasePrice();
        this.clientAssociated = trip.getClientAssociated();
    }

    public double calculateTotalCost() {
        double cost = 0;
        cost += basePrice;

        if (accommodation != null) {
            cost += accommodation.calculateCost(durationInDays);
        }

        if (transportation != null) {
            cost += transportation.calculateCost(durationInDays);
        }

        return cost;
    }

    public String getTripId() {
        return tripID;
    }

    public void setTripId(String tripID) {
        this.tripID = tripID;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getDurationInDays() {
        return durationInDays;
    }

    public void setDurationInDays(int durationInDays) {
        this.durationInDays = durationInDays;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public Client getClientAssociated() {
        return clientAssociated;
    }

    public void setClientAssociated(Client clientAssociated) {
        this.clientAssociated = clientAssociated;
    }

    public Transportation getTransportation() {
        return transportation;
    }

    public void setTransportation(Transportation transportation) {
        this.transportation = transportation;
    }

    public Accommodation getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(Accommodation accommodation) {
        this.accommodation = accommodation;
    }
}
