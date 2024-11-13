package bank;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.*;

// import javax.swing.JButton;
import javax.swing.*;

public class deposit extends JFrame implements ActionListener{

    JButton depositButton,backBut;
    JTextField amount;
    String formNo;
    JLabel image;

    deposit(String formNo){

        this.formNo = formNo;

        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,850,Image.SCALE_DEFAULT); 
        ImageIcon i3=new ImageIcon(i2);
        image=new JLabel(i3);
        image.setBounds(0,0,900,850);
        add(image);

        JLabel text=new JLabel("Enter the amount you want to deposit");
        text.setFont(new Font("Raleway",Font.BOLD,17));
        text.setBounds(190,300,320,20);
        text.setForeground(Color.WHITE);
        image.add(text);

        amount=new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD,30));
        amount.setBackground(Color.cyan);
        amount.setBounds(200,330,275,40);
        image.add(amount);

        depositButton=new JButton("DEPOSIT");
        depositButton.setBounds(345,457,170,29);
        depositButton.setFont(new Font("Raleway",Font.BOLD,25));
        depositButton.addActionListener(this);
        image.add(depositButton);

        backBut=new JButton("BACK");
        backBut.setFont(new Font("Raleway",Font.BOLD,25));
        backBut.setBounds(345,490,170,30);
        backBut.addActionListener(this);
        image.add(backBut);

        setSize(900,850);
        setVisible(true);
    }

    public static void main(String[] args) {
        new deposit("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        if (e.getSource()==backBut) {
            
            setVisible(false);
            new transactions(formNo).setVisible(true);
            
        }
        else if (e.getSource()==depositButton) {
            // setVisible(false);,
            
            String amnt=amount.getText();
            if(amnt==null||amnt.isEmpty()){
                JOptionPane.showMessageDialog(null, "INVALID AMOUNT");
            }
            else{
                try {
                    Date d1 = new Date(); 
                    String date=d1.toString();
                    String type="Deposit";
                    System.out.println("today's date "+date);
                    
                    String atmNo="not found",pinNo="not found";

                    conn c=new conn();
                    String query1="select * from login where formNo='"+formNo+"'";
                    ResultSet rs = c.s.executeQuery(query1);
                    if(rs.next()){
                        atmNo=rs.getString("cardNum");
                        pinNo=rs.getString("pinNo");
                    }
                    System.out.println("atm no is "+atmNo+ "\n and pin is "+pinNo);
                    conn c1=new conn();
                    String query2="select * from account where formNo='"+formNo+"'";
                    ResultSet rs2=c1.s.executeQuery(query2);
                    String balance="0";
                    if(rs2.next()){
                        balance=rs2.getString("balance");
                    }
                    
                    System.out.println("balance is  "+balance);
                    System.out.println("form no is  "+formNo);

                    long blns1=Long.parseLong(balance);  
                    long blns2=Long.parseLong(amnt);

                    String amount=Long.toString(blns1+blns2);
                    String query4="update account set balance='"+amount+"' where formNo='"+formNo+"'";
                    String query3="insert into credit_or_debit values('"+formNo+"','"+date+"','"+type+"','"+amnt+"','"+atmNo+"','"+pinNo+"')";
                    c1.s.executeUpdate(query3);
                    c1.s.executeUpdate(query4);
                    

                    setVisible(false);
                    new credit1(formNo).setVisible(true);

                    
                } catch (Exception ae) {
                    // TODO: handle exception
                    // System.out.println(ae);
                }
            }

            
        }

        
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
    
}
