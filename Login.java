//Loginpage
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
class Login{
    JFrame fob;
    JTextField t1,t2;
    JLabel l1,l2,l3;
    JButton b1,b2;
    Login()
    {
        fob=new JFrame("Login");
        fob.setLocation(200,200);
        fob.setSize(400,400);
        fob.setLayout(null);

        //intialize Label
        l1=new JLabel("User Email");
        l2=new JLabel("Password");
        l3=new JLabel("Don't have an Account?");

        //intialize TextField
        t1=new JTextField(20);
        t2=new JTextField(20);

        //intialize Jbutton
        b1=new JButton("Ok");
        b2=new JButton("Cancel");

        fob.add(l1);
        fob.add(t1);
        fob.add(l2);
        fob.add(t2);
        fob.add(b1);
        fob.add(b2);
        fob.add(l3);
        l1.setBounds(80,50,100,20);
        t1.setBounds(170,50,100,20);
        l2.setBounds(80,100,100,20);
        t2.setBounds(170,100,100,20);
        b1.setBounds(90,150,50,30);
        b2.setBounds(180,150,80,30);
        l3.setBounds(110,200,220,20);
        l3.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent me)
            {
                fob.dispose();
                new Signup();
            }
        });
        fob.setVisible(true);

    }
    public static void main(String args[])
    {
        new Login();
    }
}