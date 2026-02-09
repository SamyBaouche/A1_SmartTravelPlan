package driver;

import client.Client;
import travel.Flight;
import travel.Trip;

import java.util.Scanner;

public class SmartTravelDriver {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Welcome to SmartTravelPlanner by: \n" +
                "   Mohammed El Ouaabani and Samy Baouche \n");

        System.out.print("What would you like to access: \n" +
                "   1- menu-driven interface \n" +
                "   2- predefined testing scenario \n" +
                "Enter you choice > ");

        int optionChoice = sc.nextInt();

        switch (optionChoice) {
            //Menu driven interface
            case 1 -> {

            }
            //Predefined testing scenario
            case 2 -> {

                //3 Clients
                Client client1 = new Client("Jacob", "Delaire", "jacob.delaire@gmail.com");
                Client client2 = new Client("Nathan", "Blo", "nathan.blo@gmail.com");
                Client client3 = new Client();

                //3 Trips
                Trip trip1 = new Trip("Vancouver", 14, 600, client1);
                Trip trip2 = new Trip("Miami", 10, 400, client2);
                Trip trip3 = new Trip("Barcelona", 21, 900, client3);

                //2 Flights
                Flight flight1 = new Flight("Air Transat", "Montreal", "Miami", 22);
            }
        }

    }

    public int mainMenu() {
        System.out.println("-- Choose one of the operations below -- ");
        System.out.println();
        System.out.println("1. Client Management");
        System.out.println("2. Trip Management");
        System.out.println("3. Transportation Management");
        System.out.println("4. Accomodation Management");

        return sc.nextInt();
    }

    //Predefined Scenario
}
