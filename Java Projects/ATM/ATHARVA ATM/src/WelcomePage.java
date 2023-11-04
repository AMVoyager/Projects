import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

// extends DepositFunction
public class WelcomePage extends App implements ActionListener {
    JFrame frame = new JFrame();
    JLabel welcomeLabel = new JLabel("Hello");
    JButton DepositButton = new JButton("Deposit");
    JButton BalanceButton = new JButton("Balance");
    JButton WithdrawButton = new JButton("Withdraw");
    HashMap logininfo3;

    void WelcomePage1(HashMap<Double, Double> logininfo) {

        logininfo3 = logininfo;
        // welcomeLabel.setBounds(0,0,200,35);
        // welcomeLabel.setFont(new Font(null,Font.ITALIC,25));
        // welcomeLabel.setText("Hello"+userID);

        DepositButton.setBounds(100, 200, 100, 25);
        DepositButton.setFocusable(false);
        DepositButton.addActionListener(this);

        BalanceButton.setBounds(200, 200, 100, 25);
        BalanceButton.setFocusable(false);
        BalanceButton.addActionListener(this);

        WithdrawButton.setBounds(300, 200, 100, 25);
        WithdrawButton.setFocusable(false);
        WithdrawButton.addActionListener(this);

        frame.add(welcomeLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.add(DepositButton);
        frame.add(BalanceButton);
        frame.add(WithdrawButton);
    }

    // public WelcomePage(double val) {
    // }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == DepositButton) {
            try {
                System.out.println("Action Performed ##### " + logininfo3);
                DepositFunction b1 = new DepositFunction(logininfo3);
                System.out.println("Action Performed ###########" + logininfo3);

            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

        }
        if (e.getSource() == WithdrawButton) {
            try {
                System.out.println("Action Performed ##### " + logininfo3);
                WithdrawFunction b1 = new WithdrawFunction(logininfo3);
                System.out.println("Action Performed ###########" + logininfo3);

            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
        if (e.getSource() == BalanceButton) {
            try {
                System.out.println("Action Performed ##### " + logininfo3);
                BalanceFunction b1 = new BalanceFunction(logininfo3);
                System.out.println("Action Performed ###########" + logininfo3);

            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }
}