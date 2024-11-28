package model;

/**
 * Represents a sailing boat in the fleet, extending the {@link Boat} class.
 * A SailingBoat has the same properties as a Boat but is explicitly categorized as a sailing vessel.
 */
public class SailingBoat extends Boat {

    /**
     * Constructs a new SailingBoat object with the specified details.
     *
     * @param name             the name of the sailing boat.
     * @param yearManufacture  the year the sailing boat was manufactured.
     * @param makeModel        the make and model of the sailing boat.
     * @param length           the length of the sailing boat in feet.
     * @param purchasePrice    the purchase price of the sailing boat in dollars.
     */
    public SailingBoat(String name, int yearManufacture, String makeModel, int length, double purchasePrice) {
        super(BoatType.SAILING, name, yearManufacture, makeModel, length, purchasePrice);
    }

    /**
     * Provides a formatted string containing detailed information about the sailing boat.
     *
     * @return a string representation of the sailing boat, including its type, name, year of manufacture,
     *         make/model, length, purchase price, and total expenses.
     */
    @Override
    public String displayInfo() {
        return String.format("SAILING %-20s %d %-10s %2d' : Paid $ %8.2f : Spent $ %8.2f",
                getName(), getYearManufacture(), getMakeModel(), getLength(), getPurchasePrice(), getExpenses());
    }
}