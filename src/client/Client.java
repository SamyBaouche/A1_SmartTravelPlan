package client;

import java.util.Objects;

/**
 * The Client class represents a customer in the travel system.
 * Each client has a unique ID, a first name, a last name, and an email.
 */
public class Client {

    private String clientId;
    private String firstName;
    private String lastName;
    private String email;

    private static int idCounter = 1001;

    /**
     * Default constructor.
     * Creates a client with empty fields and an auto-generated ID.
     */

    public Client() {
        this.clientId = "C" + idCounter;
        idCounter++;

        this.firstName = "";
        this.lastName = "";
        this.email = "";
    }

    /**
     * Parameterized constructor.
     * Creates a client with provided personal information
     * and an auto-generated ID.
     */

    public Client(String firstName,
                  String lastName, String email) {

        this.clientId = "C" + idCounter;
        idCounter++;

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    /**
     * Copy constructor.
     * Creates a new Client object based on another Client.
     * A new unique ID is generated.
     */
    public Client (Client other) {
        this.clientId = "C" + idCounter;
        idCounter++;

        this.firstName = other.firstName;
        this.lastName = other.lastName;
        this.email = other.email;

    }

    // Getters and Setters
    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns a formatted string representation of the Client object.
     */
    @Override
    public String toString() {
        return "Client Info: " +
                "[ID: " + clientId +
                ", Name: " + firstName + " " + lastName +
                ", Email: " + email + "]";
    }

    /**
     * Overrides the equals method to compare two Client objects.
     * Two clients are considered equal if all their attributes are equal.
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Client other = (Client) o;
        return Objects.equals(clientId, other.clientId) &&
                Objects.equals(firstName, other.firstName) &&
                Objects.equals(lastName, other.lastName) &&
                Objects.equals(email, other.email);
    }


}

