import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class IDandPASS {
    HashMap<Double, Double> logininfo = new HashMap<Double, Double>();
    Workbook workbook;
    FileInputStream inputStream = null;

    void IDandPASS1() throws FileNotFoundException, IOException {

        System.out.println("IDPASS CALLED");

        String excelFilePath = "C:\\Users\\abhij\\Videos\\ATHARVA ATM (2)\\ATHARVA ATM\\src\\ABC.xlsx";
        inputStream = new FileInputStream(new File(excelFilePath));
        // create a workbook object to access the Excel file
        workbook = new XSSFWorkbook(inputStream);

        // get the first sheet of the workbook
        Sheet sheet = workbook.getSheetAt(0);

        // Search the user in excel
        int i;

        for (i = 1; i <= sheet.getLastRowNum(); i++) {
            System.out.println(i + i);

            Row row2 = sheet.getRow(i);
            Cell cell2 = row2.getCell(0);
            Cell cell3 = row2.getCell(1);
            Double c = cell2.getNumericCellValue();

            System.out.println("C=" + c.doubleValue());
            Double d = cell3.getNumericCellValue();

            System.out.println("D=" + d.doubleValue());

            logininfo.put(c, d);
            System.out.println("Login info created " + logininfo);

        }
        // logininfo.put("BROM", "4321");
        // logininfo.put("BRUU", "3214"); }
        // String[] logininfo() throws IOException {
        // Workbook workbook = WorkbookFactory
        // .create(new FileInputStream("C:\\Users\\abhij\\OneDrive\\Desktop\\MIT
        // WPU\\Semester 2\\New ATM\\ABCD\\src\\ABCDEFG.xlsx"));
        // org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(0);
        // Row row = sheet.getRow(0);
        // String username = row.getCell(0).toString();
        // String password = row.getCell(1).toString();
        // String[] credentials = { username, password };
        // workbook.close();
        // // return credentials;
        // return credentials;
    }

    public HashMap getLogininfo() {
        return logininfo;
    }
}
