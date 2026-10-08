import java.util.Scanner;

class Student {
    private String studentName;
    private String rollNumber;
    private double marks;
    private String courseName;
    private int courseCredits;

    public Student(String studentName, String rollNumber, double marks, String courseName, int courseCredits) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.marks = marks;
        this.courseName = courseName;
        this.courseCredits = courseCredits;
    }

    public boolean checkEligibility() {
        return this.marks >= 50.0;
    }

    public double calculateFee() {
        return this.courseCredits * 1500.0;
    }

    public double calculateScholarship() {
        double totalFee = calculateFee();
        if (this.marks >= 85.0) {
            return totalFee * 0.20; // 20% scholarship
        } else if (this.marks >= 70.0 && this.marks < 85.0) {
            return totalFee * 0.10; // 10% scholarship
        } else {
            return 0.0;
        }
    }

    public double calculateFinalFee() {
        return calculateFee() - calculateScholarship();
    }

    public void displayDetails() {
        System.out.println("\n--- Student Course Registration Details ---");
        System.out.println("Student Name    : " + this.studentName);
        System.out.println("Roll Number     : " + this.rollNumber);
        System.out.println("Marks Obtained  : " + this.marks);
        System.out.println("Course Name     : " + this.courseName);
        System.out.println("Course Credits  : " + this.courseCredits);
        System.out.println("Eligibility     : Eligible");
        System.out.println("Total Course Fee: Rs. " + calculateFee());
        System.out.println("Scholarship     : Rs. " + calculateScholarship());
        System.out.println("Final Fee to Pay: Rs. " + calculateFinalFee());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.println("Enter Roll Number: ");
        String roll = scanner.nextLine();

        System.out.println("Enter Marks Obtained: ");
        double marks = scanner.nextDouble();
        scanner.nextLine(); 

        System.out.println("Enter Course Name: ");
        String course = scanner.nextLine();

        System.out.println("Enter Course Credits: ");
        int credits = scanner.nextInt();

        Student student = new Student(name, roll, marks, course, credits);

        if (student.checkEligibility()) {
            student.displayDetails();
        } else {
            System.out.println("\n--- Registration Status ---");
            System.out.println("Student Name   : " + name);
            System.out.println("Roll Number    : " + roll);
            System.out.println("Marks Obtained : " + marks);
            System.out.println("Eligibility    : Not Eligible (Marks are below 50)");
            System.out.println("Registration Failed: Minimum requirement of 50 marks not met.");
        }

        scanner.close();
    }
}