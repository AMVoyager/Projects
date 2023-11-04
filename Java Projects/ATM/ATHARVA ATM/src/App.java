import java.io.FileNotFoundException;
import java.io.IOException;
public class App {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        IDandPASS IP = new IDandPASS();
        IP.IDandPASS1();
        LoginPage LP = new LoginPage(IP.getLogininfo());
        // DepositFunction ab = new DepositFunction(IP.getLogininfo());
    }
}