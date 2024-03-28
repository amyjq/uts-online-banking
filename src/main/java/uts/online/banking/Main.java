package uts.online.banking;

import java.util.Scanner;

/**
 * The type Main.
 */
public class Main {
    /**
     * The Scanner.
     */
    static Scanner scanner = new Scanner(System.in);
    /**
     * The Account.
     */
    static Account account = null;

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println("*                                                   *");
        System.out.println("*     Welcome to ICS4UN Online Banking Service!     *");
        System.out.println("*                                                   *");
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * \nPlease create an account to start");
        createAccount();
        while (true) {
            System.out.println("");
            System.out.println("Please select one of the following actions: \n1 Check Balance \n2 Deposit Money " +
                    "\n3 Withdraw Money \n4 Search Transactions \n5 Get All Transactions Sorted \n6 Change Password \n7 Log out");
            String option = scanner.nextLine();
            if (option.equals("1")) {
                System.out.println("$" + account.getAccountBalance());
            }
            else if (option.equals("2")) {
                boolean b = true;
                while (b) {
                    int theDate=0;
                    while (true) {
                        System.out.println("Enter the date of deposit (YYYYMMDD - No slashes): ");
                        String date = scanner.nextLine();
                        try {
                            theDate = Integer.parseInt(date);
                            break;
                        }
                        catch (NumberFormatException ex) {
                            System.out.println("Invalid date");
                        }
                    }
                    if (validDate(theDate)) {
                        double depositAmount =0;
                        while (true) {
                            System.out.println("Enter the deposit amount (in dollars): ");
                            String amount = scanner.nextLine();
                            try {
                                depositAmount = Double.parseDouble(amount);
                                if (depositAmount<=0) {
                                    System.out.println("Invalid deposit amount. Please enter an amount greater than $0.0");
                                }
                                else {
                                    break;
                                }
                            }
                            catch (NumberFormatException ex) {
                                System.out.println("Invalid deposit amount");
                            }
                        }
                        account.depositMoney(theDate, depositAmount);
                        System.out.println("Successfully deposited: $" + depositAmount);
                        break;
                    }
                    else {
                        System.out.println("Invalid Date");
                    }

                }
            }
            else if (option.equals("3")) {
                boolean b = true;
                while (b) {
                    int theDate=0;
                    while (true) {
                        System.out.println("Enter the date of withdrawal (YYYYMMDD - No slashes): ");
                        String date = scanner.nextLine();
                        try {
                            theDate = Integer.parseInt(date);
                            break;
                        }
                        catch (NumberFormatException ex) {
                            System.out.println("Invalid date");
                        }
                    }
                    if (validDate(theDate)) {
                        double withdrawalAmount =0;
                        while (true) {
                            System.out.println("Enter the withdrawal amount (in dollars): ");
                            String amount = scanner.nextLine();
                            try {
                                withdrawalAmount = Double.parseDouble(amount);
                                if (withdrawalAmount <=0) {
                                    System.out.println("Invalid withdrawal amount. Please enter an amount greater than $0.0");
                                }
                                else if (withdrawalAmount > account.getAccountBalance()) {
                                    System.out.println("Invalid withdrawal amount - Insufficient funds");
                                }
                                else {
                                    break;
                                }
                            }
                            catch (NumberFormatException ex) {
                                System.out.println("Invalid withdrawal amount");
                            }
                        }
                        account.withdrawMoney(theDate, withdrawalAmount);
                        System.out.println("Successfully withdrew: $" + withdrawalAmount);
                        break;
                    }
                    else {
                        System.out.println("Invalid Date");
                    }

                }
            }

            else if (option.equals("4")) {
                boolean b = true;
                while (b) {
                    int transactionDate = 0;
                    while (true) {
                        System.out.println("What date of transactions would you like to access (YYYYMMDD - No slashes): ");
                        String date = scanner.nextLine();
                        try {
                            transactionDate = Integer.parseInt(date);
                            break;
                        }
                        catch (NumberFormatException ex) {
                            System.out.println("Invalid Date");
                        }
                    }
                    if (validDate(transactionDate)) {
                        account.printTransactions(transactionDate);
                        break;
                    }
                    else {
                        System.out.println("Invalid Date");
                    }
                }
            }
            else if (option.equals("5")) {
                account.sortTransactions();
            }
            else if (option.equals("6")) {
                if (account.samePassword()) {
                    while (true) {
                        System.out.println("Enter your new password: ");
                        String newPassword = scanner.nextLine();
                        if (validPassword(newPassword)) {
                            System.out.println("Password updated");
                            account.getUserProfile().setPassword(newPassword);
                            break;
                        }
                        else {
                            System.out.println("Password does not meet requirements. ");
                        }
                    }
                }
            }
            else if (option.equals("7")) {
                boolean stay = true;
                while (stay) {
                    System.out.println("Are you sure you would like to log out (Y or N): ");
                    String choice = scanner.nextLine();
                    if (choice.equals("Y")) {
                        System.out.println("Logging out " +account.getUserProfile().getUsername());
                        System.exit(0);
                    }
                    if (choice.equals("N")) {
                        System.out.println("Returning");
                        stay=false;
                    }
                    else {
                        System.out.println("Invalid choice");
                    }
                }
            }
            else {
                System.out.println("Invalid option");
            }
        }
    }


    /**
     * Create account.
     */
    public static void createAccount() {
        String username = "";
        boolean b=true;
        while (b) {
            System.out.println("Enter an username: ");
            username = scanner.nextLine();
            if (username.equals("")) {
                System.out.println("Please try again");
            }
            else {
                break;
            }
        }
        System.out.println("Enter your password (Passwords must contain at least one digit and be 8 characters minimum): ");
        boolean badPassword = true;
        while (badPassword) {
            String password1 = scanner.nextLine();
            if (validPassword(password1)) {
                System.out.println("Account created successfully");
                System.out.println("Initial balance: $1000");
                Profile profile = new Profile (username, password1);
                account = new Account (profile);
                break;
            } else {
                System.out.println("Please enter a valid password: ");
            }
        }
    }

    /**
     * Valid password boolean.
     *
     * @param password the password
     * @return the boolean
     */
    public static boolean validPassword (String password) {
        for (int i=0; i<password.length(); i++) {
            char c = password.charAt(i);
            if (password.length()>=8 && Character.isDigit(c)) {
                return true;
            }
        }return false;
    }

    /**
     * Valid date boolean.
     *
     * @param date the date
     * @return the boolean
     */
    public static boolean validDate (int date) {
        String userDate = Integer.toString(date);
        if (userDate.length()!=8) {
            return false;
        }
        int month = Integer.parseInt(userDate.substring(4,6));
        int day = Integer.parseInt(userDate.substring(6,8));
        if (month>=1 && month<=12 && day>=1 && day<=31) {
            return true;
        }
        else {
            return false;
        }
    }
}