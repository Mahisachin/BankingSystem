package bank;
import javax.swing.*;

// import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class login extends JFrame implements ActionListener{

    // 3450523408455614
    // 3450523401231327  9087


    JButton lgin,clear, signUp;
    JTextField cardsTxtFld;
    JPasswordField pinTxtFld;
    login(){
        setSize(800,600);
        
        setTitle("Automated Teller Machine System");

        setLayout(null);

        ImageIcon ic1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image ic2=ic1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon ic3=new ImageIcon(ic2);
        JLabel label=new JLabel(ic3);
        label.setBounds(70,10,100,100);
        add(label);

        JLabel text=new JLabel("Welcome To ATM");
        text.setFont(new Font("Osward", Font.BOLD,34));
        text.setBounds(200,40,400,40);
        add(text);

        JLabel cardNo=new JLabel("Card No :");
        cardNo.setFont(new Font("Osward", Font.BOLD,34));
        cardNo.setBounds(120,150,400,40);
        add(cardNo);

        cardsTxtFld=new JTextField();
        cardsTxtFld.setBounds(300,150,250,40);
        add(cardsTxtFld);

        JLabel pin=new JLabel("PIN :");
        pin.setFont(new Font("Osward", Font.BOLD,34));
        pin.setBounds(120,220,400,40);
        add(pin);

        pinTxtFld=new JPasswordField();
        pinTxtFld.setBounds(300,220,250,40);
        add(pinTxtFld);

        lgin=new JButton("SIGN IN");
        lgin.setBounds(300,300,100,40);
        lgin.addActionListener(this);
        add(lgin);

        clear=new JButton("CLEAR ALL");
        clear.setBounds(430,300,120,40);
        clear.addActionListener(this);
        add(clear);

        signUp=new JButton("SIGN UP/NEW USER/REGISTER");
        signUp.setBounds(300,370,250,40);
        signUp.addActionListener(this);
        add(signUp);

        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
        
    }   
    
    public void actionPerformed(ActionEvent ac){

        // JButton lgin,clear, signUp;
        if(ac.getSource()==clear){
             cardsTxtFld.setText("");
             pinTxtFld.setText(""); 
        }
        else if(ac.getSource()==lgin){
            conn c=new conn();
            String cardNumber=cardsTxtFld.getText();
            String pin=pinTxtFld.getText();

            String query="select * from login where cardNum='"+cardNumber+"' and pinNo='"+pin+"'";

            try{
                ResultSet rs = c.s.executeQuery(query);
                
                if(rs.next()){
                    String formNo=rs.getString("formNo");
                    System.out.println("form no is"+formNo);
                    setVisible(false);
                    new transactions(formNo).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Invalid Card Number or Pin No");
                }

            }
            catch(Exception ae){
            System.out.println(ae);
            }

        }
        else if(ac.getSource()==signUp){
            setVisible(false);
            new signUp1().setVisible(true);
        }

    }
    public static void main(String[] args) {
        new login();
    }
}

// temp=new JButton("DEPOSIT");
        // temp.setBounds(150,395,130,27);
        // // temp.addActionListener(this);
        // image.add(temp);
