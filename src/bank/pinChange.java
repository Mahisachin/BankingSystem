package bank;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

public class pinChange extends JFrame implements ActionListener{

    String formNo;
    JLabel image;JLabel text,text1;
    JTextField curPin,newPin;
    JButton newPinBtn,backBut,chngPinBtn;

    pinChange(String formNo){

        this.formNo = formNo;

        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,850,Image.SCALE_DEFAULT); 
        ImageIcon i3=new ImageIcon(i2);
        image=new JLabel(i3);
        image.setBounds(0,0,900,850);
        add(image);

        text=new JLabel("Enter  current Pin Number ");
        text.setFont(new Font("Raleway",Font.BOLD,17));
        text.setBounds(230,300,320,20);
        text.setForeground(Color.WHITE);
        image.add(text);

        curPin=new JTextField();
        curPin.setFont(new Font("Raleway", Font.BOLD,30));
        curPin.setBackground(Color.cyan);
        curPin.setBounds(200,330,275,40);
        image.add(curPin);

        newPinBtn=new JButton("NEW PIN");
        newPinBtn.setBounds(345,457,170,29);
        newPinBtn.setFont(new Font("Raleway",Font.BOLD,25));
        newPinBtn.addActionListener(this);
        image.add(newPinBtn);


        backBut=new JButton("BACK");
        backBut.setFont(new Font("Raleway",Font.BOLD,25));
        backBut.setBounds(345,490,170,30);
        backBut.addActionListener(this);
        image.add(backBut);

        
        setSize(900,900);
        setVisible(true);

    }


    public static void main(String[] args) {
        new pinChange("");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==newPinBtn){
            String oldPin=curPin.getText();
            try {
                
                if(oldPin.isEmpty()){
                    JOptionPane.showMessageDialog(null,"CURRENT PIN IS REQUIRED");
                }
                else{
                    conn c=new conn();
                    String query="select * from login where formNo='"+formNo+"'";
                    ResultSet rs=c.s.executeQuery(query);
                    String ldPin="";
                if(rs.next()){
                    ldPin=rs.getString("pinNo");

                }
                if(oldPin.equals(ldPin)){
                    
                    setVisible(false);
                    new pinUpdate(formNo).setVisible(true);

                }
                else{
                    JOptionPane.showMessageDialog(null,"Wrong PIN Entered \n please enter correct pin");
                }

                }


            } catch (Exception ae) {
                // TODO: handle exception
            }
        }
        else if(e.getSource()==backBut){
            setVisible(false);
            new transactions(formNo);
        }

        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
    
}
