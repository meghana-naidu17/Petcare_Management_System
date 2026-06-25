import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
UserManagement userManager = new UserManagement();

PetManagement petManager = new PetManagement();

AppointmentManagement appointmentManager = new AppointmentManagement();

TreatmentManagement treatmentManager = new TreatmentManagement();

VeterinarianManagement veterinarianManager = new VeterinarianManagement();

AdminManagement adminManager = new AdminManagement();

ManagerManagement managerManager = new ManagerManagement();

        int choice;

        do {

            System.out.println("\n=================================");
            System.out.println(" PETCARE MANAGEMENT SYSTEM ");
            System.out.println("=================================");
            System.out.println("1. User Portal");
            System.out.println("2. Admin Login");
            System.out.println("3. Manager Login");
            System.out.println("4. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch(choice) {

                case 1:

                    int userChoice;

                    do {

                        System.out.println("\n===== USER PORTAL =====");
                        System.out.println("1. Register");
                        System.out.println("2. Login");
                        System.out.println("3. Back");

                        System.out.print("Enter Choice: ");
                        userChoice = sc.nextInt();

                        switch(userChoice) {

                            case 1:

                                System.out.print("Enter User ID: ");
                                int userId = sc.nextInt();
                                sc.nextLine();

                                System.out.print("Enter Name: ");
                                String name = sc.nextLine();

                                System.out.print("Enter Password: ");
                                String password = sc.nextLine();

                                userManager.registerUser(
                                        new User(userId, name, password));

                                break;

                            case 2:

                                System.out.print("Enter User ID: ");
                                int loginId = sc.nextInt();
                                sc.nextLine();

                                System.out.print("Enter Password: ");
                                String loginPassword = sc.nextLine();

                                User loggedUser =
                                        userManager.loginUser(
                                                loginId,
                                                loginPassword);

                                if(loggedUser != null) {

                                    System.out.println("\nLogin Successful!");
                                    System.out.println(
                                            "Welcome "
                                                    + loggedUser.getName());

                                    int userMenu;

                                    do {

                                        System.out.println(
                                                "\n===== USER MENU =====");
                                        System.out.println("1. Add Pet");
                                        System.out.println("2. View Pets");
                                        System.out.println("3. Book Appointment");
                                        System.out.println("4. View Appointments");
                                        System.out.println("5. Logout");

                                        System.out.print(
                                                "Enter Choice: ");
                                        userMenu = sc.nextInt();

                                        switch(userMenu) {

                                            case 1:

                                                System.out.print(
                                                        "Enter Pet ID: ");
                                                int petId = sc.nextInt();
                                                sc.nextLine();

                                                System.out.print(
                                                        "Enter Pet Name: ");
                                                String petName =
                                                        sc.nextLine();

                                                System.out.print(
                                                        "Enter Species: ");
                                                String species =
                                                        sc.nextLine();

                                                System.out.print(
                                                        "Enter Age: ");
                                                int age = sc.nextInt();

                                                petManager.addPet(
                                                        new Pet(
                                                                petId,
                                                                petName,
                                                                species,
                                                                age,
                                                                loggedUser.getUserId()));

                                                break;

                                            case 2:

                                               petManager.viewPetsByOwner(
                                                    loggedUser.getUserId());
                                                break;

                                            case 3:

                                                System.out.print(
                                                        "Enter Appointment ID: ");
                                                int appId = sc.nextInt();

                                                System.out.print(
                                                        "Enter Pet ID: ");
                                                int appPetId =
                                                        sc.nextInt();
                                                sc.nextLine();

                                                System.out.print(
                                                        "Enter Date: ");
                                                String date =
                                                        sc.nextLine();

                                                appointmentManager
                                                        .bookAppointment(
                                                                new Appointment(
                                                                        appId,
                                                                        appPetId,
                                                                        date));

                                                break;

                                                case 4:

                                                appointmentManager
                                                        .viewAppointmentsByOwner(
                                                                petManager.getPetsByOwner(
                                                                        loggedUser.getUserId()));

                                                break;

                                            case 5:

                                                System.out.println(
                                                        "Logged Out Successfully!");
                                                break;

                                            default:

                                                System.out.println(
                                                        "Invalid Choice!");
                                        }

                                    } while(userMenu != 5);

                                } else {

                                    System.out.println(
                                            "Invalid Credentials!");
                                }

                                break;

                            case 3:

                                break;

                            default:

                                System.out.println(
                                        "Invalid Choice!");
                        }

                    } while(userChoice != 3);

                    break;

                case 2:

    int adminChoice;

    do {

        System.out.println("\n===== ADMIN PORTAL =====");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Back");

        System.out.print("Enter Choice: ");
        adminChoice = sc.nextInt();

        switch(adminChoice) {

            case 1:

                System.out.print("Enter Admin ID: ");
                int adminId = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Username: ");
                String adminUsername = sc.nextLine();

                System.out.print("Enter Password: ");
                String adminPassword = sc.nextLine();

                adminManager.registerAdmin(
                        new Admin(
                                adminId,
                                adminUsername,
                                adminPassword));

                break;

            case 2:

                sc.nextLine();

                System.out.print(
                        "Enter Username: ");
                String loginAdminUser =
                        sc.nextLine();

                System.out.print(
                        "Enter Password: ");
                String loginAdminPass =
                        sc.nextLine();

                Admin loggedAdmin =
                        adminManager.loginAdmin(
                                loginAdminUser,
                                loginAdminPass);

                if(loggedAdmin != null) {

                    int adminMenu;

                    do {

                        System.out.println(
                                "\n===== ADMIN MENU =====");
                        System.out.println(
                                "1. View Users");
                        System.out.println(
                                "2. View Pets");
                        System.out.println(
                                "3. Search Pet By ID");
                        System.out.println(
                                "4. Sort Pets By Age"); 
                      System.out.println(
        "5. View Appointments");
System.out.println(
        "6. Appointment Statistics");
System.out.println(
        "7. View Treatments");
System.out.println(
        "8. Logout");

                        System.out.print(
                                "Enter Choice: ");
                        adminMenu = sc.nextInt();

                        switch(adminMenu) {


                case 1:

                        userManager.viewUsers();
                        break;

                case 2:

                        petManager.viewPets();
                        break;

                case 3:

                        System.out.print(
                                "Enter Pet ID: ");

                        int searchId =
                                sc.nextInt();

                        Pet foundPet =
                                petManager.searchPetById(
                                        searchId);

                        if(foundPet == null) {

                        System.out.println(
                                "Pet Not Found.");
                        }
                        else {

                        foundPet.display();
                        }

                        break;

                case 4:

                        petManager.sortPetsByAge();

                        petManager.viewPets();

                        break;

                case 5:

    appointmentManager
            .viewAppointments();

    break;

case 6:

    appointmentManager
            .appointmentStatistics();

    break;

case 7:

    treatmentManager
            .viewTreatments();

    break;

case 8:

    System.out.println(
            "Admin Logged Out");

    break;

                      

                default:

                        System.out.println(
                                "Invalid Choice!");
                }

                                } while(adminMenu != 8);

                                } else {

                                System.out.println(
                                        "Invalid Credentials!");
                                }

                                break;

                        case 3:
                                break;

                        default:
                                System.out.println(
                                        "Invalid Choice!");
                        }

                } while(adminChoice != 3);

                break;

                                case 3:

                int managerChoice;

                do {

                        System.out.println(
                                "\n===== MANAGER PORTAL =====");
                        System.out.println(
                                "1. Register");
                        System.out.println(
                                "2. Login");
                        System.out.println(
                                "3. Back");

                        System.out.print(
                                "Enter Choice: ");
                        managerChoice = sc.nextInt();

                        switch(managerChoice) {

                        case 1:

                                System.out.print(
                                        "Enter Manager ID: ");
                                int managerId =
                                        sc.nextInt();
                                sc.nextLine();

                                System.out.print(
                                        "Enter Username: ");
                                String managerUsername =
                                        sc.nextLine();

                                System.out.print(
                                        "Enter Password: ");
                                String managerPassword =
                                        sc.nextLine();

                                managerManager
                                        .registerManager(
                                                new Manager(
                                                        managerId,
                                                        managerUsername,
                                                        managerPassword));

                                break;

            case 2:

                sc.nextLine();

                System.out.print(
                        "Enter Username: ");
                String loginManagerUser =
                        sc.nextLine();

                System.out.print(
                        "Enter Password: ");
                String loginManagerPass =
                        sc.nextLine();

                Manager loggedManager =
                        managerManager.loginManager(
                                loginManagerUser,
                                loginManagerPass);

                if(loggedManager != null) {

                    int managerMenu;

                    do {

                   System.out.println(
        "1. Add Treatment");
System.out.println(
        "2. View Treatments");
System.out.println(
        "3. Add Veterinarian");
System.out.println(
        "4. View Veterinarians");
System.out.println(
        "5. BFS Clinic Network");
System.out.println(
        "6. DFS Clinic Network");
System.out.println(
        "7. Dijkstra Shortest Path");
System.out.println(
        "8. Activity Selection");
System.out.println(
        "9. Logout");
                        System.out.print(
                                "Enter Choice: ");
                        managerMenu =
                                sc.nextInt();

                        switch(managerMenu) {

                            case 1:

                                System.out.print(
                                        "Enter Treatment ID: ");
                                int treatmentId =
                                        sc.nextInt();

                                System.out.print(
                                        "Enter Pet ID: ");
                                int treatmentPetId =
                                        sc.nextInt();
                                sc.nextLine();

                                System.out.print(
                                        "Enter Diagnosis: ");
                                String diagnosis =
                                        sc.nextLine();

                                treatmentManager
                                        .addTreatment(
                                                new Treatment(
                                                        treatmentId,
                                                        treatmentPetId,
                                                        diagnosis));

                                break;

                            case 2:

                                treatmentManager
                                        .viewTreatments();
                                break;

                            case 3:

                                System.out.print(
                                        "Enter Vet ID: ");
                                int vetId =
                                        sc.nextInt();
                                sc.nextLine();

                                System.out.print(
                                        "Enter Vet Name: ");
                                String vetName =
                                        sc.nextLine();

                                System.out.print(
                                        "Enter Specialization: ");
                                String specialization =
                                        sc.nextLine();

                                veterinarianManager
                                        .addVeterinarian(
                                                new Veterinarian(
                                                        vetId,
                                                        vetName,
                                                        specialization));

                                break;

                            case 4:

                                veterinarianManager
                                        .viewVeterinarians();
                                break;
case 5:

    veterinarianManager
            .bfsClinics();

    break;

case 6:

    veterinarianManager
            .dfsClinics();

    break;

case 7:

    veterinarianManager
            .shortestPath();

    break;
case 8:

    ActivitySelection
            .selectAppointments();

    break;
    case 9:

    System.out.println(
            "Manager Logged Out");

    break;
                            default:

                                System.out.println(
                                        "Invalid Choice!");
                        }

                    } while(managerMenu != 9);

                } else {

                    System.out.println(
                            "Invalid Credentials!");
                }

                break;

            case 3:
                break;

            default:
                System.out.println(
                        "Invalid Choice!");
        }

    } while(managerChoice != 3);

    break;
                case 4:

                    System.out.println(
                            "Thank You For Using PetCare!");
                    break;

                default:

                    System.out.println(
                            "Invalid Choice!");
            }

        } while(choice != 4);

        sc.close();
    }
}