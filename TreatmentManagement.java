import java.util.ArrayList;
import java.sql.*;

public class TreatmentManagement {

    private ArrayList<Treatment> treatments =
            new ArrayList<>();

    public TreatmentManagement() {

        loadTreatments();
    }

    // Add Treatment
    public void addTreatment(
            Treatment treatment) {

        try {

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(
                            "INSERT INTO treatments VALUES (?, ?, ?)");

            ps.setInt(
                    1,
                    treatment.getTreatmentId());

            ps.setInt(
                    2,
                    treatment.getPetId());

            ps.setString(
                    3,
                    treatment.getDiagnosis());

            ps.executeUpdate();

            System.out.println(
                    "Treatment Added Successfully!");

            con.close();

            loadTreatments();

        } catch(Exception e) {

            e.printStackTrace();
        }
    }

    // Load Treatments
    private void loadTreatments() {

        treatments.clear();

        try {

            Connection con =
                    DBConnection.getConnection();

            Statement st =
                    con.createStatement();

            ResultSet rs =
                    st.executeQuery(
                            "SELECT * FROM treatments");

            while(rs.next()) {

                treatments.add(
                        new Treatment(
                                rs.getInt("treatment_id"),
                                rs.getInt("pet_id"),
                                rs.getString("diagnosis")));
            }

            con.close();

        } catch(Exception e) {

            e.printStackTrace();
        }
    }

    // View Treatments
    public void viewTreatments() {

        loadTreatments();

        if(treatments.isEmpty()) {

            System.out.println(
                    "No Treatments Found.");

            return;
        }

        for(Treatment treatment :
                treatments) {

            treatment.display();

            System.out.println(
                    "--------------------");
        }
    }
}