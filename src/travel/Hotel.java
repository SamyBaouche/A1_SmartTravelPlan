package travel;

import java.util.Objects;

/**
 * The Hotel class represents a type of Accommodation
 * with a star rating.
 * It extends the Accommodation class.
 */
public class Hotel extends Accommodation {

    private int starRating;

    /**
     * Default constructor.
     * Calls parent constructor and initializes starRating to 0.
     */
    public Hotel() {
        super();
        this.starRating = 0;
    }

    /**
     * Parameterized constructor.
     * Initializes hotel name, location, price per night, and star rating.
     */
    public Hotel(String name, String location, double pricePerNight, int starRating) {
        super(name, location, pricePerNight);
        this.starRating = starRating;
    }

    /**
     * Copy constructor.
     * Creates a new Hotel object based on another Hotel.
     */
    public Hotel(Hotel other) {
        super(other);
        this.starRating = other.starRating;
    }

    // Getters and Setters

    public int getStarRating() {
        return starRating;
    }

    public void setStarRating(int starRating) {
        this.starRating = starRating;
    }

    /**
     * Returns a formatted string representation of the Hotel.
     */
    @Override
    public String toString() {
        return "Hotel [" + super.toString() +
                ", Stars: " + starRating + "]";
    }

    /**
     * Overrides equals method.
     * Two Hotels are equal if:
     * - Their parent attributes are equal
     * - They have the same star rating
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Hotel other = (Hotel) o;
        return starRating == other.starRating;
    }

    /**
     * Calculates the cost of staying in the hotel.
     * Total cost = price per night * number of days.
     */
    @Override
    public double calculateCost(int numberOfDays) {
        return getPricePerNight() * numberOfDays;
    }
}
