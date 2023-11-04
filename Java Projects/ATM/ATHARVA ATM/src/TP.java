import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.XmlException;
import java.util.Scanner;

public class TP {
    public static void main(String[] args) throws IOException {

        // specify the path of the Excel file
        String excelFilePath = "C:\\Users\\Admin\\Videos\\ATHARVA ATM\\src\\ABC.xlsx";

        // create a file input stream to read the Excel file
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

        // create a workbook object to access the Excel file
        Workbook workbook = new XSSFWorkbook(inputStream);

        // get the first sheet of the workbook
        Sheet sheet = workbook.getSheetAt(0);

        // iterate through each row of the sheet
        // for (Row row : sheet) {
        //     // iterate through each cell of the row
        //     for (Cell cell : row) {
        //         // get the value of the cell and print it
        //         System.out.print(cell.toString() + "\t");
        //     }
        //     System.out.println();
        // }

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Account Number : ");
        double A = sc.nextDouble();
        System.out.println("Enter Password: ");
        double B = sc.nextDouble();
        sc.close();
        // Verifying the key
        int i;
        if (A > 0 & B > 0)
        {
            for (i = 0; i <= 7; i++) {
                Row row1 = sheet.getRow(i);
                Cell cell = row1.getCell(0);
                double D = cell.getNumericCellValue();
                if (A == D) {
                    Row row2 = sheet.getRow(i);
                    Cell cell1 = row2.getCell(1);
                    double C = cell1.getNumericCellValue();
                    if (C == B) {

                    } else {
                    }
                    System.out.println("System Access Granted!");
                } else {
                }
            }
        }
        else {
            System.out.println("System Access Denied!");
        }
        // close the workbook and input stream
        workbook.close();
        inputStream.close();
    }
}