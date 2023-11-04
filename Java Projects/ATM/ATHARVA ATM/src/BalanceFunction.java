// import java.awt.*;
// import java.awt.event.*;
// import java.io.File;
// import java.io.FileInputStream;
// import java.io.FileOutputStream;
// import java.io.IOException;
// import java.io.OutputStream;
// import java.util.Scanner;
// import javax.swing.*;

// import javax.xml.transform.Source;

// import java.util.HashMap;
// import org.apache.poi.ss.usermodel.Cell;
// import org.apache.poi.ss.usermodel.Row;
// import org.apache.poi.ss.usermodel.Sheet;
// import org.apache.poi.ss.usermodel.Workbook;
// import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// public class BalanceFunction extends LoginPage {
//     // private JTextField amountField;
//     JFrame frame = new JFrame();
//     private JButton balanceButton;
//     private JLabel messageLabel;
//     HashMap<Double, Double> logininfo2 = new HashMap<Double, Double>();

//     public BalanceFunction(HashMap<Double, Double> logininfoOriginal) throws IOException {

//         super(logininfoOriginal);

//         System.out.println("Balance Constructor 1" + logininfo);

//         frame.setTitle("Balance Function");
//         frame.setSize(300, 150);
//         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         frame.setLocationRelativeTo(null);

//         // create a panel to hold components
//         JPanel panel = new JPanel();
//         panel.setLayout(new GridLayout(3, 1));

//         // create a text field for entering amount
//         // amountField = new JTextField(10);
//         // panel.add(amountField);

//         // create a deposit button and add an ActionListener
//         balanceButton = new JButton("Balance");
//         balanceButton.addActionListener(this);
//         panel.add(balanceButton);

//         // create a label for displaying messages
//         messageLabel = new JLabel("Enter the amount to deposit");
//         panel.add(messageLabel);

//         // add the panel to the frame
//         frame.add(panel);

//         // show the frame
//         frame.setVisible(true);
//     }

//     // HashMap logininfo1;

//     public void actionPerformed(ActionEvent e) {
//         // logininfo1 = LP.getLogininfo();
//         System.out.println("User Done" + logininfo);
//         userId = userIDField.getText();
//         d = Double.valueOf(userId);
//         pass = String.valueOf(PassField.getPassword());
//         pass1 = Double.valueOf(pass);
//         System.out.println(" Something clicked  " + logininfo);

//         if (e.getSource() == balanceButton) {
//             System.out.println(" Deposit button clicked " + logininfo);

//             double balance;
//             // get the amount entered by the user
//             // String amountString = amountField.getText();
//             // double amount = Double.parseDouble(amountString);

//             // System.out.println("Action Performed deposit button clicked " + amount);

//             // perform the deposit
//             // (replace this with your actual deposit code)
//             // // perform the deposit
//             String excelFilePath = "C:\\Users\\abhij\\Videos\\ATHARVA ATM (2)\\ATHARVA ATM\\src\\ABC.xlsx";

//             // // try (// create a file input stream to read the Excel file
//             try {
//                 FileInputStream inputStream1 = new FileInputStream(new File(excelFilePath));
//                 Workbook workbook1 = new XSSFWorkbook(inputStream1);

//                 System.out.println(workbook1);

//                 Sheet sheet = workbook1.getSheetAt(0);

//                 int i;

//                 System.out.println("Action Performed workbook" + workbook1);

//                 for (i = 1; i <= sheet.getLastRowNum(); i++) {
//                     // FileInputStream inputStream2 = new FileInputStream(new File(excelFilePath));
//                     // Workbook workbook2 = new XSSFWorkbook(inputStream2);
//                     // Sheet sheet2 = workbook2.getSheetAt(0);

//                     System.out.println("Action Performed for loop ");

//                     Row row3 = sheet.getRow(i);
//                     Cell cell3 = row3.getCell(0);
//                     double account1 = cell3.getNumericCellValue();

//                     System.out.println("Pass From User: " + pass1);

//                     if (logininfo.containsKey(d)) {
//                         System.out.println("Action Performed logininfo.containsKey(d)) " + account1 + logininfo);
//                         System.out.println(logininfo);

//                         Row row5 = sheet.getRow(i);
//                         Cell cell5 = row5.getCell(1);
//                         double password1 = cell5.getNumericCellValue();
//                         System.out.println("Password Taken" + password1);

//                         if (logininfo.get(d) == password1) {
//                             System.out.println("acount" + account1);
//                             System.out.println("Action Performed d===D" + account1 + "" + "password" + password1);
//                             // get the numeric value for deposit
//                             Row row4 = sheet.getRow(i);
//                             Cell cell4 = row4.getCell(2);
//                             balance = cell4.getNumericCellValue();
//                             // System.out.println("Balance " + balance);
//                             // // System.out.println(balance);
//                             // // double deposit = balance + amount;
//                             // cell4.setCellValue(balance);
//                             // System.out.println("Cell Value: " + cell4.getNumericCellValue());
//                             messageLabel.setText("Deposit successful. New balance is $" + balance);
//                             // workbook1.close();
//                             // break;
//                         } else {
//                             System.out.println("Not Found");
//                         }
//                     }
//                     // FileOutputStream outputStream = new FileOutputStream(new
//                     // File(excelFilePath));
//                     // workbook1.write(outputStream);
//                     // workbook1.close();
//                 }

//                 FileOutputStream outputStream = new FileOutputStream(new File(excelFilePath));
//                 workbook1.write(outputStream);
//             } catch (IOException ie) {
//             }
//             // System.exit(1);
//         }
//     }// FileOutputStream outputStream = new FileOutputStream(new
//      // File(excelFilePath));
//      // workbook.write(outputStream);
//      // workbook.close();
//      // outputStream.close();
// }

import java.awt.Component;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.*;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;

public class BalanceFunction extends LoginPage {
    private JLabel balanceLabel;
    JFrame frame = new JFrame();

    public BalanceFunction(HashMap<Double, Double> logininfoOriginal) throws IOException {
        super(logininfo);
        balanceLabel = new JLabel("Balance: ");
        frame.add(balanceLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void updateBalance(double balance) {
        balanceLabel.setText(String.format("Balance: $%.2f", balance));
        userId = userIDField.getText();
        d = Double.valueOf(userId);
        pass = String.valueOf(PassField.getPassword());
        pass1 = Double.valueOf(pass);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            double balance;
            try (FileInputStream fis = new FileInputStream("ABC.xlsx")) {
                Workbook workbook = WorkbookFactory.create(fis);
                BalanceFunction gui = new BalanceFunction(logininfo);
                Sheet sheet = workbook.getSheetAt(0);
                for (int i = 1; i < sheet.getLastRowNum(); i++) {
                    Row row3 = sheet.getRow(i);
                    Cell cell3 = row3.getCell(0);
                    double account1 = cell3.getNumericCellValue();

                    System.out.println("Pass From User: " + pass1);

                    if (logininfo.containsKey(d)) {
                        System.out.println("Action Performed logininfo.containsKey(d)) " + account1 + logininfo);
                        System.out.println(logininfo);

                        Row row5 = sheet.getRow(i);
                        Cell cell5 = row5.getCell(1);
                        double password1 = cell5.getNumericCellValue();
                        System.out.println("Password Taken" + password1);

                        if (logininfo.get(d) == password1) {
                            System.out.println("acount" + account1);
                            System.out.println("Action Performed d===D" + account1 + "" + "password" + password1);
                            // get the numeric value for deposit
                            Row row4 = sheet.getRow(i);
                            Cell cell4 = row4.getCell(2);
                            balance = cell4.getNumericCellValue();
                            System.out.println("Balance " + balance);
                            // System.out.println(balance);
                            // double deposit = balance + amount;
                            cell4.setCellValue(balance);
                            System.out.println("Cell Value: " + cell4.getNumericCellValue());
                            // messageLabel.setText("Deposit successful. New balance is $" +
                            // cell4.getNumericCellValue());
                            // workbook1.close();
                            // break;
                            gui.updateBalance(balance);
                        } else {
                            System.out.println("Not Found");
                        }
                    }
                }
            } catch (IOException | EncryptedDocumentException e) {
                e.printStackTrace();
                // JOptionPane.showMessageDialog(gui, "Failed to read account balance from
                // file.");
            }
        });
    }
}
