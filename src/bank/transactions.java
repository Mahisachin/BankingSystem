package bank;

import java.awt.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class transactions extends JFrame implements ActionListener{
    String formNo;
    JButton dep,cashWith,fCash,mStat,pinChng,balInq,exit;

    transactions(String formNo){
        this.formNo = formNo;
        setLayout(null);


        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,850,Image.SCALE_DEFAULT); 
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,850);
        add(image);

        JLabel text =new JLabel("Please select your transactions");
        text.setFont(new Font("Raleway",Font.BOLD,17));
        text.setBounds(200,300,400,20);
        text.setForeground(Color.WHITE);
        image.add(text);


        dep=new JButton("DEPOSIT");
        dep.setBounds(155,395,130,27);
        dep.addActionListener(this);
        image.add(dep);

        cashWith=new JButton("CASH WITHDRAWL");
        cashWith.setBounds(365,395,150,27);
        cashWith.addActionListener(this);
        image.add(cashWith);

        

        fCash=new JButton("FAST CASH");
        fCash.setBounds(155,426,130,27);
        fCash.addActionListener(this);
        image.add(fCash);

        mStat=new JButton("MINI STATEMENT");
        mStat.setBounds(365,426,150,27);
        mStat.addActionListener(this);
        image.add(mStat);

        pinChng=new JButton("PIN CHANGE");
        pinChng.setBounds(155,459,130,27);
        pinChng.addActionListener(this);
        image.add(pinChng);

        balInq=new JButton("BALANCE INQUIRY");
        balInq.setBounds(365,459,150,27);
        balInq.addActionListener(this);
        image.add(balInq);

        exit=new JButton("EXIT");
        exit.setFont(new Font("Raleway",Font.BOLD,20));
        exit.setBounds(365,490,150,27);
        exit.addActionListener(this);
        image.add(exit);



        setSize(900,900);
        // setUndecorated(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new transactions("469");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        System.out.println("my form no is  "+formNo);
        if(e.getSource()==dep){
            setVisible(false);
            new deposit(formNo).setVisible(true);
        }
        else if(e.getSource()==cashWith){
            setVisible(false);
            new withdraw(formNo).setVisible(true);
        }
        else if(e.getSource()==fCash){
            setVisible(false);
            new fastCash(formNo).setVisible(true);
        }
        else if(e.getSource()==pinChng){
            setVisible(false);
            new pinChange(formNo).setVisible(true);
        }
        else if(e.getSource()==balInq){
            setVisible(false);
            new checkBalnc(formNo).setVisible(true);
        }
        else if(e.getSource()==mStat){
            setVisible(false);
            new miniStatement(formNo);
        }
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
    
}
