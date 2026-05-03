import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.Connection;
import java.sql.SQLException;

public class AppTest {

    // اختبار 1: الاتصال بالداتابيز
    @Test
    public void testDatabaseConnection() {
        Connection con = SmartInventoryManagementSystem.MyConnection.getConnection();
        assertNotNull(con, "Connection failed!");
    }

    // اختبار 2: جدول المنتجات موجود
    @Test
    public void testProductsTableExists() {
        try {
            Connection con = SmartInventoryManagementSystem.MyConnection.getConnection();
            java.sql.Statement st = con.createStatement();
            java.sql.ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM products");
            assertTrue(rs.next(), "Products table exists");
        } catch (SQLException e) {
            fail("Error: " + e.getMessage());
        }
    }

    // اختبار 3: جدول الموردين موجود
    @Test
    public void testSuppliersTableExists() {
        try {
            Connection con = SmartInventoryManagementSystem.MyConnection.getConnection();
            java.sql.Statement st = con.createStatement();
            java.sql.ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM suppliers");
            assertTrue(rs.next(), "Suppliers table exists");
        } catch (SQLException e) {
            fail("Error: " + e.getMessage());
        }
    }
}