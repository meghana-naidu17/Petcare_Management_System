import java.util.ArrayList;
import java.sql.*;

public class AppointmentManagement {

    private ArrayList<Appointment> appointments =
            new ArrayList<>();

    public AppointmentManagement() {

        loadAppointments();
    }

    // Book Appointment
    public void bookAppointment(
            Appointment appointment) {

        try {

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(
                            "INSERT INTO appointments VALUES (?, ?, ?)");

            ps.setInt(
                    1,
                    appointment.getAppointmentId());

            ps.setInt(
                    2,
                    appointment.getPetId());

            ps.setString(
                    3,
                    appointment.getAppointmentDate());

            ps.executeUpdate();

            System.out.println(
                    "Appointment Booked Successfully!");

            con.close();

            loadAppointments();

        } catch(Exception e) {

            e.printStackTrace();
        }
    }

    // Load Appointments
    private void loadAppointments() {

        appointments.clear();

        try {

            Connection con =
                    DBConnection.getConnection();

            Statement st =
                    con.createStatement();

            ResultSet rs =
                    st.executeQuery(
                            "SELECT * FROM appointments");

            while(rs.next()) {

                appointments.add(
                        new Appointment(
                                rs.getInt("appointment_id"),
                                rs.getInt("pet_id"),
                                rs.getString("appointment_date")));
            }

            con.close();

        } catch(Exception e) {

            e.printStackTrace();
        }
    }

    // View All Appointments
    public void viewAppointments() {

        loadAppointments();

        if(appointments.isEmpty()) {

            System.out.println(
                    "No Appointments Found.");

            return;
        }

        for(Appointment appointment :
                appointments) {

            appointment.display();

            System.out.println(
                    "--------------------");
        }
    }

    // View Appointments By Owner
    public void viewAppointmentsByOwner(
            ArrayList<Pet> ownerPets) {

        loadAppointments();

        boolean found = false;

        for(Appointment appointment :
                appointments) {

            for(Pet pet :
                    ownerPets) {

                if(appointment.getPetId()
                        == pet.getPetId()) {

                    appointment.display();

                    System.out.println(
                            "--------------------");

                    found = true;
                }
            }
        }

        if(!found) {

            System.out.println(
                    "No Appointments Found.");
        }
    }

    // Appointment Statistics
    public void appointmentStatistics() {

        loadAppointments();

        if(appointments.isEmpty()) {

            System.out.println(
                    "No Appointments Found.");

            return;
        }

        int[] data =
                new int[appointments.size()];

        for(int i = 0;
            i < appointments.size();
            i++) {

            data[i] = 1;
        }

        SegmentTree segmentTree =
                new SegmentTree(data);

        int total =
                segmentTree.getRangeSum(
                        0,
                        appointments.size() - 1);

        System.out.println(
                "\nTotal Appointments = "
                        + total);
    }
}