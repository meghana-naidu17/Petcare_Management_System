public class Manager {

    private int managerId;
    private String username;
    private String password;

    public Manager(int managerId,
                   String username,
                   String password) {

        this.managerId = managerId;
        this.username = username;
        this.password = password;
    }

    public int getManagerId() {
        return managerId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void display() {

        System.out.println("Manager ID : " + managerId);
        System.out.println("Username   : " + username);
    }
}