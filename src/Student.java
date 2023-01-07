import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


//enroll, at lvl6 optional, viewInstructor 

public class Student extends JFrame implements ActionListener{

	JLabel stdLabel;
	JButton btn1,btn2,btn3;
	JFrame stdF;
	
	
	
	Student(){
		setBackground(Color.gray);
		setLayout(null);
		
		
		stdLabel = new JLabel("-- Student Panel --");
		stdLabel.setBounds(180,20,500,30); // set position of label
		stdLabel.setForeground(new Color(64,64,64)); // set bg color
		stdLabel.setFont(new Font("SansSerif",Font.BOLD,25));// customize font
		add(stdLabel);
		
		ImageIcon img2 = new ImageIcon("std-logo.png");
		Image img22 = img2.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon img222 =  new ImageIcon(img22);
        JLabel label2 = new JLabel(img222);
        label2.setBounds(400,60,150,150);
        add(label2);
        
        btn1 = new JButton("Enroll");
        btn1.setBounds(60,100,120,30);
        btn1.setFont(new Font("serif",Font.BOLD,15));
        btn1.addActionListener(this);
        btn1.setBackground(new Color(25,41,88));
        btn1.setForeground(Color.WHITE);
        add(btn1);

        btn2=new JButton("View Instructor");
        btn2.setBounds(220,100,140,30);
        btn2.setFont(new Font("serif",Font.BOLD,15));
        btn2.addActionListener(this);
        btn2.setBackground(new Color(25,41,88));
        btn2.setForeground(Color.WHITE);
        add(btn2);
        
        btn3=new JButton("> Go Back");
        btn3.setBounds(150,170,120,30);
        btn3.setFont(new Font("serif",Font.BOLD,15));
        btn3.addActionListener(this);
        btn3.setBackground(Color.red);
        btn3.setForeground(Color.WHITE);
        add(btn3);
		
		getContentPane().setBackground(Color.white); // frame bg color
		
		setVisible(true); // make frame visible 
		setSize(600,300);
		setLocation(500,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Student Management System");
		setResizable(false);
		
	}




	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==btn3) {
			MainPage main = new MainPage();
			this.dispose();
		}
		//Student will be redirected to another frame for enroll.
		if(e.getSource()==btn1) {
			Enroll enroll = new Enroll();
			this.dispose();
		}
		// View Instructor on button goes to another page
		if(e.getSource()==btn2) {
			Instructor enroll = new Instructor();
			this.dispose();
		}
	}
	
}

	
