package bank;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.*;


public class fastCash extends JFrame implements ActionListener{
    String formNo;
    JButton c100,c5000,c200,c10000,c500,c20000,back,c1000;

    fastCash(String formNo){
        this.formNo = formNo;
        setLayout(null);


        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,850,Image.SCALE_DEFAULT); 
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,850);
        add(image);

        JLabel text =new JLabel("PLEASE SELECT YOUR AMOUNT");
        text.setFont(new Font("Raleway",Font.BOLD,20));
        text.setBounds(180,300,400,20);
        text.setForeground(Color.WHITE);
        image.add(text);


        c100=new JButton("Rs. 100");
        c100.setFont(new Font("Raleway",Font.BOLD,20));
        c100.setBounds(155,395,130,27);
        c100.addActionListener(this);
        image.add(c100);

        c5000=new JButton("Rs. 5000");
        c5000.setFont(new Font("Raleway",Font.BOLD,20));
        c5000.setBounds(365,395,150,27);
        c5000.addActionListener(this);
        image.add(c5000);

        
        // int i=Integer.parseInt("-400");
        
        c200=new JButton("Rs. 200");
        c200.setFont(new Font("Raleway",Font.BOLD,20));
        c200.setBounds(155,426,130,27);
        c200.addActionListener(this);
        image.add(c200);

        c10000=new JButton("Rs. 10000");
        c10000.setFont(new Font("Raleway",Font.BOLD,20));
        c10000.setBounds(365,426,150,27);
        c10000.addActionListener(this);
        image.add(c10000);

        c500=new JButton("Rs. 500");
        c500.setFont(new Font("Raleway",Font.BOLD,20));
        c500.setBounds(155,459,130,27);
        c500.addActionListener(this);
        image.add(c500);

        c20000=new JButton("Rs. 20000");
        c20000.setFont(new Font("Raleway",Font.BOLD,20));
        c20000.setBounds(365,459,150,27);
        c20000.addActionListener(this);
        image.add(c20000);

        back=new JButton("BACK");
        back.setFont(new Font("Raleway",Font.BOLD,20));
        back.setBounds(365,490,150,27);
        back.addActionListener(this);
        image.add(back);

        c1000=new JButton("Rs. 1000");
        c1000.setFont(new Font("Raleway",Font.BOLD,20));
        c1000.setBounds(155,490,130,27);
        c1000.addActionListener(this);
        image.add(c1000);



        setSize(900,900);
        // setUndecorated(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new fastCash("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        String amnt="";
        JButton[]btn={c100,c200,c500,c1000,c5000,c10000,c20000};
        String[]cash={"100", "200", "500", "1000", "5000", "10000", "20000"};
        for(int i=0;i<7;i++){
            if (e.getSource()==btn[i]) {
                amnt=cash[i]; 
                try {
                    Date d1 = new Date(); 
                    String date=d1.toString();
                    String type="Withdrawl";
                    System.out.println("today's date "+date);
                    
                    conn c=new conn();
                    String query1="select * from login where formNo='"+formNo+"'";
                    ResultSet rs = c.s.executeQuery(query1);
                    String atmNo="not found",pinNo="not found";
                    if(rs.next()){
                        atmNo=rs.getString("cardNum");
                        pinNo=rs.getString("pinNo");
                    }
    
                    conn c1=new conn();
                    String query2="select * from account where formNo='"+formNo+"'";
                    ResultSet rs2=c1.s.executeQuery(query2);
                    String balance="0";
                    if(rs2.next()){
                        balance=rs2.getString("balance");
                    }
    
                    long blns1=Long.parseLong(balance);  
                    long blns2=Long.parseLong(amnt);
    
                    if(blns1>=blns2){
                        String amount=Long.toString(blns1-blns2);
                        String query4="update account set balance='"+amount+"' where formNo='"+formNo+"' ";
                        String query3="insert into credit_or_debit values('"+formNo+"','"+date+"','"+type+"','"+amnt+"','"+atmNo+"','"+pinNo+"')";
                        c1.s.executeUpdate(query3);
                        c1.s.executeUpdate(query4);
                        setVisible(false);
                        new debit1(formNo).setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    }
                    
                    
                } catch (Exception ae) {
                    // TODO: handle exception
                    System.out.println(ae);
                }
            }
        }
        if(e.getSource()==back){
            setVisible(false);
            new transactions(formNo).setVisible(true);
        }
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
    
}
