package kata5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
        
        // Instrucción SQL para crear nueva tabla
        String sql = "CREATE TABLE IF NOT EXISTS EMAIL (\n"
                    + " Id integer PRIMARY KEY AUTOINCREMENT,\n"
                    + " Mail text NOT NULL);";
        try (Statement stmt = conn.createStatement()) {
        // Se crea la nueva tabla
        stmt.execute(sql);
        System.out.println("Tabla creada");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
    }
}


