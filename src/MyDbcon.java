import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
    
    public class MyDbcon extends JFrame{
        
        void database(String Sql, String sql, String message) throws Exception {
    
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306:3306/data", "root", "pass"); // conn.. url and db user password.
            //c=DriverManager.getConnection("jdbc:mysql://localhost:3306/data","root","pass");

            Statement s = c.createStatement();
            ResultSet r = s.executeQuery(Sql);
    
            while (r.next()) {
    
                s.executeUpdate(sql);
                JOptionPane.showMessageDialog(this, message);
    
            }
            c.close();
    
        }
    
    }