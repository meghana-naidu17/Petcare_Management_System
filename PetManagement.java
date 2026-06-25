
import java.util.ArrayList;
import java.sql.*;

public class PetManagement {

    private ArrayList<Pet> pets = new ArrayList<>();

    public PetManagement() {
        loadPets();
    }

    // Add Pet
    public void addPet(Pet pet) {

        try {

            Connection con =
                    DBConnection.getConnection();

            String sql =
                    "INSERT INTO pets VALUES (?, ?, ?, ?, ?)";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, pet.getPetId());
            ps.setString(2, pet.getPetName());
            ps.setString(3, pet.getSpecies());
            ps.setInt(4, pet.getAge());
            ps.setInt(5, pet.getOwnerId());

            ps.executeUpdate();

            System.out.println(
                    "Pet Added Successfully!");

            con.close();

            loadPets();

        } catch(Exception e) {

            e.printStackTrace();
        }
    }

    // Load Pets
    private void loadPets() {

        pets.clear();

        try {

            Connection con =
                    DBConnection.getConnection();

            Statement st =
                    con.createStatement();

            ResultSet rs =
                    st.executeQuery(
                            "SELECT * FROM pets");

            while(rs.next()) {

                pets.add(
                        new Pet(
                                rs.getInt("pet_id"),
                                rs.getString("pet_name"),
                                rs.getString("species"),
                                rs.getInt("age"),
                                rs.getInt("owner_id")
                        )
                );
            }

            con.close();

        } catch(Exception e) {

            e.printStackTrace();
        }
    }

    // View All Pets
    public void viewPets() {

        loadPets();

        if(pets.isEmpty()) {

            System.out.println(
                    "No Pets Found.");
            return;
        }

        for(Pet pet : pets) {

            pet.display();

            System.out.println(
                    "--------------------");
        }
    }

    // View Pets By Owner
    public void viewPetsByOwner(
            int ownerId) {

        loadPets();

        boolean found = false;

        for(Pet pet : pets) {

            if(pet.getOwnerId()
                    == ownerId) {

                pet.display();

                System.out.println(
                        "--------------------");

                found = true;
            }
        }

        if(!found) {

            System.out.println(
                    "No Pets Found.");
        }
    }

    // Search Pet By ID
    public Pet searchPetById(
            int petId) {

        loadPets();

        for(Pet pet : pets) {

            if(pet.getPetId()
                    == petId) {

                return pet;
            }
        }

        return null;
    }

    // Get Pets By Owner
    public ArrayList<Pet> getPetsByOwner(
            int ownerId) {

        loadPets();

        ArrayList<Pet> ownerPets =
                new ArrayList<>();

        for(Pet pet : pets) {

            if(pet.getOwnerId()
                    == ownerId) {

                ownerPets.add(pet);
            }
        }

        return ownerPets;
    }

    // Sort Pets By Age
    public void sortPetsByAge() {

        loadPets();

        pets.sort(
                (p1, p2) ->
                        Integer.compare(
                                p1.getAge(),
                                p2.getAge()));

        System.out.println(
                "Pets Sorted By Age Successfully!");
    }
}
