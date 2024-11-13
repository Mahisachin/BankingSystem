package bank;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

public class pinUpdate extends JFrame implements ActionListener{

    String formNo;
    JLabel image;JLabel text,text1;
    JTextField curPin,newPin;
    JButton newPinBtn,backBut,chngPinBtn;

    pinUpdate(String formNo){

        this.formNo = formNo;

        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,850,Image.SCALE_DEFAULT); 
        ImageIcon i3=new ImageIcon(i2);
        image=new JLabel(i3);
        image.setBounds(0,0,900,850);
        add(image);

        text1=new JLabel("Enter Your New Pin Number ");
        text1.setFont(new Font("Raleway",Font.BOLD,17));
        text1.setBounds(230,300,320,20);
        text1.setForeground(Color.WHITE);
        image.add(text1);

        newPin=new JTextField();
        newPin.setFont(new Font("Raleway", Font.BOLD,30));
        newPin.setBackground(Color.cyan);
        newPin.setBounds(200,330,275,40);
        image.add(newPin);

        chngPinBtn=new JButton("CHANGE PIN");
        chngPinBtn.setBounds(345,457,170,29);
        chngPinBtn.setFont(new Font("Raleway",Font.BOLD,20));
        chngPinBtn.addActionListener(this);
        image.add(chngPinBtn);

        backBut=new JButton("BACK");
        backBut.setFont(new Font("Raleway",Font.BOLD,25));
        backBut.setBounds(345,490,170,30);
        backBut.addActionListener(this);
        image.add(backBut);

        
        setSize(900,900);
        setVisible(true);

    }


    public static void main(String[] args) {
        new pinUpdate("469");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        

        if(e.getSource()==chngPinBtn){

            String nPin=newPin.getText();

            if(nPin.isEmpty()||nPin.equals("")){
                JOptionPane.showMessageDialog(null,"New pin is required");
            }

            else{
                try {

                    conn c=new conn();
                    String query1="update login set pinNo='"+nPin+"' where formNo='"+formNo+"'";
                    String query2="update account set pinNo='"+nPin+"' where formNo='"+formNo+"'";
                    c.s.executeUpdate(query2);
                    c.s.executeUpdate(query1);
                    JOptionPane.showMessageDialog(null, "PIN Changed");
                    setVisible(false);
                    new login().setVisible(true);
                    
                } catch (Exception ae) {
                    // TODO: handle exception
                }
            }


        }

        else if (e.getSource()==backBut){
            setVisible(false);
            new login().setVisible(true);
        }

        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

}
