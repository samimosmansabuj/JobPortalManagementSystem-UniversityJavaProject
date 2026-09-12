# Job Portal Management System

A console-based Java application for managing job seekers, companies, job
postings, and job applications. The project demonstrates core object-oriented
programming concepts using a simple in-memory data model.

## Features

- Add and view job seekers
- Add and view companies
- Post and view job vacancies
- Submit job applications
- Prevent duplicate applications for the same job seeker and job
- View all applications
- Update an application status to `Pending`, `Accepted`, or `Rejected`
- Start with sample companies, job seekers, and jobs for demonstration

## Technology

- Java
- Java Collections Framework (`ArrayList`)
- Console input with `Scanner`
- No external libraries or database required

## Project Structure

```text
JobPortalManagementSystem/
├── .gitignore
├── Main.java
├── README.md
└── src/
    ├── Application.java
    ├── Company.java
    ├── Job.java
    ├── JobSeeker.java
    └── User.java
```

### Class Responsibilities

- `Main` - root-level application entry point, menu, input handling, and
  in-memory collections
- `User` - abstract base class for system users
- `JobSeeker` - job seeker profile and qualification
- `Company` - company profile and location
- `Job` - job posting details
- `Application` - application details and status

## Requirements

- Java Development Kit (JDK) 8 or later
- A terminal or Java-compatible IDE

Verify the Java installation:

```bash
java -version
javac -version
```

## Run from the Project Root

Compile the root-level entry point and supporting source files into the ignored
`out/` directory:

```bash
javac -d out Main.java src\*.java
```

Start the application:

```bash
java -cp out Main
```

On macOS or Linux, use `/` instead of `\` in the compile command:

```bash
javac -d out Main.java src/*.java
```

The application must be compiled from the project root because `Main.java` is
now outside `src/`. The generated `.class` files are excluded from version
control by `.gitignore`.

## OOP Concepts Demonstrated

- **Encapsulation:** fields are private and exposed through methods.
- **Abstraction:** `User` defines a common abstract user type.
- **Inheritance:** `JobSeeker` and `Company` extend `User`.
- **Polymorphism:** user subclasses provide their own `displayInfo()`
  implementation.
- **Collections:** `ArrayList` stores seekers, companies, jobs, and
  applications.

## Data and Limitations

The application stores data in memory only. Data is reset when the program
exits, and the sample data is loaded each time the application starts. No
database, authentication, or persistent storage is included.

## Cleaning Build Output

To remove compiled output created by the recommended root-level command:

```bash
Remove-Item -Recurse -Force out
```

On macOS or Linux:

```bash
rm -rf out
```

## Version-Control Guidelines

- Keep source code under `src/`.
- Keep generated files in `out/`, `build/`, or `target/`; these directories
  are ignored.
- Do not commit IDE metadata, compiled bytecode, logs, local environment files,
  or packaged artifacts.
