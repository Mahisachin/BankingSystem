package bank;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.*;

import java.sql.*;

public class checkBalnc extends JFrame implements ActionListener{

    String formNo;
    JLabel image;
    JLabel text,text1;
    JButton yes,backBut;
    JTextField curPin;
    

        checkBalnc(String formNo){

        this.formNo = formNo;

        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,850,Image.SCALE_DEFAULT); 
        ImageIcon i3=new ImageIcon(i2);
        image=new JLabel(i3);
        image.setBounds(0,0,900,850);
        add(image);

        text=new JLabel("Enter  your Pin Number ");
        text.setFont(new Font("Raleway",Font.BOLD,17));
        text.setBounds(230,300,320,20);
        text.setForeground(Color.WHITE);
        image.add(text);

        curPin=new JTextField();
        curPin.setFont(new Font("Raleway", Font.BOLD,30));
        curPin.setBackground(Color.cyan);
        curPin.setBounds(200,330,275,40);
        image.add(curPin);

        yes=new JButton("ENTER");
        yes.setBounds(345,457,170,29);
        yes.setFont(new Font("Raleway",Font.BOLD,25));
        yes.addActionListener(this);
        image.add(yes);

        backBut=new JButton("BACK");
        backBut.setFont(new Font("Raleway",Font.BOLD,25));
        backBut.setBounds(345,490,170,30);
        backBut.addActionListener(this);
        image.add(backBut);
        
        setSize(900,850);
        setVisible(true);

    }


    public static void main(String[] args) {
        new checkBalnc("469");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==backBut) {
            
            setVisible(false);
            new transactions(formNo).setVisible(true);
            
        }
        else if(e.getSource()==yes){

            String pin=curPin.getText();

            

            try {
                
                conn c=new conn();
                String query="select *from account where formNo='"+formNo+"'";
                ResultSet rs=c.s.executeQuery(query);


                String balance="0";
                String comp="";
                if(rs.next()){
                    balance=rs.getString("balance");
                    comp=rs.getString("pinNo");

                }
                if(pin.equals(comp)){
                    setVisible(false);
                new credit(formNo,"Balance checked",balance).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Incorrect PIN");
                }

            } catch (Exception ae) {
                // TODO: handle exception
            }
        }
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }


    
}
