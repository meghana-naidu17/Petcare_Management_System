import java.util.ArrayList;
import java.sql.*;

public class VeterinarianManagement {

    private ArrayList<Veterinarian> veterinarians =
            new ArrayList<>();

    private ClinicGraph clinicGraph =
            new ClinicGraph();

    private DijkstraGraph dijkstraGraph =
            new DijkstraGraph();

    public VeterinarianManagement() {

        loadVeterinarians();

        dijkstraGraph.addClinic(
                "Clinic A");

        dijkstraGraph.addClinic(
                "Clinic B");

        dijkstraGraph.addClinic(
                "Clinic C");

        dijkstraGraph.addClinic(
                "Clinic D");

        dijkstraGraph.addConnection(
                "Clinic A",
                "Clinic B",
                5);

        dijkstraGraph.addConnection(
                "Clinic B",
                "Clinic C",
                3);

        dijkstraGraph.addConnection(
                "Clinic C",
                "Clinic D",
                4);

        dijkstraGraph.addConnection(
                "Clinic A",
                "Clinic D",
                15);

        clinicGraph.addClinic(
                "Clinic A");

        clinicGraph.addClinic(
                "Clinic B");

        clinicGraph.addClinic(
                "Clinic C");

        clinicGraph.addClinic(
                "Clinic D");

        clinicGraph.addConnection(
                "Clinic A",
                "Clinic B");

        clinicGraph.addConnection(
                "Clinic B",
                "Clinic C");

        clinicGraph.addConnection(
                "Clinic C",
                "Clinic D");
    }

    // Add Veterinarian
    public void addVeterinarian(
            Veterinarian veterinarian) {

        try {

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(
                            "INSERT INTO veterinarians VALUES (?, ?, ?)");

            ps.setInt(
                    1,
                    veterinarian.getVetId());

            ps.setString(
                    2,
                    veterinarian.getVetName());

            ps.setString(
                    3,
                    veterinarian.getSpecialization());

            ps.executeUpdate();

            System.out.println(
                    "Veterinarian Added Successfully!");

            con.close();

            loadVeterinarians();

        } catch(Exception e) {

            e.printStackTrace();
        }
    }

    // Load Veterinarians
    private void loadVeterinarians() {

        veterinarians.clear();

        try {

            Connection con =
                    DBConnection.getConnection();

            Statement st =
                    con.createStatement();

            ResultSet rs =
                    st.executeQuery(
                            "SELECT * FROM veterinarians");

            while(rs.next()) {

                veterinarians.add(
                        new Veterinarian(
                                rs.getInt("vet_id"),
                                rs.getString("vet_name"),
                                rs.getString("specialization")));
            }

            con.close();

        } catch(Exception e) {

            e.printStackTrace();
        }
    }

    // View Veterinarians
    public void viewVeterinarians() {

        loadVeterinarians();

        if(veterinarians.isEmpty()) {

            System.out.println(
                    "No Veterinarians Found.");

            return;
        }

        for(Veterinarian veterinarian :
                veterinarians) {

            veterinarian.display();

            System.out.println(
                    "--------------------");
        }
    }

    public void bfsClinics() {

        clinicGraph.bfs(
                "Clinic A");
    }

    public void dfsClinics() {

        clinicGraph.dfs(
                "Clinic A");
    }

    public void shortestPath() {

        dijkstraGraph.shortestPath(
                "Clinic A");
    }
}