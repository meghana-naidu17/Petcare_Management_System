import java.sql.*;

public class TestDB {

    public static void main(String[] args) {

        try {

            Class.forName("org.postgresql.Driver");

            Connection con =
                DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/petcare",
                    "postgres",
                    "Maggie@1707"
                );

            System.out.println("Connected!");

            con.close();

        } catch(Exception e) {

            e.printStackTrace();
        }
    }
}