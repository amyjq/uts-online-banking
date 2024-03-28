# ICS4UN Online Banking Service

This project simulates a simple online banking service where users can create an account, deposit and withdraw money, check their balance, and view transactions.

## Structure

The project is divided into four main classes:

- `Main`: The entry point of the application.
- `Account`: Represents a user's bank account.
- `Transaction`: Represents a transaction (deposit or withdrawal).
- `Profile`: Represents a user's profile.

## How to Run

1. Ensure you have Java installed on your system.
2. Download the `.java` files mentioned below.
3. Compile the Java files using the command `javac Main.java`.
4. Run the application with the command `java Main`.

## Code
#### Main Class
- The program starts with a greeting and prompts the user to create an account.
- It continually displays a menu for various banking actions such as checking the balance, depositing money, withdrawing money, searching and sorting transactions, changing the password, and logging out.
- The createAccount method initializes an Account object with a username and a password, setting an initial balance of $1000.
#### Account Class
- Holds user profile, account balance, and transaction records.
- Allows depositing and withdrawing money, updating the balance accordingly, and adding transactions to a list.
#### Transaction Class
- Represents a banking transaction with a date, amount, and type (Deposit or Withdrawal).
#### Profile Class
- Holds user profile information: username and password.

## Features
- Account creation with initial balance
- Deposit and withdrawal operations
- Transaction history with search and sort functionalities
- Password change feature

## Limitations
- The application does not connect to a real bank or external database.
- Password validation is basic and might not meet real-world security standards.

## Future Enhancements
- Implementing a graphical user interface (GUI).
- Adding multi-user support with login functionality.
