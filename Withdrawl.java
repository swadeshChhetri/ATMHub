import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener {

    JTextField t1, t2;
    JButton Withdrawl, b2;
    JLabel l1, l2, l3;
    String pin;

    Withdrawl(String pin) {
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm/atm.logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 960, 1080);
        add(l3);

        l1 = new JLabel("ENTER AMOUNT YOU WANT TO Withdrawl");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));

        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 22));

        Withdrawl = new JButton("Withdrawl");
        b2 = new JButton("BACK");

        setLayout(null);

        l1.setBounds(190, 350, 400, 35);
        l3.add(l1);

        t1.setBounds(190, 420, 320, 25);
        l3.add(t1);

        Withdrawl.setBounds(390, 550, 150, 35);
        l3.add(Withdrawl);

        b2.setBounds(390, 600, 150, 35);
        l3.add(b2);

        Withdrawl.addActionListener(this);
        b2.addActionListener(this);

        setSize(960, 1080);
        setUndecorated(true);
        setLocation(500, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        //try{
        String amount = t1.getText();
        Date date = new Date();
        if (ae.getSource() == Withdrawl) {
            if (amount.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Withdrawl");
            } else {
                try {
                    Conn c1 = new Conn();
                    String query = ("insert into bank values('" + pin + "', '" + date + "', 'Withdrawl', '" + amount + "')");
                    c1.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs. " + amount + " Withdrawl Successfully");
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                } catch (Exception e) {

                    System.out.println(e);
                }
            }
        } else if (ae.getSource() == b2) {
            setVisible(false);
            new Transactions(pin).setVisible(true);
        }
    }//catch(Exception e){
    // e.printStackTrace();


    public static void main(String[] args) {
        new Deposit("").setVisible(true);


    }
}