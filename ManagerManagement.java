import java.util.ArrayList;
import java.sql.*;

public class ManagerManagement {

    private ArrayList<Manager> managers =
            new ArrayList<>();

    public ManagerManagement() {

        loadManagers();
    }

    public void registerManager(
            Manager manager) {

        try {

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(
                            "INSERT INTO managers VALUES (?, ?, ?)");

            ps.setInt(
                    1,
                    manager.getManagerId());

            ps.setString(
                    2,
                    manager.getUsername());

            ps.setString(
                    3,
                    manager.getPassword());

            ps.executeUpdate();

            System.out.println(
                    "Manager Registered Successfully!");

            con.close();

        } catch(Exception e) {

            e.printStackTrace();
        }
    }

    public Manager loginManager(
            String username,
            String password) {

        try {

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(
                            "SELECT * FROM managers WHERE username=? AND password=?");

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs =
                    ps.executeQuery();

            if(rs.next()) {

                return new Manager(
                        rs.getInt("manager_id"),
                        rs.getString("username"),
                        rs.getString("password"));
            }

            con.close();

        } catch(Exception e) {

            e.printStackTrace();
        }

        return null;
    }

    private void loadManagers() {

        managers.clear();

        try {

            Connection con =
                    DBConnection.getConnection();

            Statement st =
                    con.createStatement();

            ResultSet rs =
                    st.executeQuery(
                            "SELECT * FROM managers");

            while(rs.next()) {

                managers.add(
                        new Manager(
                                rs.getInt("manager_id"),
                                rs.getString("username"),
                                rs.getString("password")));
            }

            con.close();

        } catch(Exception e) {

            e.printStackTrace();
        }
    }
}