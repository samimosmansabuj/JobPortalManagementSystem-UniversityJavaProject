public class JobSeeker extends User {
    private String qualification;

    public JobSeeker(int id, String name, String email, String qualification) {
        super(id, name, email);
        this.qualification = qualification;
    }

    public String getQualification() { return qualification; }

    @Override
    public void displayInfo() {
        System.out.println("ID: " + getId() +
                " | Name: " + getName() +
                " | Email: " + getEmail() +
                " | Qualification: " + qualification);
    }
}
