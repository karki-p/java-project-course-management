import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Enroll extends JFrame implements ActionListener {

    MyDbcon dbms = new MyDbcon ();

    JLabel title, t1, courseLab, t2, t3, lvlLab, optLab;
    JComboBox optCourse , optLvl, optSub;
    JButton sub, backbtn;
    TextField nameField, emailField, contactField ;



    Enroll(){
        setBackground(Color.gray);
        setLayout(null);

        title = new JLabel("- ENROLL FORM -");
        title.setBounds(190,5,500,50);
        title.setFont(new Font("SansSerif",Font.BOLD,20));
        title.setForeground(Color.black);
        add(title);

        t1 = new JLabel("Name");
        t1.setBounds(10,60,80,30);
        t1.setFont(new Font("serif",Font.BOLD,18));
        add(t1);

        nameField = new TextField(); // Field box for user input
        nameField.setBounds(95,60,100,30);
        add(nameField);


        courseLab = new JLabel("Course");
        courseLab.setBounds(290,60,100,30);
        courseLab.setFont(new Font("serif",Font.BOLD,18));
        add(courseLab);

        String courses[] = {"BIT", "BBA","BBS"};
        optCourse = new JComboBox(courses);
        optCourse.setBackground(Color.WHITE);
        optCourse.setBounds(380,60,100,30);
        add(optCourse);

        lvlLab = new JLabel("Level");
        lvlLab.setBounds(290,105,100,30);
        lvlLab.setFont(new Font("serif",Font.BOLD,18));
        add(lvlLab);

        String lvls[] = {"4","5","6"};
        optLvl = new JComboBox(lvls);
        optLvl.setBackground(Color.WHITE);
        optLvl.setBounds(380,105,100,30);
        optLvl.addActionListener(this);
        add(optLvl);

        optLab = new JLabel("LVL6 Opt.");
        optLab.setBounds(290,150,100,30);
        optLab.setFont(new Font("serif",Font.BOLD,18));
        add(optLab);

        String optional[] = {"None","Optional1","Optional2","Optional3"};
        optSub = new JComboBox(optional);
        optSub.setBackground(Color.WHITE);
        optSub.setBounds(380,150,100,30);
        optSub.addActionListener(this);
        add(optSub);

        t2 = new JLabel("Email");
        t2.setBounds(10,105,80,30);
        t2.setFont(new Font("serif",Font.BOLD,18));
        add(t2);

        emailField = new TextField(); // Field box for user input
        emailField.setBounds(95,105,100,30);
        add(emailField);

        t3 = new JLabel("Contact No.");
        t3.setBounds(10,150,80,30);
        t3.setFont(new Font("serif",Font.BOLD,18));
        add(t3);

        contactField = new TextField(); // Field box for user input
        contactField.setBounds(95,150,100,30);
        add(contactField);

        sub=new JButton("Submit");
        sub.setBounds(150,200,120,30);
        sub.setFont(new Font("serif",Font.BOLD,15));
        sub.addActionListener(this);
        sub.setBackground(Color.green);
        sub.setForeground(Color.WHITE);
        add(sub);

        backbtn=new JButton("Cancle");
        backbtn.setBounds(300,200,120,30);
        backbtn.setFont(new Font("serif",Font.BOLD,15));
        backbtn.addActionListener(this);
        backbtn.setBackground(Color.red);
        backbtn.setForeground(Color.WHITE);
        add(backbtn);





        getContentPane().setBackground(Color.white); // frame bg color

        setVisible(true); // make frame visible
        setSize(600,300);
        setLocation(500,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Student Registration");
        setResizable(false);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // Insert student details into database
        if(e.getSource() == sub){
            try {
                String query = "SELECT * FROM `Login` WHERE username=?";
                Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/data", "root", "pass");
                PreparedStatement p = con.prepareStatement(query);
                ResultSet r = p.executeQuery();
                        Statement s = con.createStatement();
                        ResultSet rr = s.executeQuery("SELECT * FROM `student`;");
                        while (rr.next()) {
                            s.executeUpdate("INSERT INTO `student`(`name`, `contact`, `email`, `level`, `course`, `optional`) VALUES ('"+nameField.getText()+"','"+contactField.getText()+"','"+emailField.getText()+"','"+optLvl.getSelectedItem()+"','"+optCourse.getSelectedItem()+"','"+optSub.getSelectedItem()+"');");
                            JOptionPane.showMessageDialog(this, "Student Enrolled Successfully.");
                        }
                        con.close();
            }catch (Exception e1){
                e1.printStackTrace();

            }

        }
        else if (e.getSource() == backbtn) {
            this.setVisible(false);
            MainPage main = new MainPage();


        }
    }}
