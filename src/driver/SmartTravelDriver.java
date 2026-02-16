package driver;

import client.Client;
import travel.*;

import java.io.IOException;
import java.util.Scanner;

public class SmartTravelDriver {

    static Scanner sc = new Scanner(System.in);

    static Client[] clients = new Client[0];
    static Transportation[] transportations = new Transportation[1000];
    static Accommodation[] accommodations = new Accommodation[1000];
    static Trip[] trips = new Trip[1000];
    static int accommodationCount = 0;
    static int tripCount = 0;
    static int transportationCount = 0;

    public static void main(String[] args) throws IOException {

        System.out.println();
        System.out.println("Welcome to SmartTravelPlanner by: \n" +
                "   Mohammed El Ouaabani and Samy Baouche \n");

        System.out.print("What would you like to access: \n" +
                "   1- Menu-driven interface \n" +
                "   2- Predefined testing scenario \n" +
                "Enter your choice > ");

        int optionChoice = sc.nextInt();

        switch (optionChoice) {

            //Menu driven interface
            case 1 -> {

                int choiceMenu;

                do {
                    choiceMenu = mainMenu();

                    switch (choiceMenu) {
                        case 1 -> {
                            System.out.println();
                            clientManagement();
                        }

                        case 2 -> {
                            System.out.println();
                            tripManagement();
                        }

                        case 3 -> {
                            System.out.println();
                            transportationManagement();
                        }
                        case 4 -> {
                            System.out.println();
                            accommodationManagement();
                        }

                        case 5 -> {
                            System.out.println();
                            additionalOperations();
                        }


                        case 0 -> {
                            System.out.println("Thank you for using our Smart Travel Planner");
                        }
                    }
                } while (choiceMenu != 0);

            }

            //Predefined testing scenario
            case 2 -> {

                System.out.println("\n      1. Creating... \n" +
                        "- 3 Clients \n" +
                        "- 3 Trips \n" +
                        "- 2 Objects of each Transportation Type \n" +
                        "- 2 Objects of each Accomodation Type");

                //3 Clients
                Client client1 = new Client("Jacob", "Delaire", "jacob.delaire@gmail.com");
                Client client2 = new Client("Nathan", "Blo", "nathan.blo@gmail.com");
                Client client3 = new Client("Mohammed", "Baouche", "mohammed.baouche@gmail.com");

                //2 Flights
                Flight flight1 = new Flight("Air Transat", "Montreal", "Fort Laudertale", 22);
                Flight flight2 = new Flight("Air Canada", "Montreal", "Barcelona", 22);

                //2 Buses
                Bus bus1 = new Bus("Chartrand", "Fort Laudertale", "Miami", 30);
                Bus bus2 = new Bus("Irizar", "Barcelona", "Marbella", 12);

                //2 Trains
                Train train1 = new Train("Trans-Canada", "Montreal", "Vancouver", "TGV", "First Class");
                Train train2 = new Train("Trans-Canada", "Montreal", "Vancouver", "TGV", "First Class");

                //2 Hotels
                Hotel hotel1 = new Hotel("Marriott", "Barcelona", 100, 4);
                Hotel hotel2 = new Hotel("Hilton", "Miami", 65, 3);

                //2 Hostels
                Hostel hostel1 = new Hostel("SleepInPeace", "Vancouver", 90, 3);
                Hostel hostel2 = new Hostel("SleepInPeace", "Vancouver", 90, 3);

                //3 Trips
                Trip trip1 = new Trip("Vancouver", 14, 600, client1, hostel1, train1);
                Trip trip2 = new Trip("Miami", 10, 400, client2, hotel2, bus1);
                Trip trip3 = new Trip("Barcelona", 21, 900, client3, hotel1, flight2);

                    //Arrays for objects

                //Clients Array (for 3 clients)
                Client[] clientsPredef = {client1, client2, client3};

                //Trips Array
                Trip[] tripsPredef = {trip1, trip2, trip3};

                //Transportation Array
                Transportation[] transportationsPredef = {train1, train2, bus1, bus2, flight1, flight2};

                //Accomodation Array
                Accommodation[] accommodationsPredef = {hotel1, hotel2, hostel1, hostel2};

                System.out.println("\n      2. Display all created objects\n");

                System.out.println("Clients:");
                for (Client client: clientsPredef) {
                    System.out.println("    " + client);
                }

                System.out.println("\nTrips:");
                for (Trip trip: tripsPredef) {
                    System.out.println("    " + trip);
                }

                System.out.println("\nTransportation Options:");
                for (Transportation transportation: transportationsPredef) {
                    System.out.println("    " + transportation);
                }

                System.out.println("\nAccommodations");
                for (Accommodation accommodation: accommodationsPredef) {
                    System.out.println("    " + accommodation);
                }

                System.out.println("\n      3. Test of the equals method:\n");
                System.out.println("-- Equals of a Flight and a Train");
                System.out.println(flight1.equals(train1));
                System.out.println("-- Equals of two Hotels (Different attributes)");
                System.out.println(hotel1.equals(hotel2));
                System.out.println("-- Equals of two Trains (Identical attributes)");
                System.out.println(train1.equals(train2));

                System.out.println("\n      4. Cost of the Trips\n");
                for (Trip trip: tripsPredef) {
                    System.out.println(trip.getTripId() + ": " + trip.calculateTotalCost() + "$");
                }

                System.out.println("\n      5. Most expensive Trip\n" );
                mostExpensiveTrip(tripsPredef);

                System.out.println("\n      6. Deep copie of the Transportation Array\n");

                System.out.println("Making the deep copy...\n");
                Transportation[] transportationsCopy = copyTransportationArray(transportationsPredef);

                System.out.println("-- Displaying both Arrays --\n");
                System.out.println("Original");
                for (Transportation transportation: transportationsPredef) {
                    System.out.println("    " + transportation);
                }

                System.out.println("\nCopy");
                for (Transportation transportation: transportationsCopy) {
                    System.out.println("    " + transportation);
                }

                System.out.println("\nModify the copy Array...\n");
                transportationsCopy[0].setCompanyName("Unknown Company");

                System.out.println("-- Display both Arrays AFTER MODIFICATION --\n");

                System.out.println("Original");
                for (Transportation transportation: transportationsPredef) {
                    System.out.println("    " + transportation);
                }

                System.out.println("\nCopy");
                for (Transportation transportation: transportationsCopy) {
                    System.out.println("    " + transportation);
                }
            }
        }

    }

    public static int mainMenu() {

        int choice;

        do {
            System.out.println();
            System.out.println("-- Choose one of the operations below -- ");
            System.out.println();
            System.out.println("1. Client Management");
            System.out.println("2. Trip Management");
            System.out.println("3. Transportation Management");
            System.out.println("4. Accomodation Management");
            System.out.println("5. Additional Operations");
            System.out.println("0. Exit");
            System.out.print("> ");

            choice = sc.nextInt();
        } while (choice < 0 || choice > 5);

        return choice;
    }

    public static void mostExpensiveTrip(Trip[] trips) {

        if (trips.length != 0) {
            double topPrice = 0;

            Trip mostExpensiveTrip = new Trip();

            for (Trip trip : trips) {
                double costTrip = trip.calculateTotalCost();
                if (costTrip > topPrice) {
                    topPrice = costTrip;
                    mostExpensiveTrip = trip;
                }
            }

            System.out.println("The most expensive trip is: " + mostExpensiveTrip.getTripId());
        } else {
            System.out.println("There are no trips to compare");
        }
    }

    public static Transportation[] copyTransportationArray(Transportation[] original) {

        Transportation[] copy = new Transportation[original.length];

        for (int i = 0; i < original.length; i++) {
            if (original[i] instanceof Flight) {
                copy[i] = new Flight((Flight) original[i]);
            } else if (original[i] instanceof Train) {
                copy[i] = new Train((Train) original[i]);
            } else if (original[i] instanceof Bus) {
                copy[i] = new Bus((Bus) original[i]);
            }
        }

        return copy;

    }

    public static Accommodation[] copyAccommodationArray(Accommodation[] original) {

        Accommodation[] copy = new Accommodation[original.length];

        for (int i = 0; i < original.length; i++) {
            if (original[i] instanceof Hotel) {
                copy[i] = new Hotel((Hotel) original[i]);
            } else if (original[i] instanceof Hostel) {
                copy[i] = new Hostel((Hostel) original[i]);
            }
        }

        return copy;

    }

    public static void clientManagement() {
        int choice;
        do {
            System.out.println("-- Client Management --\n");
            System.out.println("1. Add a client\n" +
                    "2. Edit a client\n" +
                    "3. Delete a client\n" +
                    "4. List all clients\n" +
                    "0. Exit to main menu");
            System.out.print("> ");

            choice = sc.nextInt();
            sc.nextLine();
        } while (choice < 0 || choice > 4);

        switch (choice) {
            case 1 -> {
                addClient();
            }

            case 2 -> {
                editClient();
            }

            case 3-> {
                deleteClient();
            }

            case 4 -> {
                displayClients();
            }

            case 0 -> {
                mainMenu();
            }
        }
    }

    public static void additionalOperations() {

        int choice;

        do {
            System.out.println("-- Additional Operations --\n");
            System.out.println("1. Display the most expensive trip\n" +
                    "2. Calculate and display the total cost of a trip\n" +
                    "3. Create a deep copy of the transportation array\n" +
                    "4. Create a deep copy of the accomodation array");
            System.out.print("> ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    mostExpensiveTrip(trips);
                } case 2 -> {
                    totalCostOfATrip(trips);
                } case 3 -> {

                    if (transportations.length != 0) {
                        Transportation[] copyTransportations = copyTransportationArray(transportations);

                        System.out.println("Here is the deep copy of the transportation array");
                        for (Transportation transportation : copyTransportations) {
                            System.out.println(transportation);
                        }
                    } else {
                        System.out.println("There are no transportations to copy");
                    }

                } case 4 -> {

                    if (accommodations.length != 0) {
                        Accommodation[] copyAccommodations = copyAccommodationArray(accommodations);

                        System.out.println("Here is the deep copy of the accomodation array");
                        for (Accommodation accommodation : copyAccommodations) {
                            System.out.println(accommodation);
                        }
                    } else {
                        System.out.println("There are no accomodations to copy");
                    }

                }
            }

        } while (choice < 0 || choice > 4);
    }

    public static void addClient() {
        System.out.print("Enter client First Name: ");
        String firstName = sc.nextLine();
        System.out.print("Enter client Last Name: ");
        String lastName = sc.nextLine();
        System.out.print("Enter client email: ");
        String email = sc.nextLine();

        Client client = new Client(firstName, lastName, email);

        Client[] clientProcess = new Client[clients.length + 1];

        if (clients.length > 0) {
            for (int i = 0; i < clients.length; i++) {
                clientProcess[i] = clients[i];
            }
        }

        clientProcess[clientProcess.length - 1] = client;
        clients = clientProcess;
    }

    public static void editClient() {
        if (clients.length == 0) {
            System.out.println("There is no client to edit.");
        } else {
            int choice;

            do {
                System.out.println("Which client do you want to edit:");
                displayClients();

                System.out.println(clients.length + ". Exit");

                choice = sc.nextInt();
                sc.nextLine();
            } while (choice < 0 || choice > clients.length);

            if (choice != clients.length) {

                System.out.print("Enter new client First Name > ");
                String firstName = sc.nextLine();
                clients[choice].setFirstName(firstName);

                System.out.print("Enter new client Last Name > ");
                String lastName = sc.nextLine();
                clients[choice].setLastName(lastName);

                System.out.print("Enter new client Email > ");
                String email = sc.nextLine();
                clients[choice].setEmail(email);
            }

        }
    }

    public static void deleteClient() {
        if (clients.length == 0) {
            System.out.println("There is no client to delete.");
        } else {
            int choice;

            do {
                System.out.println("Which client do you want to delete");
                displayClients();

                System.out.println(clients.length + ". Exit");

                choice = sc.nextInt();
            } while (choice < 0 || choice > clients.length);

            if (choice != clients.length) {

                Client[] smallerClient;

                if ((clients.length - 1) == 0) {
                    smallerClient = new Client[0];
                } else {
                    smallerClient = new Client[clients.length - 1];
                    int compteur = 0;

                    for (int i = 0; i < clients.length; i++) {
                        if (i != choice) {
                            smallerClient[compteur] = clients[i];
                            compteur++;
                        } else {
                            i++;
                            smallerClient[compteur] = clients[i];
                            i--;
                        }
                    }
                }

                clients = smallerClient;
            }
        }
    }

    public static void displayClients() {
        if (clients.length != 0) {
            for (int i = 0; i < clients.length; i++) {
                System.out.println(i + ". " + clients[i].getClientId() + ", " + clients[i].getFirstName() + " " + clients[i].getLastName());
            }
        } else {
            System.out.println("There is no clients to display.");
        }
    }

    public static void totalCostOfATrip(Trip[] trips) {
        if (trips.length == 0) {
            System.out.println("There is no trip stored.");
        } else {
            int choice;
            do {
                System.out.println("Which trip do you want to calculate the cost of? :");
                for (int i = 0; i < trips.length; i++) {
                    System.out.println((i + 1) + ". " + trips[i].getTripId());
                }
                choice = sc.nextInt();
            } while (choice < 1 || choice > trips.length);

            System.out.println("Total cost of trip [" + trips[choice - 1].getTripId() + "]" + trips[choice -1].calculateTotalCost());
        }
    }


    public static void tripManagement() {
        int choice;
        do {
            System.out.println("-- Trip Management --\n");
            System.out.println("1. Create Trip\n" +
                    "2. Edit Trip\n" +
                    "3. Cancel Trip\n" +
                    "4. List all Trips\n" +
                    "5. List Trips for Client\n" +
                    "0. Exit to main menu");
            System.out.print("> ");

            choice = sc.nextInt();
            sc.nextLine();
        } while (choice < 0 || choice > 5);

        switch (choice) {
            case 1 -> {
                createTrip();
            }

            case 2 -> {
               // editTripInformation();
            }

            case 3-> {
                //cancelTrip();
            }

            case 4 -> {
                listAllTrips();

            }

            case 5 -> {

                //listAllTripsSpecificClient();
            }

            case 0 -> {
                mainMenu();
            }

        }


    }

    public static void createTrip() {

        int clientsCount = 0;

        System.out.print("Enter your destination: ");
        String destination = sc.nextLine();

        System.out.print("Enter duration days: ");
        int daysDuration = sc.nextInt();

        System.out.print("Enter base price: ");
        double price = sc.nextDouble();

        if (clientsCount == 0) {
            System.out.println("No client has been created. Please create a new client.");
        }





    }

    public static void listAllTrips() {
        //  for loop to sout trips
    }




    public static void transportationManagement() {

        int choice;
        do {
            System.out.println("-- Transportation Management --\n");
            System.out.println("1. Add a transportation option\n" +
                    "2. Remove a transportation option\n" +
                    "3. List transportation options by type (Flight, Train, Bus) \n" +
                    "0. Exit to main menu");
            System.out.print("> ");

            choice = sc.nextInt();
            sc.nextLine();
        } while (choice < 0 || choice > 3);

        switch (choice) {
            case 1 -> {
                addTransportation();
            }

            case 2 -> {
                removeTransportation();
            }

            case 3-> {
                listTransportationOptions();
            }

            case 0 -> {
                mainMenu();

            }
        }
    }

    public static void addTransportation() {

        System.out.println("\nSelect Transportation Type:");
        System.out.println("1- Flight");
        System.out.println("2- Train");
        System.out.println("3- Bus");
        System.out.print("> ");
        int type = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Company Name: ");
        String company = sc.nextLine();
        System.out.print("Enter Departure City: ");
        String departure = sc.nextLine();
        System.out.print("Enter Arrival City: ");
        String arrival = sc.nextLine();


        switch (type) {
            case 1 -> {
                System.out.print("Enter Luggage Allowance (kg): ");
                double luggage = sc.nextDouble();
                transportations[transportationCount++] = new Flight(company, departure, arrival, luggage);
            }
            case 2 -> {
                System.out.print("Enter Train Type: ");
                String trainType = sc.nextLine();
                System.out.print("Enter Seat Class (Economy/First Class): ");
                String seatClass = sc.nextLine();
                transportations[transportationCount++] = new Train(company,departure,arrival,trainType,seatClass);
            }
            case 3 -> {
                System.out.print("Enter Number of Stops: ");
                int stops = sc.nextInt();
                transportations[transportationCount++] = new Bus(company, departure, arrival, stops);
            }
            default -> System.out.println("Invalid type.");
        }

        System.out.println("Transportation added successfully.");
    }

    public static void listTransportationOptions() {

        if (transportations.length == 0) {
            System.out.println("No transportation options recorded.");
            return;
        }

        System.out.println("\n--- Registered Flights ---");
        for (Transportation t : transportations) {
            if (t instanceof Flight) System.out.println(t);
        }

        System.out.println("\n--- Registered Trains ---");
        for (Transportation t : transportations) {
            if (t instanceof Train) System.out.println(t);
        }

        System.out.println("\n--- Registered Buses ---");
        for (Transportation t : transportations) {
            if (t instanceof Bus) System.out.println(t);
        }
    }

    public static void removeTransportation() {

        if (transportationCount == 0) {
            System.out.println("There are no transportation options to remove.");
            return;
        }

        System.out.println("\nSelect a Transportation type to remove:");
        System.out.println("1- Flight");
        System.out.println("2- Train");
        System.out.println("3- Bus");
        System.out.print("> ");

        int type = sc.nextInt();

        // Display only chosen type
        System.out.println("\nAvailable options:");

        int[] indexes = new int[transportationCount];
        int count = 0;

        for (int i = 0; i < transportationCount; i++) {

            if ((type == 1 && transportations[i] instanceof Flight) ||
                    (type == 2 && transportations[i] instanceof Train) ||
                    (type == 3 && transportations[i] instanceof Bus)) {

                System.out.println(count + ". " + transportations[i]);
                indexes[count] = i;
                count++;
            }
        }

        if (count == 0) {
            System.out.println("No transportation of this type found.");
            return;
        }

        System.out.print("> ");
        int choice = sc.nextInt();

        if (choice < 0 || choice >= count) {
            System.out.println("Invalid index.");
            return;
        }

        int realIndex = indexes[choice];

        // Swap with last (COMP249 standard)
        transportations[realIndex] = transportations[transportationCount - 1];
        transportations[transportationCount - 1] = null;
        transportationCount--;

        System.out.println("Transportation removed successfully.");
    }


    public static void accommodationManagement() {
        int choice;
        do {
            System.out.println("-- Accommodation Management --\n");
            System.out.println("1. Add an accommodation\n" +
                    "2. Remove an accommodation\n" +
                    "3. List accommodations by type (Hotel, Hostel)\n" +
                    "0. Exit to main menu");
            System.out.print("> ");

            choice = sc.nextInt();
            sc.nextLine();
        } while (choice < 0 || choice > 3);

        switch (choice) {
            case 1 -> {
                addAccommodation();
            }

            case 2 -> {
                removeAccommodation();
            }

            case 3-> {
                listAccommodationByType();
            }

            case 0 -> {
                mainMenu();

            }
        }
    }

    public static void addAccommodation() {

        System.out.println("Choose an accommodation type:");
        System.out.println("1. Hotel\n2. Hostel");

        int type = sc.nextInt();

        sc.nextLine();

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Location: ");
        String location = sc.nextLine();

        System.out.print("Price/night: ");
        double price = sc.nextDouble();

        if (type == 1) {
            System.out.print("Enter Star Rating: ");
            int stars = sc.nextInt();
            accommodations[accommodationCount++] = new Hotel(name, location, price, stars);
        } else {
            System.out.print("Enter Number of Shared Beds: ");
            int beds = sc.nextInt();
            accommodations[accommodationCount++] = new Hostel(name, location, price, beds);
        }

        System.out.println("Accommodation added successfully.");
    }

    public static void removeAccommodation() {

        if (accommodationCount == 0) {
            System.out.println("There are no accommodations to remove.");
            return;
        }

        System.out.println("\nWhich accommodation do you want to remove?");

        for (int i = 0; i < accommodationCount; i++) {
            System.out.println(i + ". " + accommodations[i]);
        }

        System.out.print("> ");
        int index = sc.nextInt();

        if (index < 0 || index >= accommodationCount) {
            System.out.println("Invalid index.");
            return;
        }

        accommodations[index] = accommodations[accommodationCount - 1];
        accommodations[accommodationCount - 1] = null;
        accommodationCount--;

        System.out.println("Accommodation removed successfully.");

    }

    public static void listAccommodationByType() {

        System.out.println();
        for (Accommodation a : accommodations) {
            if (a instanceof Hotel) System.out.println(a);
        }

        for (Accommodation a : accommodations) {
            if (a instanceof Hostel) System.out.println(a);
        }

        if  (accommodationCount == 0) {
            System.out.println("There are no accommodations to list.");
        }

        }

    }

