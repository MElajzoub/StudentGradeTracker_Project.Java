import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentGradeTracker {
    private Map<String, Double> grades;

    public StudentGradeTracker() {
        this.grades = new HashMap<>();
    }

    public void addGrade(String subject, double grade) {
        grades.put(subject, grade);
    }

    public double calculateGPA() {
        double totalGradePoints = 0;
        int totalCredits = 0;
        for (Map.Entry<String, Double> entry : grades.entrySet()) {
            double grade = entry.getValue();
            totalGradePoints += grade;
            totalCredits += 3;
        }
        double gpa = totalGradePoints / (grades.size() * 4.0);
        if (gpa < 2.0) {
            System.out.println("Your GPA is below 2.0. Study more!");
        }
        return gpa;
    }

    public void displayGrades() {
        System.out.println("Subject\t\tGrade");
        for (Map.Entry<String, Double> entry : grades.entrySet()) {
            System.out.println(entry.getKey() + "\t\t" + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentGradeTracker tracker = new StudentGradeTracker();

        System.out.println("Welcome to the Student Grade Tracker!");

        boolean running = true;
        while (running) {
            System.out.println("\n1. Add grade");
            System.out.println("2. View grades");
            System.out.println("3. View GPA");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter subject: ");
                    String subject = scanner.nextLine();
                    System.out.print("Enter grade (out of 4.0): ");
                    double grade = scanner.nextDouble();
                    tracker.addGrade(subject, grade);
                    break;
                case 2:
                    tracker.displayGrades();
                    break;
                case 3:
                    System.out.println("GPA: " + tracker.calculateGPA());
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
        scanner.close();
    }
}
