import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

class LoginPage extends IDandPASS implements ActionListener {
    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");

    JTextField userIDField = new JTextField();
    JPasswordField PassField = new JPasswordField();
    JLabel UserIdLabel = new JLabel("UserID:");
    JLabel UserPassLabel = new JLabel("UserPass:");
    JLabel messageLabel = new JLabel();
    static HashMap<Double, Double> logininfo = new HashMap<Double, Double>();
    String userId;
    static double d;
    String pass;
    static double pass1;

    LoginPage(HashMap<Double, Double> logininfoOriginal) {
        logininfo = logininfoOriginal;
        UserIdLabel.setBounds(50, 100, 75, 25);
        UserPassLabel.setBounds(50, 150, 75, 25);
        messageLabel.setBounds(125, 250, 250, 35);
        messageLabel.setFont(new Font(null, Font.ITALIC, 25));

        userIDField.setBounds(125, 100, 200, 25);
        PassField.setBounds(125, 150, 200, 25);

        loginButton.setBounds(125, 200, 100, 25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        resetButton.setBounds(225, 200, 100, 25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        frame.add(UserIdLabel);
        frame.add(UserPassLabel);
        frame.add(messageLabel);
        frame.add(userIDField);
        frame.add(PassField);
        frame.add(loginButton);
        frame.add(resetButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    // LoginPage LP;

    public void AuthUser(double d1, double pass2) {

        // LP = new LoginPage();

        System.out.println("Atharva LoginINFO" + logininfo);
        userId = userIDField.getText();
        d = Double.valueOf(userId);
        pass = String.valueOf(PassField.getPassword());
        pass1 = Double.valueOf(pass);
        // LP = new LoginPage();

        System.out.println(d + " skdjfhlksdhf " + pass1);
        System.out.println(d);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        AuthUser(d, pass1);

        if (e.getSource() == resetButton) {
            userIDField.setText("");
            PassField.setText("");
        }

        System.out.println(logininfo);

        if (e.getSource() == loginButton) {

            // System.out.println(logininfo.containsKey(d));

            if (logininfo.containsKey(d)) {
                if (logininfo.get(d) == pass1) {

                    System.out.println("inside " + logininfo.containsKey(d));
                    // System.out.println(logininfo.containsKey(d));
                    messageLabel.setForeground(Color.green);
                    messageLabel.setText("Access Granted");
                    frame.dispose();
                    WelcomePage welcomepage = new WelcomePage();
                    welcomepage.WelcomePage1(logininfo);
                } else {
                    messageLabel.setForeground(Color.red);
                    messageLabel.setText("Access Denied");
                }
            } else {
                messageLabel.setForeground(Color.red);
                messageLabel.setText("User Name Not Found");
            }
        }
    }
}