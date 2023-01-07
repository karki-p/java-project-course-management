import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


//viewInstructorModule, viewStudent, addMarks 

public class Instructor extends JFrame implements ActionListener {
    MyDbcon dbms = new MyDbcon ();

    JFrame stdFrame;
    JLabel stdLabel;
    JButton btn1, btn2, btn3, backbtn;
    JComboBox getBox;
    JTextField field1, field2;



    Instructor() {
        setBackground(Color.gray);
        setLayout(null);


        stdLabel = new JLabel("-- Instructor Panel --");
        stdLabel.setBounds(180, 20, 500, 30); // set position of label
        stdLabel.setForeground(new Color(64, 64, 64)); // set bg color
        stdLabel.setFont(new Font("SansSerif", Font.BOLD, 25));// customize font
        add(stdLabel);

        ImageIcon img2 = new ImageIcon("teacher-logo.png");
        Image img22 = img2.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon img222 = new ImageIcon(img22);
        JLabel label2 = new JLabel(img222);
        label2.setBounds(400, 60, 150, 150);
        add(label2);

        btn1 = new JButton("My Module");
        btn1.setBounds(60, 100, 120, 30);
        btn1.setFont(new Font("serif", Font.BOLD, 15));
        btn1.addActionListener(this);
        btn1.setBackground(new Color(25, 41, 88));
        btn1.setForeground(Color.WHITE);
        add(btn1);

        btn2 = new JButton("View Students");
        btn2.setBounds(250, 100, 120, 30);
        btn2.setFont(new Font("serif", Font.BOLD, 15));
        btn2.setBackground(new Color(25, 41, 88));
        btn2.setForeground(Color.WHITE);
        add(btn2);

        btn2 = new JButton("Add Marks");
        btn2.setBounds(60, 170, 120, 30);
        btn2.setFont(new Font("serif", Font.BOLD, 15));
        btn2.setBackground(new Color(25, 41, 88));
        btn2.setForeground(Color.WHITE);
        add(btn2);

        field1 = new JTextField(); // Field box for user input
        field1.setBounds(95,105,100,30);
        field2 = new JTextField(); // Field box for user input
        field2.setBounds(95,105,100,30);

        backbtn = new JButton("> Go Back");
        backbtn.setBounds(250, 170, 120, 30);
        backbtn.setFont(new Font("serif", Font.BOLD, 15));
        backbtn.addActionListener(this);
        backbtn.setBackground(Color.red);
        backbtn.setForeground(Color.WHITE);
        add(backbtn);

        getContentPane().setBackground(Color.white); // frame bg color

        setVisible(true); // make frame visible
        setSize(600, 300);
        setLocation(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Course Management System");
        setResizable(false);

    }


    void InsItem() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursePrototype", "root",
                    "");

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT DISTINCT tName FROM `data`;");

            while (rs.next()) {

                String iName = rs.getString("tName");

                getBox.addItem(iName);
            }
            con.close();
        } catch (Exception e6) {
            e6.printStackTrace();

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {
            try {

                String Sql = "SELECT * FROM `teacher`;";
                String sql = "SELECT FROM `teacher` WHERE `moduleid` = '" + getBox.getSelectedItem() + "';";
                String message = " Yoy are on " + getBox.getSelectedItem() + " Module";
                dbms.database(Sql, sql, message);

            } catch (Exception e8) {
                e8.printStackTrace();

            }
            if (e.getSource() == btn2) {

            }
        }
        else if (e.getSource() == btn2) {
                try {

                    String Sql = "SELECT * FROM `teacher`;";
                    String sql = "SELECT FROM `teacher` WHERE `stdId` = '" + getBox.getSelectedItem() + "';";
                    String message = "Your module students are " + getBox.getSelectedItem();
                    dbms.database(Sql, sql, message);

                } catch (Exception e8) {
                    e8.printStackTrace();

                }

            }

        else if (e.getSource() == backbtn) {
            MainPage main = new MainPage();
            this.dispose();
        }

    }
}



	
