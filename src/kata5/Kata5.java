package kata5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import static kata5.MailListReader.read;

public class Kata5 {

    public static void main(String[] args) {
        
        // SQLite connection 
        String url = "jdbc:sqlite:KATA5.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        //
        List<String> emails = read("email.txt");
        
        String sql = "INSERT INTO EMAIL(Mail) VALUES(?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            for (String email : emails) {
                pstmt.setString(1, email);
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}


