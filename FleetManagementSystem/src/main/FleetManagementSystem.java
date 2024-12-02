package main;

import model.Boat;
import model.PowerBoat;
import model.SailingBoat;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * The FleetManagementSystem class manages a collection of boats,
 * allowing users to add, remove, view, and manage expenses for each boat.
 * Data can be loaded from a CSV file or a serialized database file and saved upon exit.
 * @author chelseamunro
 * ...
 */

public class FleetManagementSystem {

    /**
     * List of boats in the fleet.
     */
    private ArrayList<Boat> boats = new ArrayList<>();

    /**
     * Name of the CSV file containing fleet data.
     */
    private static final String FLEET_DATA_FILE = "FleetData.csv";

    /**
     * Name of the serialized database file containing fleet data.
     */
    private static final String FLEET_DB_FILE = "FleetData.db";

    /**
     * The main entry point for the Fleet Management System application.
     *
     * @param args command-line arguments (not used).
     */

    public static void main(String[] args) {
        FleetManagementSystem fleetManagement = new FleetManagementSystem();
        fleetManagement.loadData();
        fleetManagement.run();
    }

    /**
     * Loads fleet data from a serialized database or a CSV file,
     * depending on availability.
     */

    private void loadData() {
        // Load fleet data from the file. This method will check if the data is in CSV or DB format.
        File dbFile = new File("FleetData.db");
        if (dbFile.exists()) {
            loadDataFromDB(); // Load from serialized DB
        } else {
            loadDataFromCSV(FLEET_DATA_FILE); // Load from CSV if DB doesn't exist
        }
    }

    /**
     * Loads fleet data from a CSV file.
     *
     * @param filename the name of the CSV file.
     */
    private void loadDataFromCSV(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                addBoatFromCSV(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading CSV file: " + e.getMessage());
        }
    }

    /**
     * Loads fleet data from a serialized database file.
     */

    private void loadDataFromDB() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("FleetData.db"))) {
            boats = (ArrayList<Boat>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading DB file: " + e.getMessage());
        }
    }

    /**
     * Saves the fleet data to a serialized database file.
     */

    public void saveDataToDB() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("FleetData.db"))) {
            oos.writeObject(boats);
        } catch (IOException e) {
            System.out.println("Error saving DB file: " + e.getMessage());
        }
    }

    /**
     * Prints the inventory of boats in the fleet,
     * including total purchase prices and expenses.
     */

    public void printBoatInventory() {
        System.out.println("Fleet report:");
        double totalPaid = 0.0, totalSpent = 0.0;
        for (Boat boat : boats) {
            System.out.println(boat.displayInfo());
            totalPaid += boat.getPurchasePrice();
            totalSpent += boat.getExpenses();
        }
        System.out.printf("Total : Paid $ %8.2f : Spent $ %8.2f\n", totalPaid, totalSpent);
    }

    /**
     * Runs the main user interface loop for the Fleet Management System.
     */

    private void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Fleet Management System");
        System.out.println("--------------------------------------");

        boolean running = true;
        while (running) {
            System.out.print("(P)rint, (A)dd, (R)emove, (E)xpense, e(X)it : ");
            String choice = scanner.nextLine().trim().toUpperCase();

            switch (choice) {
                case "P":
                    printBoatInventory();  // Fixed method call
                    break;
                case "A":
                    addBoat();
                    break;
                case "R":
                    removeBoat();
                    break;
                case "E":
                    requestExpense();
                    break;
                case "X":
                    saveDataToDB();  // Save data before exiting
                    running = false;
                    System.out.println("Exiting the Fleet Management System");
                    break;
                default:
                    System.out.println("Invalid menu option, try again");
            }
        }
        scanner.close();
    }

    /**
     * Adds a boat to the fleet using a CSV line for data.
     *
     * @param csvLine a comma-separated string containing boat data.
     */
    private void addBoatFromCSV(String csvLine) {
        String[] data = csvLine.split(",");
        if (data.length != 6) {
            System.out.println("Invalid data format. Please ensure data format is correct.");
            return;
        }

        try {
            Boat.BoatType type = Boat.BoatType.valueOf(data[0].toUpperCase());
            String name = data[1].trim();
            int year = Integer.parseInt(data[2].trim());
            String model = data[3].trim();
            int length = Integer.parseInt(data[4].trim());
            double price = Double.parseDouble(data[5].trim());

            Boat boat = (type == Boat.BoatType.SAILING) ?
                    new SailingBoat(name, year, model, length, price) :
                    new PowerBoat(name, year, model, length, price);

            boats.add(boat);
        } catch (Exception e) {
            System.out.println("Error adding boat: " + e.getMessage());
        }
    }

    /**
     * Allows the user to manually add a boat by entering CSV data.
     */
    private void addBoat() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the new boat CSV data: ");
        String csvData = scanner.nextLine();

        String[] data = csvData.split(",");
        if (data.length != 6) {
            System.out.println("Invalid data format. Please enter data in the format: TYPE,NAME,YEAR,MODEL,LENGTH,PURCHASE_PRICE");
            return;
        }

        try {
            Boat.BoatType type = Boat.BoatType.valueOf(data[0].toUpperCase());
            String name = data[1].trim();
            int yearManufacture = Integer.parseInt(data[2].trim());
            String makeModel = data[3].trim();
            int length = Integer.parseInt(data[4].trim());
            double purchasePrice = Double.parseDouble(data[5].trim());

            Boat boat;
            if (type == Boat.BoatType.SAILING) {
                boat = new SailingBoat(name, yearManufacture, makeModel, length, purchasePrice);
            } else {
                boat = new PowerBoat(name, yearManufacture, makeModel, length, purchasePrice);
            }
            boats.add(boat);
            System.out.println("Boat added successfully: " + boat);

        } catch (NumberFormatException e) {
            System.out.println("Invalid number format. Please check your numeric inputs.");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid boat type. Please enter either 'SAILING' or 'POWER'.");
        }
    }

    /**
     * Removes a boat from the fleet by its name.
     */

    private void removeBoat() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Which boat do you want to remove? ");
        String name = scanner.nextLine().trim();

        Boat toRemove = null;
        for (Boat boat : boats) {
            if (boat.getName().equalsIgnoreCase(name)) {
                toRemove = boat;
                break;
            }
        }

        if (toRemove != null) {
            boats.remove(toRemove);
            System.out.println("Boat removed successfully: " + toRemove);
        } else {
            System.out.println("Cannot find boat " + name);
        }
    }

    /**
     * Allows the user to request an expense for a specific boat.
     */
    private void requestExpense() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Which boat do you want to spend on? ");
        String name = scanner.nextLine().trim();

        Boat boat = null;
        for (Boat b : boats) {
            if (b.getName().equalsIgnoreCase(name)) {
                boat = b;
                break;
            }
        }

        if (boat != null) {
            System.out.print("How much do you want to spend? ");
            double amount;
            try {
                amount = Double.parseDouble(scanner.nextLine().trim());
                double allowableExpense = boat.getPurchasePrice() - boat.getExpenses();
                if (amount <= allowableExpense) {
                    boat.addExpense(amount);
                    System.out.printf("Expense authorized, $%.2f spent.%n", amount);
                } else {
                    System.out.printf("Expense not permitted, only $%.2f left to spend.%n", allowableExpense);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format. Please enter a valid amount.");
            }
        } else {
            System.out.println("Cannot find boat " + name);
        }
    }
}