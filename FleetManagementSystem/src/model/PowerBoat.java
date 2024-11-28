package model;

/**
 * Represents a power boat in the fleet, extending the {@link Boat} class.
 * A PowerBoat has the same properties as a Boat but is explicitly categorized as a powered vessel.
 */
public class PowerBoat extends Boat {

    /**
     * Constructs a new PowerBoat object with the specified details.
     *
     * @param name             the name of the power boat.
     * @param yearManufacture  the year the power boat was manufactured.
     * @param makeModel        the make and model of the power boat.
     * @param length           the length of the power boat in feet.
     * @param purchasePrice    the purchase price of the power boat in dollars.
     */
    public PowerBoat(String name, int yearManufacture, String makeModel, int length, double purchasePrice) {
        super(BoatType.POWER, name, yearManufacture, makeModel, length, purchasePrice);
    }

    /**
     * Provides a formatted string containing detailed information about the power boat.
     *
     * @return a string representation of the power boat, including its type, name, year of manufacture,
     *         make/model, length, purchase price, and total expenses.
     */
    @Override
    public String displayInfo() {
        return String.format("POWER   %-20s %d %-10s %2d' : Paid $ %8.2f : Spent $ %8.2f",
                getName(), getYearManufacture(), getMakeModel(), getLength(), getPurchasePrice(), getExpenses());
    }
}