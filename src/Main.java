import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);

    static ArrayList<JobSeeker> seekers = new ArrayList<JobSeeker>();
    static ArrayList<Company> companies = new ArrayList<Company>();
    static ArrayList<Job> jobs = new ArrayList<Job>();
    static ArrayList<Application> applications = new ArrayList<Application>();

    static int nextSeekerId = 1;
    static int nextCompanyId = 1;
    static int nextJobId = 1;
    static int nextApplicationId = 1;

    public static void main(String[] args) {
        addSampleData();

        int choice;
        do {
            showMenu();
            choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    addJobSeeker();
                    break;
                case 2:
                    addCompany();
                    break;
                case 3:
                    postJob();
                    break;
                case 4:
                    viewJobs();
                    break;
                case 5:
                    applyForJob();
                    break;
                case 6:
                    viewApplications();
                    break;
                case 7:
                    updateApplicationStatus();
                    break;
                case 8:
                    viewUsers();
                    break;
                case 0:
                    System.out.println("Thank you for using Job Portal Management System.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        input.close();
    }

    static void showMenu() {
        System.out.println("\n========== JOB PORTAL MANAGEMENT SYSTEM ==========");
        System.out.println("1. Add Job Seeker");
        System.out.println("2. Add Company");
        System.out.println("3. Post a Job");
        System.out.println("4. View All Jobs");
        System.out.println("5. Apply for a Job");
        System.out.println("6. View Applications");
        System.out.println("7. Update Application Status");
        System.out.println("8. View Users");
        System.out.println("0. Exit");
        System.out.println("===================================================");
    }

    static void addJobSeeker() {
        System.out.println("\n--- Add Job Seeker ---");
        String name = readText("Enter name: ");
        String email = readText("Enter email: ");
        String qualification = readText("Enter qualification: ");

        seekers.add(new JobSeeker(nextSeekerId++, name, email, qualification));
        System.out.println("Job seeker added successfully.");
    }

    static void addCompany() {
        System.out.println("\n--- Add Company ---");
        String name = readText("Enter company name: ");
        String email = readText("Enter company email: ");
        String location = readText("Enter location: ");

        companies.add(new Company(nextCompanyId++, name, email, location));
        System.out.println("Company added successfully.");
    }

    static void postJob() {
        System.out.println("\n--- Post a Job ---");
        if (companies.isEmpty()) {
            System.out.println("Please add a company first.");
            return;
        }

        viewCompanies();
        int companyId = readInt("Enter company ID: ");
        Company company = findCompany(companyId);

        if (company == null) {
            System.out.println("Company not found.");
            return;
        }

        String title = readText("Enter job title: ");
        String location = readText("Enter job location: ");
        double salary = readDouble("Enter salary: ");

        jobs.add(new Job(nextJobId++, title, company.getName(), location, salary));
        System.out.println("Job posted successfully.");
    }

    static void viewJobs() {
        System.out.println("\n--- Available Jobs ---");
        if (jobs.isEmpty()) {
            System.out.println("No jobs available.");
            return;
        }

        for (Job job : jobs) {
            job.displayJob();
        }
    }

    static void applyForJob() {
        System.out.println("\n--- Apply for a Job ---");
        if (seekers.isEmpty() || jobs.isEmpty()) {
            System.out.println("A job seeker and at least one job are required.");
            return;
        }

        viewSeekers();
        int seekerId = readInt("Enter seeker ID: ");
        if (findSeeker(seekerId) == null) {
            System.out.println("Job seeker not found.");
            return;
        }

        viewJobs();
        int jobId = readInt("Enter job ID: ");
        if (findJob(jobId) == null) {
            System.out.println("Job not found.");
            return;
        }

        for (Application app : applications) {
            if (app.getSeekerId() == seekerId && app.getJobId() == jobId) {
                System.out.println("This job seeker has already applied for this job.");
                return;
            }
        }

        applications.add(new Application(nextApplicationId++, seekerId, jobId));
        System.out.println("Application submitted successfully.");
    }

    static void viewApplications() {
        System.out.println("\n--- Applications ---");
        if (applications.isEmpty()) {
            System.out.println("No applications found.");
            return;
        }

        for (Application app : applications) {
            app.displayApplication();
        }
    }

    static void updateApplicationStatus() {
        System.out.println("\n--- Update Application Status ---");
        if (applications.isEmpty()) {
            System.out.println("No applications found.");
            return;
        }

        viewApplications();
        int id = readInt("Enter application ID: ");
        Application application = findApplication(id);

        if (application == null) {
            System.out.println("Application not found.");
            return;
        }

        System.out.println("1. Accepted");
        System.out.println("2. Rejected");
        System.out.println("3. Pending");
        int choice = readInt("Select status: ");

        if (choice == 1) {
            application.setStatus("Accepted");
        } else if (choice == 2) {
            application.setStatus("Rejected");
        } else if (choice == 3) {
            application.setStatus("Pending");
        } else {
            System.out.println("Invalid status choice.");
            return;
        }

        System.out.println("Application status updated successfully.");
    }

    static void viewUsers() {
        System.out.println("\n--- Job Seekers ---");
        if (seekers.isEmpty()) {
            System.out.println("No job seekers found.");
        }
        for (JobSeeker seeker : seekers) {
            seeker.displayInfo();
        }

        System.out.println("\n--- Companies ---");
        if (companies.isEmpty()) {
            System.out.println("No companies found.");
        }
        for (Company company : companies) {
            company.displayInfo();
        }
    }

    static void viewSeekers() {
        System.out.println("\n--- Job Seekers ---");
        for (JobSeeker seeker : seekers) {
            seeker.displayInfo();
        }
    }

    static void viewCompanies() {
        System.out.println("\n--- Companies ---");
        for (Company company : companies) {
            company.displayInfo();
        }
    }

    static JobSeeker findSeeker(int id) {
        for (JobSeeker seeker : seekers) {
            if (seeker.getId() == id) {
                return seeker;
            }
        }
        return null;
    }

    static Company findCompany(int id) {
        for (Company company : companies) {
            if (company.getId() == id) {
                return company;
            }
        }
        return null;
    }

    static Job findJob(int id) {
        for (Job job : jobs) {
            if (job.getJobId() == id) {
                return job;
            }
        }
        return null;
    }

    static Application findApplication(int id) {
        for (Application app : applications) {
            if (app.getApplicationId() == id) {
                return app;
            }
        }
        return null;
    }

    static String readText(String message) {
        System.out.print(message);
        return input.nextLine();
    }

    static int readInt(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    static double readDouble(String message) {
        while (true) {
            try {
                System.out.print(message);
                double value = Double.parseDouble(input.nextLine());
                if (value < 0) {
                    System.out.println("Salary cannot be negative.");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid amount.");
            }
        }
    }

    static void addSampleData() {
        companies.add(new Company(nextCompanyId++, "ABC Technologies", "abc@gmail.com", "Dhaka"));
        companies.add(new Company(nextCompanyId++, "Smart Solutions", "smart@gmail.com", "Chattogram"));

        seekers.add(new JobSeeker(nextSeekerId++, "Rahim", "rahim@gmail.com", "BSc in CSE"));
        seekers.add(new JobSeeker(nextSeekerId++, "Karim", "karim@gmail.com", "BBA"));

        jobs.add(new Job(nextJobId++, "Java Developer", "ABC Technologies", "Dhaka", 50000));
        jobs.add(new Job(nextJobId++, "Software Tester", "Smart Solutions", "Chattogram", 40000));
    }
}
