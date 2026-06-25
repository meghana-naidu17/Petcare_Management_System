import java.util.ArrayList;
import java.sql.*;

public class UserManagement {

    private ArrayList<User> users =
            new ArrayList<>();

    public UserManagement() {

        loadUsers();
    }

    public void registerUser(User user) {

        try {

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(
                            "INSERT INTO users VALUES (?, ?, ?)");

            ps.setInt(
                    1,
                    user.getUserId());

            ps.setString(
                    2,
                    user.getName());

            ps.setString(
                    3,
                    user.getPassword());

            ps.executeUpdate();

            System.out.println(
                    "User Registered Successfully!");

            con.close();

        } catch(Exception e) {

            e.printStackTrace();
        }
    }

    public User loginUser(
            int userId,
            String password) {

        try {

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(
                            "SELECT * FROM users WHERE user_id=? AND password=?");

            ps.setInt(1, userId);
            ps.setString(2, password);

            ResultSet rs =
                    ps.executeQuery();

            if(rs.next()) {

                return new User(
                        rs.getInt("user_id"),
                        rs.getString("name"),
                        rs.getString("password"));
            }

            con.close();

        } catch(Exception e) {

            e.printStackTrace();
        }

        return null;
    }

    public void viewUsers() {

        try {

            Connection con =
                    DBConnection.getConnection();

            Statement st =
                    con.createStatement();

            ResultSet rs =
                    st.executeQuery(
                            "SELECT * FROM users");

            while(rs.next()) {

                User user =
                        new User(
                                rs.getInt("user_id"),
                                rs.getString("name"),
                                rs.getString("password"));

                user.display();

                System.out.println(
                        "--------------------");
            }

            con.close();

        } catch(Exception e) {

            e.printStackTrace();
        }
    }

    private void loadUsers() {

        users.clear();

        try {

            Connection con =
                    DBConnection.getConnection();

            Statement st =
                    con.createStatement();

            ResultSet rs =
                    st.executeQuery(
                            "SELECT * FROM users");

            while(rs.next()) {

                users.add(
                        new User(
                                rs.getInt("user_id"),
                                rs.getString("name"),
                                rs.getString("password")));
            }

            con.close();

        } catch(Exception e) {

            e.printStackTrace();
        }
    }
}