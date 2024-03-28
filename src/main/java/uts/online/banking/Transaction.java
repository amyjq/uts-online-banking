package uts.online.banking;

/**
 * The type Transaction.
 */
public class Transaction {
    private int date;
    private double amount;
    private String type;

    /**
     * Instantiates a new Transaction.
     *
     * @param theDate   the the date
     * @param theAmount the the amount
     * @param theType   the the type
     */
    public Transaction(int theDate, double theAmount, String theType) {
        date = theDate;
        amount = theAmount;
        type = theType;
    }

    /**
     * Gets date.
     *
     * @return the date
     */
    public int getDate() {
        return date;
    }

    /**
     * Gets amount.
     *
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }
}
