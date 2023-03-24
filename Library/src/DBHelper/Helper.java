package DBHelper;

import Model.Books;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Helper {

    private String username = "root";
    private String password = "12345";
    private String dbUrl = "jdbc:mysql://localhost:3306/library";
    
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl, username, password);
    }

    public void showError(SQLException e) {

        JOptionPane.showMessageDialog(null, "sql exception");
        //System.out.println("error:" + e.getMessage());
        //System.out.println("error code:" + e.getErrorCode());
    }

    public void showError(NumberFormatException e) {

        JOptionPane.showMessageDialog(null, "format exception");
        //System.out.println("error code:" );
    }
    public void showError(Exception e) {

        JOptionPane.showMessageDialog(null, "format exception");
        //System.out.println("error code:" );
    }

    public void addToDB(String name, String author, int page) throws SQLException {
        String sql = "insert into books (name,author,page) values(?,?,?)";
        Connection conn = null;
        PreparedStatement pst = null;

        try {
            conn = getConnection();
            pst = conn.prepareStatement(sql);
            System.out.println("bağlantı başarılı");

            pst.setString(1, name);
            pst.setString(2, author);
            pst.setInt(3, page);
            pst.executeUpdate();
        } catch (SQLException ex) {
            showError(ex);
        } finally {
            conn.close();
            pst.close();;
        }

    }

    Books b = null;
    ArrayList<Books> books = null;

    public ArrayList<Books> getFromDb() {
        books = new ArrayList<>();

        Helper helper = new Helper();
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "select * from books";

        try {
            conn = helper.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                b = new Books();
                b.setId(rs.getInt("id"));
                b.setName(rs.getString("name"));
                b.setAuthor(rs.getString("author"));
                b.setPage(rs.getInt("page"));
                books.add(b);

            }

        } catch (SQLException ex) {
            helper.showError(ex);
        }

        return books;
    }

    

    
}
