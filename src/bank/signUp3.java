package bank;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;

public class signUp3 extends JFrame implements ActionListener{

    JComboBox rel;
    JRadioButton savAcc,curAcc,fixAcc,recAcc;
    JCheckBox atm,inBank,mbBank,email,chqBook,eStatement,declare;
    JButton submit,cancel;
    String formNo;



    signUp3(String formNo){
        this.formNo = formNo;

        setLayout(null);

        JLabel l1=new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,28));
        l1.setBounds(250,50,400,30);
        add(l1);
        JLabel type=new JLabel("Account Type: ");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(120,110,300,30);
        add(type);

        savAcc=new JRadioButton("Saving Account");
        // savAcc.setFont(new Font("Raleway",Font.BOLD,15));
        savAcc.setBounds(125,150,150,20);
        savAcc.setBackground(Color.WHITE);
        add(savAcc);

        fixAcc=new JRadioButton("Fixed Deposit Account");
        fixAcc.setBounds(350,150,200,20);
        fixAcc.setBackground(Color.WHITE);
        add(fixAcc);

        curAcc=new JRadioButton("Current Account");
        curAcc.setBounds(125,190,150,20);
        curAcc.setBackground(Color.WHITE);
        add(curAcc);

        recAcc=new JRadioButton("Recurring Deposit Account");
        recAcc.setBounds(350,190,200,20);
        recAcc.setBackground(Color.WHITE);
        add(recAcc);

        ButtonGroup group=new ButtonGroup();
        group.add(savAcc);
        group.add(recAcc);
        group.add(fixAcc);
        group.add(curAcc);


        JLabel crdNo=new JLabel("Card Number: ");
        crdNo.setFont(new Font("Raleway",Font.BOLD,24));
        crdNo.setBounds(120,240,200,30);
        add(crdNo);

        JLabel sampleCrd=new JLabel("XXXX-XXXX-XXXX-4147");
        sampleCrd.setFont(new Font("Raleway",Font.PLAIN,24));
        sampleCrd.setBounds(330,240,300,30);
        add(sampleCrd);

        JLabel crdText=new JLabel("Your 16 digit card no:");
        crdText.setFont(new Font("Raleway",Font.PLAIN,12));
        crdText.setBounds(125,270,200,20);
        add(crdText);

        JLabel pin=new JLabel("PIN: ");
        pin.setFont(new Font("Raleway",Font.BOLD,24));
        pin.setBounds(120,330,200,30);
        add(pin);

        JLabel samplePin=new JLabel("XXXX");
        samplePin.setFont(new Font("Raleway",Font.PLAIN,24));
        samplePin.setBounds(330,330,200,30);
        add(samplePin);

        JLabel pinText=new JLabel("Your 4 Digit Password");
        pinText.setFont(new Font("Raleway",Font.PLAIN,12));
        pinText.setBounds(125,360,200,20);
        add(pinText);

        JLabel serv=new JLabel("Service Required: ");
        serv.setFont(new Font("Raleway",Font.BOLD,24));
        serv.setBounds(120,410,300,30);
        add(serv);

        atm=new JCheckBox("ATM CARD");
        atm.setFont(new Font("Raleway",Font.PLAIN,15));
        atm.setBackground(Color.WHITE);
        atm.setBounds(125,460-10,200,20);
        add(atm);

        // inBank,mbBank,email,chqBook,eStatement
        inBank=new JCheckBox("Internet Banking");
        inBank.setFont(new Font("Raleway",Font.PLAIN,15));
        inBank.setBackground(Color.WHITE);
        inBank.setBounds(400,460-10,200,20);
        add(inBank);

        mbBank=new JCheckBox("Mobile Banking");
        mbBank.setFont(new Font("Raleway",Font.PLAIN,15));
        mbBank.setBackground(Color.WHITE);
        mbBank.setBounds(125,520-10,200,20);
        add(mbBank);

        email=new JCheckBox("Email & SMS Alerts");
        email.setFont(new Font("Raleway",Font.PLAIN,15));
        email.setBackground(Color.WHITE);
        email.setBounds(400,520-10,250,20);
        add(email);

        chqBook=new JCheckBox("Cheque Book");
        chqBook.setFont(new Font("Raleway",Font.PLAIN,15));
        chqBook.setBackground(Color.WHITE);
        chqBook.setBounds(125,580-10,200,20);
        add(chqBook);

        eStatement=new JCheckBox("E-Statement");
        eStatement.setFont(new Font("Raleway",Font.PLAIN,15));
        eStatement.setBackground(Color.WHITE);
        eStatement.setBounds(400,580-10,200,20);
        add(eStatement);

        declare=new JCheckBox("* I hereby declares that the above entered details are correcty to the best of my knowlwdge.");
        declare.setFont(new Font("Raleway",Font.BOLD,15));
        declare.setBackground(Color.WHITE);
        declare.setBounds(125,650-10,700,20);
        add(declare);
        
        submit=new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD,22));
        submit.setBounds(500,690,150,40);
        submit.addActionListener(this);
        add(submit);


        cancel=new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway",Font.BOLD,22));
        cancel.setBounds(200,690,150,40);
        cancel.addActionListener(this);
        add(cancel);


        getContentPane().setBackground(Color.WHITE);
        setSize(850,820); 
        setVisible(true );
    }

    public static void main(String[] args) {
        new signUp3("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String accType=null;
        if(savAcc.isSelected()){
            accType="Saving Account";
        }
        else if(curAcc.isSelected()){
            accType="Current Account";
        }
        else if(fixAcc.isSelected()){
            accType="Fixed Deposit Account";
        }
        else if(recAcc.isSelected()){
            accType="Recurring Deposit Account";
        }
        
        String service="";


        if(atm.isSelected()){
            service=service+"ATM CARD, ";
        }
        if(inBank.isSelected()){
            service=service+"Internet Banking, ";
        }
        if(mbBank.isSelected()){
            service=service+"Mobile Banking, ";
        }
        if(email.isSelected()){
            service=service+"Email & SMS Update, ";
        }
        if(chqBook.isSelected()){
            service=service+"Cheque Book, ";
        }
        if(eStatement.isSelected()){
            service=service+"E-Statement, ";
        }

        String checkBox=""; 

        if(declare.isSelected()){
            checkBox="true";
        }
        

        if(e.getSource()==submit){
            if(accType==null){
                JOptionPane.showMessageDialog(null,"Account type is required");
            }
            else if (service.equals("")){
                JOptionPane.showMessageDialog(null,"Minimum one service is required");
            }
            else if(checkBox.equals("")){
                JOptionPane.showMessageDialog(null,"Declaration is mandatory");
            }
            else{
                Random rnd = new Random();
                String cardNumber=""+(Math.abs((rnd.nextLong() %90000000L))+3450523400000000L);
                String pinNo=""+(Math.abs(rnd.nextInt()% 9000)+1000);

                try{                        
                    conn c=new conn();
                    String query1="insert into signupthree values('"+formNo+"','"+accType+"','"+cardNumber+"','"+pinNo+"','"+service+"','"+checkBox+"')";
                    String query2="insert into login values('"+formNo+"','"+cardNumber+"','"+pinNo+"')";
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null, "Card Number: "+cardNumber+"\n Pin: "+pinNo);
                    setVisible(false);
                    new openDeposit(formNo).setVisible(true);

                } catch(Exception ae){
                    System.out.println(ae);
                }

            }
        }
        else if(e.getSource()==cancel){
            setVisible(false);
            new login().setVisible(true);
        }

        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
