package uts.online.banking;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The type Account.
 */
public class Account {
    /**
     * The Scanner.
     */
    Scanner scanner = new Scanner(System.in);
    private Profile userProfile;
    private double accountBalance;
    private ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    /**
     * The Months.
     */
    String months[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September",
            "October", "November", "December"};

    /**
     * Instantiates a new Account.
     *
     * @param profile the profile
     */
    public Account(Profile profile) {
        accountBalance = 1000.0;
        userProfile = new Profile(profile.getUsername(), profile.getPassword());
    }

    /**
     * Gets account balance.
     *
     * @return
     */
    public double getAccountBalance() {
        return accountBalance;
    }

    /**
     * Deposit money.
     *
     * @param date   the date
     * @param amount the amount
     */
    public void depositMoney(int date, double amount) {
        accountBalance += amount;
        transactions.add(new Transaction(date, amount, "Deposit"));
    }

    /**
     * Withdraw money.
     *
     * @param date   the date
     * @param amount the amount
     */
    public void withdrawMoney(int date, double amount) {
        accountBalance -= amount;
        transactions.add(new Transaction(date, amount, "Withdrawal"));
    }

    /**
     * Gets user profile.
     *
     * @return the user profile
     */
    public Profile getUserProfile() {
        return userProfile;
    }

    /**
     * Sets user profile.
     *
     * @param userProfile the user profile
     */
    public void setUserProfile(Profile userProfile) {
        this.userProfile = userProfile;
    }

    /**
     * Print transactions.
     *
     * @param date the date
     */
    public void printTransactions(int date) {
        int counter = 0;
        for (int i = 0; i < transactions.size(); i++) {
            if (transactions.get(i).getDate() == date) {
                System.out.println(transactions.get(i).getType() + " of $" + transactions.get(i).getAmount());
                counter += 1;
            }
        }
        if (counter == 0) {
            String theDate = Integer.toString(date);
            int index = Integer.parseInt(theDate.substring(4, 6));
            System.out.println("No recorded transaction on " + months[index - 1] + " " + theDate.substring(6) + " " +
                    theDate.substring(0, 4));
        }
    }

    /**
     * Sort transactions.
     */
    public void sortTransactions() {

        if (transactions.size() == 0) {
            System.out.println("No recorded transactions");
        } else {
            for (int i = 1; i < transactions.size(); i++) {
                Transaction temp = transactions.get(i);
                int a = i;
                while (a > 0 && transactions.get(i - 1).getDate() > temp.getDate()) {
                    transactions.set(a, transactions.get(a - 1));
                    a--;
                }
                transactions.set(a, temp);
            }

            for (int i = 0; i < transactions.size(); i++) {
                String theDate = Integer.toString(transactions.get(i).getDate());
                int index = Integer.parseInt(theDate.substring(4, 6));
                System.out.println(months[index - 1] + " " + theDate.substring(6) + " " +
                        theDate.substring(0, 4) + ": " + transactions.get(i).getType() + " of $" +
                        transactions.get(i).getAmount());
            }
        }
    }

    /**
     * Same password boolean.
     *
     * @return the boolean
     */
    public boolean samePassword() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter your current password: ");
            String password = scanner.nextLine();
            if (userProfile.getPassword().equals(password)) {
                return true;
            } else {
                System.out.println("Wrong password. Remaining attempts: " + (2 - i));
            }
        }
        System.out.println("Returning to menu");
        return false;
    }
}