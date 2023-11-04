import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CalculatorOne implements ActionListener {
    double a = -1, b = -1, res;
    String op = "";
    JPanel jp = new JPanel();
    JTextField ja = new JTextField(20);
    JTextField jb = new JTextField(20);
    String Texta = "";
    String Textop = "";
    String Textb = "";
    String res1, res2, res3, res4;
    JPanel jf = new JPanel(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();

    public CalculatorOne() {
        ja.setHorizontalAlignment(JTextField.RIGHT);
        ja.setFont(new Font("Cascadia Code", Font.PLAIN, 20));
        jb.setHorizontalAlignment(JTextField.RIGHT);
        jb.setFont(new Font("Cascadia Code", Font.PLAIN, 14));
        JFrame frame = new JFrame();
        JButton btn1 = new JButton("0");
        JButton btn2 = new JButton("1");
        JButton btn3 = new JButton("2");
        JButton btn4 = new JButton("3");
        JButton btn5 = new JButton("4");
        JButton btn6 = new JButton("5");
        JButton btn7 = new JButton("6");
        JButton btn8 = new JButton("7");
        JButton btn9 = new JButton("8");
        JButton btn10 = new JButton("9");
        JButton btn11 = new JButton("/");
        JButton btn12 = new JButton("*");
        JButton btn13 = new JButton("-");
        JButton btn14 = new JButton("+");
        JButton btn15 = new JButton("=");
        JButton btn16 = new JButton("C");
        JButton btn17 = new JButton(".");
        ja.setEditable(false);
        jb.setEditable(false);
        addButton(btn13, (1 + 1), 0);
        addButton(btn8, (1 + 1), 1);
        addButton(btn9, (1 + 1), 2);
        addButton(btn10, (1 + 1), 3);
        addButton(btn12, (2 + 1), 0);
        addButton(btn5, (2 + 1), 1);
        addButton(btn6, (2 + 1), 2);
        addButton(btn7, (2 + 1), 3);
        addButton(btn14, (3 + 1), 0);
        addButton(btn2, (3 + 1), 1);
        addButton(btn3, (3 + 1), 2);
        addButton(btn4, (3 + 1), 3);
        addButton(btn11, (4 + 1), 0);
        addButton(btn1, (4 + 1), 1);
        addButton(btn16, (4 + 1), 2);
        addButton(btn17, (4 + 1), 3);
        addButton(btn15, (5 + 1), 0);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        jf.add(jb, gbc); // Add the text field to the panel
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        jf.add(ja, gbc); // Add the text field to the panel

        // Adding ActionListeners
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ja.setText(ja.getText() + "0");
            }
        });
        btn1.setFont(new Font("Cascadia Code", Font.PLAIN, 14));
        btn1.setBackground(new Color(255, 255, 255));
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ja.setText(ja.getText() + "1");
            }
        });
        btn2.setFont(new Font("Cascadia Code", Font.PLAIN, 14));
        btn2.setBackground(new Color(255, 255, 255));
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ja.setText(ja.getText() + "2");
            }
        });
        btn3.setFont(new Font("Cascadia Code", Font.PLAIN, 14));
        btn3.setBackground(new Color(255, 255, 255));
        btn4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ja.setText(ja.getText() + "3");
            }
        });
        btn4.setFont(new Font("Cascadia Code", Font.PLAIN, 14));
        btn4.setBackground(new Color(255, 255, 255));
        btn5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ja.setText(ja.getText() + "4");
            }
        });
        btn5.setFont(new Font("Cascadia Code", Font.PLAIN, 14));
        btn5.setBackground(new Color(255, 255, 255));
        btn6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ja.setText(ja.getText() + "5");
            }
        });
        btn6.setBackground(new Color(255, 255, 255));
        btn6.setFont(new Font("Cascadia Code", Font.PLAIN, 14));
        btn7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ja.setText(ja.getText() + "6");
            }
        });
        btn7.setFont(new Font("Cascadia Code", Font.PLAIN, 14));
        btn7.setBackground(new Color(255, 255, 255));
        btn8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ja.setText(ja.getText() + "7");
            }
        });
        btn8.setBackground(new Color(255, 255, 255));
        btn8.setFont(new Font("Cascadia Code", Font.PLAIN, 14));
        btn9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ja.setText(ja.getText() + "8");
            }
        });
        btn9.setBackground(new Color(255, 255, 255));
        btn9.setFont(new Font("Cascadia Code", Font.PLAIN, 14));
        btn10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ja.setText(ja.getText() + "9");
            }
        });
        btn10.setBackground(new Color(255, 255, 255));
        btn10.setFont(new Font("Cascadia Code", Font.PLAIN, 14));
        btn11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Textop = "/";
                ja.setText(ja.getText() + Textop);
                op = "/";
            }
        });
        btn11.setBackground(new Color(255, 255, 255));
        btn11.setFont(new Font("Cascadia Code", Font.PLAIN, 14));
        btn12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Textop = "*";
                ja.setText(ja.getText() + Textop);
                op = "*";
            }
        });
        btn12.setBackground(new Color(255, 255, 255));
        btn12.setFont(new Font("Cascadia Code", Font.PLAIN, 14));
        btn13.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Textop = "-";
                ja.setText(ja.getText() + Textop);
                op = "-";
            }
        });
        btn13.setBackground(new Color(255, 255, 255));
        btn13.setFont(new Font("Cascadia Code", Font.PLAIN, 14));
        btn14.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Textop = "+";
                ja.setText(ja.getText() + Textop);
            }
        });
        btn14.setBackground(new Color(255, 255, 255));
        btn14.setFont(new Font("Cascadia Code", Font.PLAIN, 14));
        btn16.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ja.setText(null);
                jb.setText(null);
                Texta = "";
                Textop = "";
                Textb = "";
                op = "";
            }
        });
        btn16.setBackground(new Color(255, 255, 255));
        btn17.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Texta += ".";
                ja.setText(ja.getText() + Texta);
            }
        });
        btn17.setBackground(new Color(255, 255, 255));
        btn17.setFont(new Font("Cascadia Code", Font.BOLD, 14));
        btn16.setFont(new Font("Cascadia Code", Font.PLAIN, 14));
        btn15.setBackground(new Color(255, 255, 255));
        btn15.addActionListener(new ActionListener() {
            int ind, len;

            public void actionPerformed(ActionEvent e) {
                jb.setText(ja.getText());
                ind = -1; // Initialize ind to a default value
                String abc = ja.getText();
                len = abc.length();
                String arr[] = { "+", "-", "*", "/" };
                for (int i = 0; i < arr.length; i++) {
                    if (abc.contains(arr[i])) {
                        ind = abc.indexOf(arr[i]);
                        break; // No need to continue checking once an operator is found
                    }
                }
                String a = abc.substring(0, ind);
                String b = abc.substring(ind + 1, len);
                double a1 = Double.parseDouble(a);
                double b1 = Double.parseDouble(b);
                // int res = 0; // Initialize the result
                ja.setText(null);
                Textb = "";
                switch (abc.charAt(ind)) {
                    case '+':
                        a1 = a1 + b1;
                        res1 = Double.toString(a1);
                        ja.setText(res1);
                        break;
                    case '-':
                        a1 = a1 - b1;
                        res2 = Double.toString(a1);
                        ja.setText(res2);
                        break;
                    case '*':
                        a1 = a1 * b1;
                        res3 = Double.toString(a1);
                        ja.setText(res3);
                        break;
                    case '/':
                        a1 = a1 / b1;
                        res4 = Double.toString(a1);
                        ja.setText(res4);
                        break;
                }
            }
        });
        btn15.setFont(new Font("Cascadia Code", Font.PLAIN, 14));
        jf.setBackground(new Color(180, 227, 247));
        jf.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        frame.add(jf);
        frame.setContentPane(jf);
        frame.setTitle("Calculator");
        frame.pack();
        frame.setSize(370, 400);
        frame.setVisible(true);
    }

    private void addButton(JButton button, int row, int col) {
        gbc.gridx = col;
        gbc.gridy = row;
        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.fill = GridBagConstraints.BOTH;
        jf.add(button, gbc);
        button.addActionListener(this);
    }

    public static void main(String[] args) {
        new CalculatorOne();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}