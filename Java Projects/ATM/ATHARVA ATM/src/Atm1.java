import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.XmlException;
import java.util.Scanner;

public class Atm1 {
    int Acc_no;
    int amount = 0;
    int amt = 0;
    int pin;
    int ch;
    double Acc;
    double Pin;
    static int result1 = 0;
    void Auth() throws IOException {
        // Scanner get = new Scanner(System.in);
        // System.out.println("Enter Acc No. ");
        // Acc_no = get.nextInt();
        // System.out.println("Enter pin: ");
        // pin = get.nextInt();
        // if (pin == 1983) {
        //     res = 1;
        // } else {
        //     res = 0;
        // }
        // specify the path of the Excel file
        String excelFilePath = "C:\\Users\\abhij\\OneDrive\\Desktop\\MIT WPU\\Semester 2\\New ATM\\ABCD\\src\\ABC.xlsx";

        try (// create a file input stream to read the Excel file
            FileInputStream inputStream = new FileInputStream(new File(excelFilePath))) {
            // create a workbook object to access the Excel file
            Workbook workbook = new XSSFWorkbook(inputStream);

            // get the first sheet of the workbook
            Sheet sheet = workbook.getSheetAt(0);

            // iterate through each row of the sheet
            // for (Row row : sheet) {
            // // iterate through each cell of the row
            // for (Cell cell : row) {
            // // get the value of the cell and print it
            // System.out.print(cell.toString() + "\t");
            // }
            // System.out.println();
            // }

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Account Number : ");
             Acc = sc.nextDouble();
            System.out.println("Enter Password: ");
             Pin = sc.nextDouble();
            // Verifying the key
            int i;
            if (Acc > 0 & Pin > 0) {
                for (i = 0; i <= sheet.getLastRowNum(); i++) {
                    Row row = sheet.getRow(i);
                    Cell cell = row.getCell(0);
                    double D = cell.getNumericCellValue();
                    if (Acc == D) {
                        Row row1 = sheet.getRow(i);
                        Cell cell1 = row1.getCell(1);
                        double C = cell1.getNumericCellValue();
                        if (C == Pin) {
                            System.out.println("\n\n");
                            System.out.println("<--------System Access Granted!-------->");
                            result1 = 1;
                        } else {
                            System.out.println("System Access Denied!");
                        }
                    } else {
                    }
                }
            } else {
            }
            // // close the workbook and input stream
            // workbook.close();
            // inputStream.close();
        }
    }
    void deposit() {
        Scanner get1 = new Scanner(System.in);
        System.out.println("Enter Enter Amount to deposit: ");
        amt = get1.nextInt();
        amount = amount + amt;
        System.out.println("Final Amount: " + amount);
    }

    void withdraw() {
        System.out.println("Enter amount to withdraw: ");
        Scanner get1 = new Scanner(System.in);
        amt = get1.nextInt();
        amount = amount - amt;
        System.out.println("Final Amount: " + amount);
    }

    void balance() {
        System.out.println("Final Balance: ");
        Scanner get1 = new Scanner(System.in);
        System.out.println("balance: " + amount);
    }

    void exit() {
    }

    void Switch1() {
        do {
            System.out.println("\n 1. Deposit: \n 2. Withdraw \n 3. Check Balance \n 4. Exit");
            System.out.println("Enter your choice: ");
            Scanner get = new Scanner(System.in);
            int ch = get.nextInt();
            switch (ch) {
                case 1:
                    deposit();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    balance();
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        } while (ch != 4);
    }
    public static void main(String[] args) throws IOException {
        Atm1 obj = new Atm1();
        obj.Auth();
        if(result1 == 1)
        {
            obj.Switch1();
        }
        }
}