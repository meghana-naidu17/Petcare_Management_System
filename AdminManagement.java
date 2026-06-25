import java.util.ArrayList;
import java.sql.*;

public class AdminManagement {

    private ArrayList<Admin> admins =
            new ArrayList<>();

    public AdminManagement() {

        loadAdmins();
    }

    public void registerAdmin(Admin admin) {

        try {

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(
                            "INSERT INTO admins VALUES (?, ?, ?)");

            ps.setInt(
                    1,
                    admin.getAdminId());

            ps.setString(
                    2,
                    admin.getUsername());

            ps.setString(
                    3,
                    admin.getPassword());

            ps.executeUpdate();

            System.out.println(
                    "Admin Registered Successfully!");

            con.close();

        } catch(Exception e) {

            e.printStackTrace();
        }
    }

    public Admin loginAdmin(
            String username,
            String password) {

        try {

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(
                            "SELECT * FROM admins WHERE username=? AND password=?");

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs =
                    ps.executeQuery();

            if(rs.next()) {

                return new Admin(
                        rs.getInt("admin_id"),
                        rs.getString("username"),
                        rs.getString("password"));
            }

            con.close();

        } catch(Exception e) {

            e.printStackTrace();
        }

        return null;
    }

    private void loadAdmins() {

        admins.clear();

        try {

            Connection con =
                    DBConnection.getConnection();

            Statement st =
                    con.createStatement();

            ResultSet rs =
                    st.executeQuery(
                            "SELECT * FROM admins");

            while(rs.next()) {

                admins.add(
                        new Admin(
                                rs.getInt("admin_id"),
                                rs.getString("username"),
                                rs.getString("password")));
            }

            con.close();

        } catch(Exception e) {

            e.printStackTrace();
        }
    }
}