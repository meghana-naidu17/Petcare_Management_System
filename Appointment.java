public class Appointment {

    private int appointmentId;
    private int petId;
    private String appointmentDate;

    public Appointment(int appointmentId,
                       int petId,
                       String appointmentDate) {

        this.appointmentId = appointmentId;
        this.petId = petId;
        this.appointmentDate = appointmentDate;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public int getPetId() {
        return petId;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void display() {

        System.out.println("Appointment ID : " + appointmentId);
        System.out.println("Pet ID         : " + petId);
        System.out.println("Date           : " + appointmentDate);
    }
}