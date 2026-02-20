package travel;

import java.util.Objects;


/**
 * The Hostel class represents a type of Accommodation
 * where guests share beds (dormitory style).
 * It extends the Accommodation class.
 */

public class Hostel extends Accommodation {

    private int sharedBeds;

    /**
     * Default constructor.
     * Calls the parent constructor and initializes sharedBeds to 0.
     */
    public Hostel() {
        super();
        this.sharedBeds = 0;
    }

    /**
     * Parameterized constructor.
     * Initializes hostel information including shared beds.
     */
    public Hostel(String name, String location, double pricePerNight, int sharedBeds) {
        super(name, location, pricePerNight);
        this.sharedBeds = sharedBeds;
    }

    /**
     * Copy constructor.
     * Creates a new Hostel object based on another Hostel.
     */
    public Hostel(Hostel other) {
        super(other);
        this.sharedBeds = other.sharedBeds;
    }

    // Getters and Setters

    public int getSharedBeds() {
        return sharedBeds;
    }

    public void setSharedBeds(int sharedBeds) {
        this.sharedBeds = sharedBeds;
    }

    /**
     * Returns a formatted string representation of the Hostel.
     */
    @Override
    public String toString() {
        return "Hostel [" + super.toString() +
                ", Shared Beds: " + sharedBeds + "]";
    }

    /**
     * Overrides equals method.
     * Two Hostels are equal if:
     * - Their parent attributes are equal
     * - They have the same number of shared beds
     */

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Hostel other = (Hostel) o;
        return sharedBeds == other.sharedBeds;
    }

    /**
     * Calculates the cost of staying in the hostel.
     * The total price is divided by the number of shared beds,
     * since the room is shared among multiple guests.
     */
    @Override
    public double calculateCost(int numberOfDays) {
        return (getPricePerNight() * numberOfDays) / sharedBeds;
    }
}
