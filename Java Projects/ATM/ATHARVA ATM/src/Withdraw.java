import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.XmlException;
import java.util.Scanner;

public class Withdraw extends Atm1 {
    public void with() throws IOException {
        String excelFilePath = "ABC.xlsx";
        try (// create a file input stream to read the Excel file
                FileInputStream inputStream = new FileInputStream(new File(excelFilePath))) {
            // create a workbook object to access the Excel file
            Workbook workbook = new XSSFWorkbook(inputStream);

            // Get the deposit amount from the user
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Amount to Deposit: ");
            double amount = sc.nextDouble();

            // get the first sheet of the workbook
            Sheet sheet = workbook.getSheetAt(0);

            // Search the user in excel
            int i;
            Row row2 = sheet.getRow(1);
            Cell cell2 = row2.getCell(2);
            for (i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row3 = sheet.getRow(i);
                Cell cell3 = row3.getCell(0);
                double D = cell3.getNumericCellValue();
                if (Acc == D) {
                    // get the numeric value for deposit
                    Cell cell4 = row3.getCell(2);
                    double balance = cell4.getNumericCellValue();
                    System.out.println(balance);
                    double withdraw = balance - amount;
                    cell4.setCellValue(withdraw);
                    System.out.println(cell4.getNumericCellValue());
                }
            }

            // get the numeric value for deposit
            // double balance = cell.getNumericCellValue();
            // System.out.println(balance);
            // double withdraw = balance - amount;
            // cell.setCellValue(withdraw);
            // System.out.println(cell.getNumericCellValue());

            // write and close the file
            FileOutputStream outputStream = new FileOutputStream(new File(excelFilePath));
            workbook.write(outputStream);
            // workbook.close();
            // outputStream.close();

        }
    }

    public static void main(String[] args) throws IOException {
        Withdraw B = new Withdraw();
        B.Auth();
        if (result1 == 1) {
            B.with();
        } else {
            System.out.println("Enter Valid Details. ");
        }
    }
}
