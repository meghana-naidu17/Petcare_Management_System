public class Veterinarian {

    private int vetId;
    private String vetName;
    private String specialization;

    public Veterinarian(int vetId,
                        String vetName,
                        String specialization) {

        this.vetId = vetId;
        this.vetName = vetName;
        this.specialization = specialization;
    }

    public int getVetId() {
        return vetId;
    }

    public String getVetName() {
        return vetName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void display() {

        System.out.println("Vet ID         : " + vetId);
        System.out.println("Vet Name       : " + vetName);
        System.out.println("Specialization : " + specialization);
    }
}