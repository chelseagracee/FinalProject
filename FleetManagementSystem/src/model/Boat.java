package model;

import java.io.Serializable;

/**
 * Represents a boat in the fleet, with details about its type,
 * name, year of manufacture, make/model, length, purchase price,
 * and maintenance expenses.
 */

public abstract class Boat implements Serializable {
    public abstract String displayInfo();

    public double getExpenses() {
        return maintenanceExpenses;  // Return the total maintenance expenses
    }

    /**
     * Enumeration representing the type of boat.
     */
    public enum BoatType {
        SAILING, POWER
    }

    /**
     * The type of the boat (SAILING or POWER).
     */
    protected BoatType type;

    /**
     * The name of the boat.
     */
    protected String name;

    /**
     * The year the boat was manufactured.
     */
    protected int yearManufacture;

    /**
     * The make and model of the boat.
     */
    protected String makeModel;

    /**
     * The length of the boat in feet.
     */
    protected int length;

    /**
     * The purchase price of the boat in dollars.
     */
    protected double purchasePrice;

    /**
     * The total maintenance expenses incurred for the boat.
     */
    protected double maintenanceExpenses;

    /**
     * Constructs a new Boat object with the specified details.
     *
     * @param type             the type of the boat (SAILING or POWER).
     * @param name             the name of the boat.
     * @param yearManufacture  the year the boat was manufactured.
     * @param makeModel        the make and model of the boat.
     * @param length           the length of the boat in feet.
     * @param purchasePrice    the purchase price of the boat in dollars.
     */
    public Boat(BoatType type, String name, int yearManufacture, String makeModel, int length, double purchasePrice) {
        this.type = type;
        this.name = name;
        this.yearManufacture = yearManufacture;
        this.makeModel = makeModel;
        this.length = length;
        this.purchasePrice = purchasePrice;
        this.maintenanceExpenses = 0.0;  // Initialize with 0.0 expense
    }

    /**
     * Gets the type of the boat.
     *
     * @return the type of the boat (SAILING or POWER).
     */
    public BoatType getType() { return type; }

    /**
     * Gets the name of the boat.
     *
     * @return the name of the boat.
     */
    public String getName() { return name; }

    /**
     * Gets the year the boat was manufactured.
     *
     * @return the year of manufacture.
     */
    public int getYearManufacture() { return yearManufacture; }

    /**
     * Gets the make and model of the boat.
     *
     * @return the make and model of the boat.
     */
    public String getMakeModel() { return makeModel; }

    /**
     * Gets the length of the boat in feet.
     *
     * @return the length of the boat.
     */
    public int getLength() { return length; }

    /**
     * Gets the purchase price of the boat.
     *
     * @return the purchase price of the boat.
     */
    public double getPurchasePrice() { return purchasePrice; }

    /**
     * Gets the total maintenance expenses incurred for the boat.
     *
     * @return the total maintenance expenses.
     */
    public double getMaintenanceExpenses() { return maintenanceExpenses; }

    /**
     * Adds an expense to the boat's total maintenance expenses.
     *
     * @param amount the amount of the expense to add.
     */
    public void addExpense(double amount) {
        this.maintenanceExpenses += amount;  // Increment the maintenance expense
    }

    /**
     * Returns a string representation of the boat, including its details and expenses.
     *
     * @return a formatted string with the boat's details.
     */
    @Override
    public String toString() {
        return String.format("%-8s %-20s %4d %-10s %3d' : Paid $ %8.2f : Spent $ %8.2f",
                type, name, yearManufacture, makeModel, length, purchasePrice, maintenanceExpenses);
    }
}
