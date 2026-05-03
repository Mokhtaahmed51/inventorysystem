import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AppTest {

    // =============================================
    // تيست الاتصال بالداتابيز
    // =============================================

    @Test
    public void testDatabaseConnection() {
        Connection con = SmartInventoryManagementSystem.MyConnection.getConnection();
        assertNotNull(con, "Database connection failed!");
    }

    // =============================================
    // تيستات جدول Products
    // =============================================

    @Test
    public void testGetAllProducts() {
        try {
            Connection con = SmartInventoryManagementSystem.MyConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM products");
            assertNotNull(rs, "Products query returned null");
        } catch (SQLException e) {
            fail("testGetAllProducts Error: " + e.getMessage());
        }
    }

    @Test
    public void testAddProduct() {
        try {
            Connection con = SmartInventoryManagementSystem.MyConnection.getConnection();
            String sql = "INSERT INTO products (product_name, category, price, quantity) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "Test Product");
            ps.setString(2, "Test Category");
            ps.setDouble(3, 99.99);
            ps.setInt(4, 10);
            int rows = ps.executeUpdate();
            assertEquals(1, rows, "Product should be added successfully");
        } catch (SQLException e) {
            fail("testAddProduct Error: " + e.getMessage());
        }
    }

    @Test
    public void testUpdateProduct() {
        try {
            Connection con = SmartInventoryManagementSystem.MyConnection.getConnection();
            String sql = "UPDATE products SET quantity=? WHERE product_name=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, 50);
            ps.setString(2, "Test Product");
            int rows = ps.executeUpdate();
            assertTrue(rows >= 0, "Product should be updated successfully");
        } catch (SQLException e) {
            fail("testUpdateProduct Error: " + e.getMessage());
        }
    }

    @Test
    public void testDeleteProduct() {
        try {
            Connection con = SmartInventoryManagementSystem.MyConnection.getConnection();
            String sql = "DELETE FROM products WHERE product_name=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "Test Product");
            int rows = ps.executeUpdate();
            assertTrue(rows >= 0, "Product should be deleted successfully");
        } catch (SQLException e) {
            fail("testDeleteProduct Error: " + e.getMessage());
        }
    }

    // =============================================
    // Suppliers
    // =============================================

    @Test
    public void testGetAllSuppliers() {
        try {
            Connection con = SmartInventoryManagementSystem.MyConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM suppliers");
            assertNotNull(rs, "Suppliers query returned null");
        } catch (SQLException e) {
            fail("testGetAllSuppliers Error: " + e.getMessage());
        }
    }

    @Test
    public void testAddSupplier() {
        try {
            Connection con = SmartInventoryManagementSystem.MyConnection.getConnection();
            String sql = "INSERT INTO suppliers (name, phone, address) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "Test Supplier");
            ps.setString(2, "01000000000");
            ps.setString(3, "Test Address");
            int rows = ps.executeUpdate();
            assertEquals(1, rows, "Supplier should be added successfully");
        } catch (SQLException e) {
            fail("testAddSupplier Error: " + e.getMessage());
        }
    }

    @Test
    public void testUpdateSupplier() {
        try {
            Connection con = SmartInventoryManagementSystem.MyConnection.getConnection();
            String sql = "UPDATE suppliers SET phone=? WHERE name=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "01111111111");
            ps.setString(2, "Test Supplier");
            int rows = ps.executeUpdate();
            assertTrue(rows >= 0, "Supplier should be updated successfully");
        } catch (SQLException e) {
            fail("testUpdateSupplier Error: " + e.getMessage());
        }
    }

    @Test
    public void testDeleteSupplier() {
        try {
            Connection con = SmartInventoryManagementSystem.MyConnection.getConnection();
            String sql = "DELETE FROM suppliers WHERE name=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "Test Supplier");
            int rows = ps.executeUpdate();
            assertTrue(rows >= 0, "Supplier should be deleted successfully");
        } catch (SQLException e) {
            fail("testDeleteSupplier Error: " + e.getMessage());
        }
    }

    // =============================================
    // تيستات Reports (الإحصائيات)
    // =============================================

    @Test
    public void testTotalProductsCount() {
        try {
            Connection con = SmartInventoryManagementSystem.MyConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) AS total FROM products");
            assertTrue(rs.next(), "Should return total products count");
            assertTrue(rs.getInt("total") >= 0, "Total products should be >= 0");
        } catch (SQLException e) {
            fail("testTotalProductsCount Error: " + e.getMessage());
        }
    }

    @Test
    public void testOutOfStockCount() {
        try {
            Connection con = SmartInventoryManagementSystem.MyConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) AS out_stock FROM products WHERE quantity = 0");
            assertTrue(rs.next(), "Should return out of stock count");
            assertTrue(rs.getInt("out_stock") >= 0, "Out of stock count should be >= 0");
        } catch (SQLException e) {
            fail("testOutOfStockCount Error: " + e.getMessage());
        }
    }

    @Test
    public void testTotalSuppliersCount() {
        try {
            Connection con = SmartInventoryManagementSystem.MyConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) AS total_supp FROM suppliers");
            assertTrue(rs.next(), "Should return total suppliers count");
            assertTrue(rs.getInt("total_supp") >= 0, "Total suppliers should be >= 0");
        } catch (SQLException e) {
            fail("testTotalSuppliersCount Error: " + e.getMessage());
        }
    }

    @Test
    public void testTotalStockValue() {
        try {
            Connection con = SmartInventoryManagementSystem.MyConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT SUM(price * quantity) AS total_val FROM products");
            assertTrue(rs.next(), "Should return total stock value");
        } catch (SQLException e) {
            fail("testTotalStockValue Error: " + e.getMessage());
        }
    }

    // =============================================
    // تيست Login
    // =============================================

    @Test
    public void testLoginWithValidUser() {
        try {
            Connection con = SmartInventoryManagementSystem.MyConnection.getConnection();
            String sql = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "admin");
            ps.setString(2, "admin");
            ResultSet rs = ps.executeQuery();
            assertNotNull(rs, "Login query should execute without error");
        } catch (SQLException e) {
            fail("testLoginWithValidUser Error: " + e.getMessage());
        }
    }
}