public class Pet {

    private int petId;
    private String petName;
    private String species;
    private int age;
    private int ownerId;

    public Pet(int petId,
               String petName,
               String species,
               int age,
               int ownerId) {

        this.petId = petId;
        this.petName = petName;
        this.species = species;
        this.age = age;
        this.ownerId = ownerId;
    }

    public int getPetId() {
        return petId;
    }

    public String getPetName() {
        return petName;
    }

    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void display() {

        System.out.println("Pet ID   : " + petId);
        System.out.println("Pet Name : " + petName);
        System.out.println("Species  : " + species);
        System.out.println("Age      : " + age);
    }
}