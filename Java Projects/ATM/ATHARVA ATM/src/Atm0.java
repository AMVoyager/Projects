import java.util.Scanner;
public class Atm0 {
    int Acc_no;
    int amount = 0;
    int amt = 0;
    int pin;
    int ch;
    static int res = 0; //for authentication result purposes

    void deposit() {
        Scanner get = new Scanner(System.in);
        System.out.println("Enter Enter Amount to deposit: ");
        amt = get.nextInt();
        amount = amount + amt;
        System.out.println("Final Amount: " + amount);
    }

    void withdraw() {
        System.out.println("Enter amount to withdraw: ");
        Scanner get = new Scanner(System.in);
        amt = get.nextInt();
        amount = amount - amt;
        System.out.println("Final Amount: " + amount);
    }

    void balance() {
        System.out.println("Final Balance: ");
        Scanner get = new Scanner(System.in);
        System.out.println("balance: " + amount);
    }

    void exit() {
    }

    void Auth() {
        Scanner get = new Scanner(System.in);
        System.out.println("Enter Acc No. ");
        Acc_no = get.nextInt();
        System.out.println("Enter pin: ");
        pin = get.nextInt();
        if (pin == 1983) {
            res = 1;
        } else {
            res = 0;
        }
    }

    void Switch1() {

        do {
            System.out.println("1. Deposit: \n 2. Withdraw \n 3. Check Balance \n 4. Exit");
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
                    exit();
                    break;
            }
        } while (ch != 4);
    }

    public static void main(String[] args) {
        Atm0 obj = new Atm0();
        obj.Auth();
        if (res == 1 ) {
            obj.Switch1();
        } else {
            System.out.println("Wrong Pin ");
        }
    }
}