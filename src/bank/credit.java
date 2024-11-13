package bank;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

// import javax.swing.JButton;
import javax.swing.*;

public class credit extends JFrame implements ActionListener{

    JButton depositButton,exitBut;
    JTextField amount;
    String formNo;
    JLabel image;

    credit(String formNo,String amntType,String balance){

        this.formNo = formNo;

        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,850,Image.SCALE_DEFAULT); 
        ImageIcon i3=new ImageIcon(i2);
        image=new JLabel(i3);
        image.setBounds(0,0,900,850);
        add(image);

        JLabel text=new JLabel(amntType);
        text.setFont(new Font("Raleway",Font.BOLD,17));
        text.setBounds(250,300,320,20);
        text.setForeground(Color.WHITE);
        image.add(text);

        JLabel nxText=new JLabel("YOUR BANK BALANCE IS:");
        nxText.setFont(new Font("Raleway",Font.BOLD,17));
        nxText.setBounds(230,325,320,20);
        nxText.setForeground(Color.WHITE);
        image.add(nxText);

        JLabel showBlns=new JLabel(balance);
        showBlns.setFont(new Font("Raleway",Font.BOLD,22));
        showBlns.setBounds(240,355,320,30);
        showBlns.setForeground(Color.WHITE);
        image.add(showBlns);
        

        // amount=new JTextField();
        // amount.setFont(new Font("Raleway", Font.BOLD,30));
        // amount.setBackground(Color.cyan);
        // amount.setBounds(200,355,275,40);
        // image.add(amount);

        // depositButton=new JButton("DEPOSIT");
        // depositButton.setBounds(345,457,170,29);
        // depositButton.setFont(new Font("Raleway",Font.BOLD,25));
        // depositButton.addActionListener(this);
        // image.add(depositButton);

        exitBut=new JButton("EXIT");
        exitBut.setFont(new Font("Raleway",Font.BOLD,25));
        exitBut.setBounds(345,490,170,30);
        exitBut.addActionListener(this);
        image.add(exitBut);

        setSize(900,850);
        setVisible(true);
    }

    public static void main(String[] args) {
        new credit("","","");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()==exitBut) {
            
            setVisible(false);
            new login().setVisible(true);
            
        }
        // else if(e.getSource()==depositButton){

        // }
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}