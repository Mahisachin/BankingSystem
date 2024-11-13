package bank;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;

public class signUp1 extends JFrame implements ActionListener {
    JTextField nmTxtFld,fnmTxtFld,emailTxt,adrsTxt,cityTxt,stateTxt,countryTxt,pinNum,mobNo;
    JDateChooser date;
    JButton cancel,next;
    JRadioButton male,fmale,others,marry,umarry;
    long rad;
    signUp1(){
        setLayout(null);
        Random ran=new Random();

        rad=(int)(Math.abs(((int)ran.nextLong() % 9000L )+1000L));
        // System.out.println(rad);
        JLabel formNo=new JLabel("Application Form No : "+ rad);
        formNo.setFont(new Font("Raleway",Font.BOLD,38));
        formNo.setBounds(140,20,600,40);
        add(formNo);

        JLabel personalDetls=new JLabel("Page 1 : Personal Details");
        personalDetls.setFont(new Font("Raleway",Font.BOLD,22));
        personalDetls.setBounds(250,70,400,40);
        add(personalDetls);

        JLabel name=new JLabel("Enter Your Name : ");
        name.setFont(new Font("Raleway",Font.PLAIN,22));
        name.setBounds(70,130,200,30);
        add(name);

        nmTxtFld=new JTextField();
        nmTxtFld.setFont(new Font("Raleway",Font.BOLD,22));
        nmTxtFld.setBounds(280,130,500,30);
        add(nmTxtFld);

        JLabel Fname=new JLabel("Fathers Name : ");
        Fname.setFont(new Font("Raleway",Font.PLAIN,20));
        Fname.setBounds(70,170,200,30);
        add(Fname);

        fnmTxtFld=new JTextField();
        fnmTxtFld.setFont(new Font("Raleway",Font.BOLD,20));
        fnmTxtFld.setBounds(280,170,500,30);
        add(fnmTxtFld);

        JLabel dob=new JLabel("Date OF Birth : ");
        dob.setFont(new Font("Raleway",Font.PLAIN,22));
        dob.setBounds(70,210,200,30);
        add(dob);

        date=new JDateChooser();
        date.setBounds(280,210,200,30);
        add(date);

        JLabel gender=new JLabel("Gender : ");
        gender.setFont(new Font("Raleway",Font.PLAIN,22));
        gender.setBounds(70,250,200,30);
        add(gender);

        male=new JRadioButton("Male");
        male.setBounds(280,250,150,30);
        male.setBackground(Color.WHITE);
        add(male);

        fmale=new JRadioButton("Female");
        fmale.setBounds(440,250,150,30);
        fmale.setBackground(Color.WHITE);
        add(fmale);

        others=new JRadioButton("Others");
        others.setBounds(600,250,150,30);
        others.setBackground(Color.WHITE);
        add(others);

        ButtonGroup genderGroup=new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(fmale);
        genderGroup.add(others);

        JLabel email=new JLabel("Enter  Your Email : ");
        email.setFont(new Font("Raleway",Font.PLAIN,22));
        email.setBounds(70,290,200,30);
        add(email);

        emailTxt=new JTextField();
        emailTxt.setFont(new Font("Raleway",Font.BOLD,22));
        emailTxt.setBounds(280,290,500,30);
        add(emailTxt);

        JLabel married=new JLabel("Marital Status : ");
        married.setFont(new Font("Raleway",Font.PLAIN,22));
        married.setBounds(70,330,200,30);
        add(married);

        marry=new JRadioButton("Married");
        marry.setBounds(280,330,150,30);
        marry.setBackground(Color.WHITE);
        add(marry);

        umarry=new JRadioButton("Unmarried");
        umarry.setBounds(460,330,150,30);
        umarry.setBackground(Color.WHITE);
        add(umarry);

        ButtonGroup maryGroup=new ButtonGroup();
        maryGroup.add(marry);
        maryGroup.add(umarry);

        JLabel phone=new JLabel("Mobile No : ");
        phone.setFont(new Font("Raleway",Font.PLAIN,22));
        phone.setBounds(70,370,200,30);
        add(phone);

        mobNo=new JTextField();
        mobNo.setFont(new Font("Raleway",Font.BOLD,22));
        mobNo.setBounds(280,370,300,30);
        add(mobNo);

        JLabel adress=new JLabel("Address : ");
        adress.setFont(new Font("Raleway",Font.PLAIN,22));
        adress.setBounds(70,410,200,30);
        add(adress);

        adrsTxt=new JTextField();
        adrsTxt.setFont(new Font("Raleway",Font.BOLD,22));
        adrsTxt.setBounds(280,410,500,30);
        add(adrsTxt);

        JLabel city=new JLabel("City : ");
        city.setFont(new Font("Raleway",Font.PLAIN,22));
        city.setBounds(70,450,200,30);
        add(city);

        cityTxt=new JTextField();
        cityTxt.setFont(new Font("Raleway",Font.BOLD,22));
        cityTxt.setBounds(280,450,200,30);
        add(cityTxt);

        JLabel state=new JLabel("State : ");
        state.setFont(new Font("Raleway",Font.PLAIN,22));
        state.setBounds(70,490,200,30);
        add(state);

        stateTxt=new JTextField();
        stateTxt.setFont(new Font("Raleway",Font.BOLD,22));
        stateTxt.setBounds(280,490,200,30);
        add(stateTxt);

        JLabel country=new JLabel("Country : ");
        country.setFont(new Font("Raleway",Font.PLAIN,22));
        country.setBounds(70,530,200,30);
        add(country);

        countryTxt=new JTextField();
        countryTxt.setFont(new Font("Raleway",Font.BOLD,22));
        countryTxt.setBounds(280,530,200,30);
        add(countryTxt);

        JLabel pincode=new JLabel("Pin Code : ");
        pincode.setFont(new Font("Raleway",Font.PLAIN,22));
        pincode.setBounds(70,570,200,30);
        add(pincode);

        pinNum=new JTextField();
        pinNum.setFont(new Font("Raleway",Font.BOLD,22));
        pinNum.setBounds(280,570,200,30);
        add(pinNum);

        cancel=new JButton("CANCEL");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway",Font.BOLD,22));
        cancel.setBounds(250,630,130,40);
        cancel.addActionListener(this);
        add(cancel);

        next=new JButton("NEXT");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,22));
        next.setBounds(430,630,130,40);
        next.addActionListener(this);
        add(next);

        

        setSize(850,800);
        setTitle("SIGN UP - Page 1");
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }


    public static void main(String[] args) {
        new signUp1();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");


        // JTextField nmTxtFld,fnmTxtFld,emailTxt,adrsTxt,cityTxt,stateTxt,countryTxt,pinNum,mobNo;

        // JButton cancel;
        // JRadioButton male,fmale,others,marry,umarry;
        String formNo=""+rad;
        String name=nmTxtFld.getText();
        String fname=fnmTxtFld.getText();
        String email=emailTxt.getText();
        String address=adrsTxt.getText();
        String city=cityTxt.getText();
        String state=stateTxt.getText();
        String country=countryTxt.getText();
        String pin=pinNum.getText();
        String mobile=mobNo.getText();
        // email.equals("")||address.equals("")||city.equals("")||state.equals("")||country.equals("")||pin.equals("")||mobile.equals("")||date.equals("")||gender==null||maritalStatus==null
        String dob=((JTextField) date.getDateEditor().getUiComponent()).getText();
        String gender=null;
        String maritalStatus=null;
        if(male.isSelected()){
            gender="male";
        }
        else if(fmale.isSelected()){
            gender="female";
        }

        else if(others.isSelected()){
            gender="other";
        }

        if(marry.isSelected()){
            maritalStatus="married";
        }
        else if(umarry.isSelected()){
            maritalStatus="unmarried";
        }

        if(e.getSource()==cancel){
            setVisible(false);
            new login().setVisible(true);
        }
        else if(e.getSource()==next){
            
            try{
                if(name.equals("")||fname.equals("")||email.equals("")||address.equals("")||city.equals("")||state.equals("")||country.equals("")||pin.equals("")||mobile.equals("")||date.equals("")||gender==null||maritalStatus==null){
                    JOptionPane.showMessageDialog(null,"PLEASE FILL ALL DETAILS");
                }
                else{
                    conn c=new conn();
                    String query="insert into signupone values('"+formNo+"','"+name+"','"+fname+"','"+email+"','"+address+"', '"+city+"','"+state+"','"+country+"','"+pin+"','"+mobile+"','"+dob+"','"+gender+"','"+maritalStatus+"')";
                    c.s.executeUpdate(query);
                    setVisible(false);
                    new signUp2((String)formNo).setVisible(true);
                }
            } catch(Exception ae){
                System.out.println(ae);
            }
        }
    }

}

// try{                        //religion category education income job pan adhaar,haveAcc
//     conn c=new conn();
//     String query="insert into signuptwo values('"+formNo+"','"+religion+"','"+education+"','"+income+"','"+job+"', '"+pan+"','"+adhaar+"','"+haveAcc+"','"+snrCtzn+"')";
//     c.s.executeUpdate(query);

//     setVisible(false);
//     new signUp3(formNo).setVisible(true);

// } catch(Exception ae){
// System.out.println(ae);
// }
