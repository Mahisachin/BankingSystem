package bank;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.*;

public class signUp2 extends JFrame implements ActionListener{

    JTextField salary,occup,panNo,adhar;
    JComboBox edu,rel,cat;
    JButton next;
    JRadioButton accExist,noAccExist,senior,nonSenior;
    String formNo;

    signUp2(String formNo){
        this.formNo=formNo;
        setLayout(null);

        JLabel additionalDetls=new JLabel("Page 2 : Additional Details");
        additionalDetls.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetls.setBounds(250,70,400,40);
        add(additionalDetls);

        JLabel relegion=new JLabel("Relegion : ");
        relegion.setFont(new Font("Raleway",Font.PLAIN,22));
        relegion.setBounds(70,130,200,30);
        add(relegion);

        String[] put={null,"Hindu","Muslim","Sikh","Cristhane","Others"};
        rel=new JComboBox(put);
        rel.setBounds(280,130,200,30);
        rel.setBackground(Color.WHITE);
        add(rel);

        JLabel category=new JLabel("Category : ");
        category.setFont(new Font("Raleway",Font.PLAIN,20));
        category.setBounds(70,170,200,30);
        add(category);

        String[] put1={null,"General","OBC","SC","ST"};
        cat=new JComboBox(put1);
        cat.setBounds(280,170,200,30);
        cat.setBackground(Color.WHITE);
        add(cat);


        JLabel income=new JLabel("Income (LPA): ");
        income.setFont(new Font("Raleway",Font.PLAIN,22));
        income.setBounds(70,210,200,30);
        add(income);


        salary=new JTextField();
        salary.setFont(new Font("Raleway",Font.BOLD,22));
        salary.setBounds(280,210,300,30);
        add(salary);


        JLabel education=new JLabel("Qualification : ");
        education.setFont(new Font("Raleway",Font.PLAIN,22));
        education.setBounds(70,250,200,30);
        add(education);

        String[] put2={null,"Below 10th Class","10th Pass","12th Pass","Graduation"};
        edu=new JComboBox(put2);
        edu.setBounds(280,250,200,30);
        edu.setBackground(Color.WHITE);
        add(edu);

        JLabel adh=new JLabel("Adhaar No : ");
        adh.setFont(new Font("Raleway",Font.PLAIN,22));
        adh.setBounds(70,290,200,30);
        add(adh);

        adhar=new JTextField();
        adhar.setFont(new Font("Raleway",Font.BOLD,22));
        adhar.setBounds(280,290,300,30);
        add(adhar);


        JLabel job=new JLabel("Occupation : ");
        job.setFont(new Font("Raleway",Font.PLAIN,22));
        job.setBounds(70,330,200,30);
        add(job);

        occup=new JTextField();
        occup.setFont(new Font("Raleway",Font.BOLD,22));
        occup.setBounds(280,330,500,30);
        add(occup);

        
        JLabel pan=new JLabel("Pan No : ");
        pan.setFont(new Font("Raleway",Font.PLAIN,22));
        pan.setBounds(70,370,200,30);
        add(pan);

        panNo=new JTextField();
        panNo.setFont(new Font("Raleway",Font.BOLD,22));
        panNo.setBounds(280,370,300,30);
        add(panNo);

        JLabel citizen=new JLabel("Senior Citizen : ");
        citizen.setFont(new Font("Raleway",Font.PLAIN,22));
        citizen.setBounds(70,410,200,30);
        add(citizen);

        senior=new JRadioButton("Yes");
        senior.setBounds(280,410,150,30);
        senior.setBackground(Color.WHITE);
        add(senior);

        nonSenior=new JRadioButton("No");
        nonSenior.setBounds(460,410,150,30);
        nonSenior.setBackground(Color.WHITE);
        add(nonSenior);
        ButtonGroup maryGroup=new ButtonGroup();
        maryGroup.add(senior);
        maryGroup.add(nonSenior);

        JLabel exists=new JLabel("Existing Account : ");
        exists.setFont(new Font("Raleway",Font.PLAIN,22));
        exists.setBounds(70,450,200,30);
        add(exists);

        accExist=new JRadioButton("Yes");
        accExist.setBounds(280,450,150,30);
        accExist.setBackground(Color.WHITE);
        add(accExist);

        noAccExist=new JRadioButton("NO");
        noAccExist.setBounds(460,450,150,30);
        noAccExist.setBackground(Color.WHITE);
        add(noAccExist);

        ButtonGroup genderGroup=new ButtonGroup();
        genderGroup.add(accExist);
        genderGroup.add(noAccExist);


        next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,22));
        next.setBounds(350,630,100,40);
        next.addActionListener(this);
        add(next);

        setSize(850,800);
        setTitle("SIGN UP - Page 2");
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }


    public static void main(String[] args) {
        new signUp2("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // JTextField salary,occup,panNo,adhar;
        // JComboBox edu,rel,cat;
        // JButton next;
        // JRadioButton accExist,noAccExist,senior,nonSenior;
        
        String religion=(String)rel.getSelectedItem();
        String category=(String)cat.getSelectedItem();
        String education=(String)edu.getSelectedItem();
        String income=salary.getText();
        String job=occup.getText();
        String pan=panNo.getText();
        String adhaar=adhar.getText();
        String haveAcc=null,snrCtzn =null;
        // religion.equals("")||category.eqals("")||education.equals("")||income.equals("")||job.equals("")||pan.equals("")||adhaar.equals("")||haveAcc.equals("")||snrCtzn.equals("")

        if(accExist.isSelected()){
            haveAcc="YES";
        }
        else if(noAccExist.isSelected()){
            haveAcc="NO";
        }

        if(senior.isSelected()){
            snrCtzn="YES";
        }
        else if(nonSenior.isSelected()){
            snrCtzn="NO";
        }
        
        if(e.getSource()==next){
            if(religion.equals("")||category.equals("")||education.equals("")||income.equals("")||job.equals("")||pan.equals("")||adhaar.equals("")||haveAcc.equals("")||snrCtzn.equals("")){
                JOptionPane.showMessageDialog(null,"Please fill all the details");
            }
            else{
                try{                        //religion category education income job pan adhaar,haveAcc
                    conn c=new conn();
                    String query="insert into signuptwo values('"+formNo+"','"+religion+"','"+education+"','"+income+"','"+job+"', '"+pan+"','"+adhaar+"','"+haveAcc+"','"+snrCtzn+"')";
                    c.s.executeUpdate(query);
    
                    setVisible(false);
                    new signUp3(formNo).setVisible(true);
                
            } catch(Exception ae){
                System.out.println(ae);
            }
            }
        }
        
    }
    
}
