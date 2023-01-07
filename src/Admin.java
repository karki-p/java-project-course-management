import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

import javax.swing.*;

import com.mysql.cj.xdevapi.Statement;


//addCourse, addModule, delete, update, generateReport,

public class Admin extends JFrame implements ActionListener {

    MyDbcon dbms = new MyDbcon();

    JFrame stdFrame;
    JLabel stdLabel;
    JButton btn1, btn2, btn3, btn4, btn5, backbtn;
    JTextField getInput, getInput1, getGetInput2;


    Admin() {
        setBackground(Color.gray);
        setLayout(null);


        stdLabel = new JLabel("-- Admin Panel --");
        stdLabel.setBounds(180, 20, 500, 30); // set position of label
        stdLabel.setForeground(new Color(64, 64, 64)); // set bg color
        stdLabel.setFont(new Font("SansSerif", Font.BOLD, 25));// customize font
        add(stdLabel);

        ImageIcon img2 = new ImageIcon("admin-logo.png");
        Image img22 = img2.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon img222 = new ImageIcon(img22);
        JTextField getInput = new JTextField();
        JTextField getInput1 = new JTextField();
        JTextField getInput2 = new JTextField();
        JLabel label2 = new JLabel(img222);
        label2.setBounds(425, 60, 150, 150);
        add(label2);

        btn1 = new JButton("Add Course");
        btn1.setBounds(10, 70, 120, 30);
        btn1.setFont(new Font("serif", Font.BOLD, 15));
        btn1.addActionListener(this);
        btn1.setBackground(new Color(25, 41, 88));
        btn1.setForeground(Color.WHITE);
        add(btn1);

        btn2 = new JButton("Add Module");
        btn2.setBounds(140, 70, 120, 30);
        btn2.setFont(new Font("serif", Font.BOLD, 15));
        btn2.addActionListener(this);
        btn2.setBackground(new Color(25, 41, 88));
        btn2.setForeground(Color.WHITE);
        add(btn2);

        btn3 = new JButton("Delete Course");
        btn3.setBounds(270, 70, 130, 30);
        btn3.setFont(new Font("serif", Font.BOLD, 15));
        btn3.addActionListener(this);
        btn3.setBackground(new Color(25, 41, 88));
        btn3.setForeground(Color.WHITE);
        add(btn3);

        btn4 = new JButton("Update Course");
        btn4.setBounds(10, 150, 140, 30);
        btn4.setFont(new Font("serif", Font.BOLD, 15));
        btn4.addActionListener(this);
        btn4.setBackground(new Color(25, 41, 88));
        btn4.setForeground(Color.WHITE);
        add(btn4);

        btn5 = new JButton("Generate Report");
        btn5.setBounds(170, 150, 150, 30);
        btn5.setFont(new Font("serif", Font.BOLD, 15));
        btn5.addActionListener(this);
        btn5.setBackground(new Color(25, 41, 88));
        btn5.setForeground(Color.WHITE);
        add(btn5);

        backbtn = new JButton("> Go Back");
        backbtn.setBounds(300, 200, 120, 30);
        backbtn.setFont(new Font("serif", Font.BOLD, 15));
        backbtn.addActionListener(this);
        backbtn.setBackground(Color.red);
        backbtn.setForeground(Color.WHITE);
        add(backbtn);

        JComboBox<String> delCourseBox;
        delCourseBox = new JComboBox<>();
        delCourseBox.setBounds(100, 100, 100, 100);
        courseItem();
        //add(delCourseBox);


        getContentPane().setBackground(Color.white); // frame bg color

        setVisible(true); // make frame visible
        setSize(600, 300);
        setLocation(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Admin Management");
        setResizable(false);

    }


    void courseItem() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/data", "root", "pass");
            //      Statement s = con.createStatement();
        } catch (Exception e4) {
            e4.printStackTrace();
        }


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //btn1 = adcourse, btn2 = addModule, btn3= delCourse
        try {

            String Sql = "SELECT * FROM `teacher`;";
            String sql = "SELECT FROM `teacher` WHERE `moduleid` = '" + getInput.getText() + "';";
            String message = " You are on " + getInput.getText() + " Module";
            dbms.database(Sql, sql, message);

        } catch (Exception e8) {
            e8.printStackTrace();

        }
        if (e.getSource() == btn2) {

        } else if (e.getSource() == btn3) {
            try {

                String Sql = "SELECT * FROM `course`;";
                String sql = "DELETE FROM `course` WHERE `courseName` = '" + getInput1.getText() + "';";
                String message = " " + getInput1.getText() + " Course has been deleted.";
                dbms.database(Sql, sql, message);

            } catch (Exception e8) {
                e8.printStackTrace();

            }
        }
    }
}


	
