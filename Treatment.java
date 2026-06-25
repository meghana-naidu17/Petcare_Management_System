public class Treatment {

    private int treatmentId;
    private int petId;
    private String diagnosis;

    public Treatment(int treatmentId,
                     int petId,
                     String diagnosis) {

        this.treatmentId = treatmentId;
        this.petId = petId;
        this.diagnosis = diagnosis;
    }

    public int getTreatmentId() {
        return treatmentId;
    }

    public int getPetId() {
        return petId;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void display() {

        System.out.println("Treatment ID : " + treatmentId);
        System.out.println("Pet ID       : " + petId);
        System.out.println("Diagnosis    : " + diagnosis);
    }
}