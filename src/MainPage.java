import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;

// Actionlistener is implemented to notify button click
public class MainPage extends JFrame implements ActionListener{
	// create instance for other class
	Student std = new Student();
	
	// declare variables for GUI components.
	JFrame frame1;
	JLabel label1;
	JButton button1, button2, button3, exitbtn;
	
	MainPage(){
		
		super();
		
		setBackground(Color.gray);
		setLayout(null);
		
		//title
		label1 = new JLabel("-- COURSE MANAGEMENT SYSTEM --");
		label1.setBounds(70,20,500,30); // set position of label
		label1.setForeground(new Color(64,64,64)); // set bg color
		label1.setFont(new Font("SansSerif",Font.BOLD,25));// customize font
		add(label1);
		
		//Initiating new ImageIcon for img
		ImageIcon img1 = new ImageIcon("main-logo.png");
		Image img11 = img1.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon img111 =  new ImageIcon(img11);
        JLabel label2 = new JLabel(img111);
        label2.setBounds(400,60,150,150);
        add(label2);
        
        // Buttons for all users
        button1 = new JButton("Student");
        button1.setBounds(60,100,120,30);
        button1.setFont(new Font("serif",Font.BOLD,15));
        button1.addActionListener(this);
        button1.setBackground(new Color(25,41,88));
        button1.setForeground(Color.WHITE);
        add(button1);

        button2=new JButton("Instructor");
        button2.setBounds(250,100,120,30);
        button2.setFont(new Font("serif",Font.BOLD,15));
        button2.addActionListener(this);
        button2.setBackground(new Color(25,41,88));
        button2.setForeground(Color.WHITE);
        add(button2);
        
        button3=new JButton("Admin");
        button3.setBounds(60,170,120,30);
        button3.setFont(new Font("serif",Font.BOLD,15));
        button3.addActionListener(this);
        button3.setBackground(new Color(25,41,88));
        button3.setForeground(Color.WHITE);
        add(button3);
        
        exitbtn=new JButton("> Exit");
        exitbtn.setBounds(250,170,120,30);
        exitbtn.setFont(new Font("serif",Font.BOLD,15));
        exitbtn.addActionListener(this);
        exitbtn.setBackground(Color.red);
        exitbtn.setForeground(Color.WHITE);
        add(exitbtn);
        
        
		
		
		getContentPane().setBackground(Color.white); // frame bg color
		
		setVisible(true); // make frame visible 
		setSize(600,300);
		setLocation(500,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Course Management System");
		setResizable(false);
		
		
	}
		
	
	public static void main(String[] args) {
		MainPage Mn = new MainPage();
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==button1) {
			Student std = new Student();
			this.dispose();//close this frame after opening new one
		}
		else if(e.getSource()==button2) {
			Instructor inst = new Instructor();
			this.dispose();//close this frame after opening new one
		}
		else if(e.getSource()==button3) {
			Admin admin = new Admin();
			this.dispose();//close this frame after opening new one
		}
		if(e.getSource()==exitbtn) {
			//this.setDefaultCloseOperation(JButton.EXIT_ON_CLOSE);
			this.dispose();//close this frame after opening new one
		}
	}  

}
