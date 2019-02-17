import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
class SignUp
{
    JFrame frm;
    JLabel fstNameLbl, lstNameLbl, dobLbl, gndrLbl, nationLbl, mblLbl, emlLbl, pass1Lbl, pass2Lbl;
    JTextField fstName, lstName, dob, nation, mbl, eml, pass1, pass2;
    JRadioButton ml, fml;
    ButtonGroup bgGndr;
    JButton sbmt, reset;
    String fstNameStr, lstNameStr, dobStr, gndrStr, nationStr, mblStr, emlStr, pass1Str, pass2Str;
    String[] arr = {fstNameStr, lstNameStr, dobStr, gndrStr = "Male", nationStr, mblStr, emlStr, pass1Str, pass2Str};
    //Connectivity
    Connection conn;
    Statement stmt;

    SignUp()
    {

        try{
        Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/LoginProject", "root", "root");
		stmt = conn.createStatement();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        frm = new JFrame("SignUp");
        frm.setSize(520, 650);
        frm.setLocation(100, 100);
        frm.setLayout(null);
        frm.setVisible(true);

        //Layout 
        //Labels
        fstNameLbl = new JLabel("First Name");
        fstNameLbl.setBounds(80, 50, 100, 20);
        lstNameLbl = new JLabel("Last Name");
        lstNameLbl.setBounds(80, 100, 100, 20);
        dobLbl = new JLabel("Date Of Birth");
        dobLbl.setBounds(80, 150, 100, 20);
        gndrLbl = new JLabel("Gender");
        gndrLbl.setBounds(80, 200, 100, 20);
        nationLbl = new JLabel("Nationality");
        nationLbl.setBounds(80, 250, 100, 20);
        mblLbl = new JLabel("Mobile No.");
        mblLbl.setBounds(80, 300, 100, 20);
        emlLbl = new JLabel("Email");
        emlLbl.setBounds(80, 350, 100, 20);
        pass1Lbl = new JLabel("Enter Password");
        pass1Lbl.setBounds(80, 400, 100, 20);
        pass2Lbl = new JLabel("Re-Enter Password");
        pass2Lbl.setBounds(80, 450, 130, 20);

        //TextFields
        fstName = new JTextField(20);
        fstName.setBounds(220, 50, 200, 20);
        lstName = new JTextField(20);
        lstName.setBounds(220, 100, 200, 20);
        dob = new JTextField(20);
        dob.setBounds(220, 150, 200, 20);
        nation = new JTextField(20);
        nation.setBounds(220, 250, 200, 20);
        mbl = new JTextField(20);
        mbl.setBounds(220, 300, 200, 20);
        eml = new JTextField(20);
        eml.setBounds(220, 350, 200, 20);
        pass1 = new JTextField(20);
        pass1.setBounds(220, 400, 200, 20);
        pass2 = new JTextField(20);
        pass2.setBounds(220, 450, 200, 20);

        //RadioButton
        bgGndr = new ButtonGroup();
        ml = new JRadioButton("Male", true);
        ml.setBounds(220, 200, 70, 20);
        fml = new JRadioButton("Female");
        fml.setBounds(300, 200, 70, 20);
        bgGndr.add(ml);
        bgGndr.add(fml);

        //Button 

        sbmt = new JButton("Submit");
        sbmt.setBounds(100, 500, 120, 50);

        reset = new JButton("Reset");
        reset.setBounds(300, 500, 120, 50);
        //Adding Elements

        frm.add(fstNameLbl);
        frm.add(fstName);
        frm.add(lstNameLbl);
        frm.add(lstName);
        frm.add(dobLbl);
        frm.add(dob);
        frm.add(gndrLbl);
        frm.add(ml);
        frm.add(fml);
        frm.add(nationLbl);
        frm.add(nation);
        frm.add(mblLbl);
        frm.add(mbl);
        frm.add(emlLbl);
        frm.add(eml);
        frm.add(pass1Lbl);
        frm.add(pass1);
        frm.add(pass2Lbl);
        frm.add(pass2);
        frm.add(sbmt);
        frm.add(reset);

        ml.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                gndrStr = "Male";
            }
        });

        fml.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                gndrStr = "Female";
            }
        });

        sbmt.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                
                fstNameStr = fstName.getText();
                lstNameStr = lstName.getText();
                dobStr = dob.getText();
                nationStr = nation.getText();
                mblStr = mbl.getText();
                emlStr = eml.getText();
                pass1Str = pass1.getText();
                pass2Str = pass2.getText();
                try
                {
                    stmt.executeUpdate("Insert into SignUp(fstName, lstName, dob, gndr, nation, mbl, eml, pass1, pass2) values ('"+fstNameStr+"', '"+lstNameStr+"', '"+dobStr+"','"+gndrStr+"' ,'"+nationStr+"','"+mblStr+"','"+emlStr+"','"+pass1Str+"','"+pass2Str+"')");
                }
                catch(Exception e){
                    e.printStackTrace();
                }
                
            }
        });
    }

    public static void main(String[] args) 
    {
        new SignUp();    
    }
}