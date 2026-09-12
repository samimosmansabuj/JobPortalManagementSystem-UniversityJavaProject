public class Application {
    private int applicationId;
    private int seekerId;
    private int jobId;
    private String status;

    public Application(int applicationId, int seekerId, int jobId) {
        this.applicationId = applicationId;
        this.seekerId = seekerId;
        this.jobId = jobId;
        this.status = "Pending";
    }

    public int getApplicationId() { return applicationId; }
    public int getSeekerId() { return seekerId; }
    public int getJobId() { return jobId; }
    public String getStatus() { return status; }

    public void setStatus(String status) {
        this.status = status;
    }

    public void displayApplication() {
        System.out.println("Application ID: " + applicationId +
                " | Seeker ID: " + seekerId +
                " | Job ID: " + jobId +
                " | Status: " + status);
    }
}
