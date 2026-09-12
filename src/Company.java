public class Company extends User {
    private String location;

    public Company(int id, String name, String email, String location) {
        super(id, name, email);
        this.location = location;
    }

    public String getLocation() { return location; }

    @Override
    public void displayInfo() {
        System.out.println("ID: " + getId() +
                " | Company: " + getName() +
                " | Email: " + getEmail() +
                " | Location: " + location);
    }
}
