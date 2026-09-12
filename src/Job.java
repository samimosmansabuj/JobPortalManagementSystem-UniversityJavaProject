public class Job {
    private int jobId;
    private String title;
    private String companyName;
    private String location;
    private double salary;

    public Job(int jobId, String title, String companyName, String location, double salary) {
        this.jobId = jobId;
        this.title = title;
        this.companyName = companyName;
        this.location = location;
        this.salary = salary;
    }

    public int getJobId() { return jobId; }
    public String getTitle() { return title; }

    public void displayJob() {
        System.out.println("Job ID: " + jobId +
                " | Title: " + title +
                " | Company: " + companyName +
                " | Location: " + location +
                " | Salary: " + salary);
    }
}
