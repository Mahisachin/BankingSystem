package bank;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;


public class miniStatement extends JFrame implements ActionListener {

    JButton b1, b2;

    miniStatement(String formNo){
        setTitle("Mini Statement");
        
        setLayout(null);

        JLabel text=new JLabel();
        add(text);

        JLabel bank=new JLabel("HOSTEL BANK");
        bank.setBounds(130,20,100,30);
        add(bank);

        JLabel card=new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        JLabel mini=new JLabel();
        mini.setBounds(20,140,400,200);
        add(mini);

        
        try {
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("select * from account where formNo='"+formNo+"'");
            while(rs.next()){
                card.setText("Card No:  "+ rs.getString("cardNo").substring(0,4)+"XXXXXXXX"+rs.getString("cardNo").substring(12));
            }
            
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }

        try {
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("select * from credit_or_debit where formNo='"+formNo+"' ");
            int count=5;
            while(rs.next()&&count>0) {
                mini.setText(mini.getText()+"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+ "<br><br><html>");
                count--;
            }
            
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }


        setSize(400,600);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new miniStatement("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
    
}
