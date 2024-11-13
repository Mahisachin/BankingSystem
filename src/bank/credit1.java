package bank;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

// import javax.swing.JButton;
import javax.swing.*;

public class credit1 extends JFrame implements ActionListener{

    JButton yes,no;
    JTextField amount;
    String formNo;
    JLabel image;

    credit1(String formNo){

        this.formNo = formNo;

        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,850,Image.SCALE_DEFAULT); 
        ImageIcon i3=new ImageIcon(i2);
        image=new JLabel(i3);
        image.setBounds(0,0,900,850);
        add(image);

        JLabel text=new JLabel("AMOUNT CREDITED");
        text.setFont(new Font("Raleway",Font.BOLD,17));
        text.setBounds(250,300,320,20);
        text.setForeground(Color.WHITE);
        image.add(text);

        JLabel nxText=new JLabel("DISPLAY MY BALANCE");
        nxText.setFont(new Font("Raleway",Font.BOLD,17));
        nxText.setBounds(235,325,320,20);
        nxText.setForeground(Color.WHITE);
        image.add(nxText);

        // amount=new JTextField();
        // amount.setFont(new Font("Raleway", Font.BOLD,30));
        // amount.setBackground(Color.cyan);
        // amount.setBounds(200,355,275,40);
        // image.add(amount);

        yes=new JButton("YES");
        yes.setBounds(345,457,170,29);
        yes.setFont(new Font("Raleway",Font.BOLD,25));
        yes.addActionListener(this);
        image.add(yes);

        no=new JButton("NO");
        no.setFont(new Font("Raleway",Font.BOLD,25));
        no.setBounds(345,490,170,30);
        no.addActionListener(this);
        image.add(no);

        setSize(900,850);
        setVisible(true);
    }

    public static void main(String[] args) {
        new credit1("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()==no) {
            
            setVisible(false);
            new login().setVisible(true);
            
        }
        else if(e.getSource()==yes){
            
            try {
                
                conn c1=new conn();
                String query2="select * from account where formNo='"+formNo+"'";
                ResultSet rs2=c1.s.executeQuery(query2);
                String balance="0";
                if(rs2.next()){
                    balance=rs2.getString("balance");
                }

                System.out.println("balance is  " + balance);

                setVisible(false);
                new credit(formNo,"AMOUNT CREDITED",balance).setVisible(true);

            } catch (Exception ae) {
                // TODO: handle exception
            }

            
        }
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}