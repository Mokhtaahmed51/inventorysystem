  

package SmartInventoryManagementSystem; 

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
  

public class MyConnection {

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/inventory_db", "root", "");
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Connection Failed! Check XAMPP.");
        }
        return con;
    }
}