# ATM Application with Excel File Validation

This Java application simulates an ATM (Automated Teller Machine) system built using Java Swing. Users can log in and perform actions such as depositing and deducting money from their account. The system validates user credentials using an Excel file.

## Features

The ATM application offers the following functionalities:

1. **User-Friendly GUI**: The application provides an intuitive graphical user interface (GUI) for a seamless user experience.

2. **Login Validation**: Users must log in with their account details, which are validated against data stored in an Excel file.

3. **Deposit Money**: Users can deposit money into their account by specifying the amount.

4. **Deduct Money**: Users can withdraw money from their account by specifying the amount.

5. **Balance Inquiry**: Users can check their account balance at any time.

6. **Transaction History**: The application maintains a transaction history, including timestamps and transaction types (deposit or deduction).

7. **Error Handling**: Robust error handling to address common issues, such as invalid login credentials, insufficient balance, and incorrect data format in the Excel file.

## Code Overview

The Java code is divided into the following key components:

- **Main Class**: Initializes the Swing components, sets up the GUI layout, and manages user interactions called By **App.java** in the **src** folder.

- **Excel File Handling**: Reads and writes data to an Excel file to validate user credentials and store transaction history.

- **User Authentication**: Implements user authentication logic based on the data in the Excel file.

- **Deposit and Deduction**: Allows users to deposit and deduct money from their account balance.

- **Transaction History Logging**: Records transaction details, including timestamps and transaction types, in the Excel file.

- **Error Handling**: Includes comprehensive error handling to ensure a smooth user experience and data integrity.

- **Layout and Design**: Configures the layout of the GUI, specifying the positions of buttons, input fields, and display areas.

## How to Run

To run the ATM application:

1. Compile the Java source code.

2. Execute the resulting class file.

3. The ATM GUI will open, prompting users to log in for which the sample usernames vary from 1 to 8 resp and passwords vary from 1001 to 1008 resp.

4. Users can perform actions, including depositing and deducting money, and checking their balance.

## Usage

1. Log in with valid credentials (username and password) stored in the Excel file.

2. Deposit money into your account by specifying the amount.

3. Deduct money from your account by specifying the amount (ensure sufficient balance).

4. Check your account balance to view the updated amount.

5. View your transaction history to see a record of recent transactions.

## Dependencies

This project requires the following dependencies:

- Java: The application is built in Java using Swing for the GUI.

- Excel Library (e.g., Apache POI): This library is used to read and write data to Excel files.

## Future Improvements

Future enhancements for this ATM application could include:

- Support for multiple user accounts.

- Enhanced security measures, such as PIN-based authentication.

- Improved data storage using a database instead of Excel files.

- Customization options for the user interface.

- Integration with real banking systems and services.

