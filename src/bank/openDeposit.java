package bank;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.*;

// import javax.swing.JButton;
import javax.swing.*;

public class openDeposit extends JFrame implements ActionListener{

    JButton depositButton,backBut;
    JTextField amount;
    String formNo;
    JLabel image;

    openDeposit(String formNo){

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
        new openDeposit("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        String amnt=amount.getText();
        Date date = new Date();
        String type="DEPOSIT";
        // long balance=Integer.parseInt(amnt);
        if(e.getSource()==depositButton){
            try {

                conn c2=new conn();
                String query1="select * from login where fromNo='"+formNo+"'";
                ResultSet rs = c2.s.executeQuery(query1);
                String atmNo="not found",pinNo="not found";
                    if(rs.next()){
                        atmNo=rs.getString("cardNum");
                        pinNo=rs.getString("pinNo");
                    }

                    // conn c1=new conn();
                    // String query2="select *from account where fromNo='"+formNo+"'";
                    // ResultSet rs2=c1.s.executeQuery(query2);
                    // String balance=rs2.getString("balance");

                conn c=new conn();
                String query="insert into account values('"+formNo+"','"+amnt+"','"+atmNo+"','"+pinNo+"')";
                c.s.executeQuery(query);
                setVisible(false);
                new login().setVisible(true);
                
            } catch (Exception ae) {
                // TODO: handle exception
                System.out.println(ae);
            }
        }
        else if(e.getSource()==backBut){
            try {

                conn c2=new conn();
                String query1="select * from login where formNo='"+formNo+"' ";
                ResultSet rs = c2.s.executeQuery(query1);
                String atmNo="not found",pinNo="not found";
                    if(rs.next()){
                        atmNo=rs.getString("cardNum");
                        pinNo=rs.getString("pinNo");
                    }

                amnt="0";
                conn c=new conn();
                String query="insert into account values('"+formNo+"','"+amnt+"','"+atmNo+"','"+pinNo+"')";
                c.s.executeQuery(query);
                setVisible(false);
                new login().setVisible(true);
                
            } catch (Exception ae) {
                // TODO: handle exception
                System.out.println(ae);
            }
        }


        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
