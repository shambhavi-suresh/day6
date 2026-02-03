import java.util.Scanner;
class Student {

    private String name;
    private int rollNo;
    private int[] marks;
    private int total;
    private double average;
    private char grade;

    Student(String name, int rollNo, int subjects) {
        this.name = name;
        this.rollNo = rollNo;
        marks = new int[subjects];  
    }

   
    public void setMarks(int[] marks) {
        this.marks = marks;
    }

    public void calculateTotal() {
        total = 0;
        for (int m : marks) {
            total += m;
        }
    }

  
    public void calculateAverage() {
        average = (double) total / marks.length;
    }

  
    public void calculateGrade() {
        if (average >= 90) {
            grade = 'A';
        } else if (average >= 75) {
            grade = 'B';
        } else if (average >= 60) {
            grade = 'C';
        } else if (average >= 40) {
            grade = 'D';
        } else {
            grade = 'F';
        }
    }
    public void displayDetails() {
        System.out.println(
            name + " → Total: " + total +
            " | Avg: " + String.format("%.2f", average) +
            " | Grade: " + grade
        );
    }
}

public class Project{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
p)
        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {

            System.out.println("\nEnter details for Student " + (i + 1));

            System.out.print("Name: ");
            sc.nextLine(); 
            String name = sc.nextLine();

            System.out.print("Roll No: ");
            int rollNo = sc.nextInt();

            System.out.print("Number of subjects: ");
            int subjects = sc.nextInt();

            int[] marks = new int[subjects];

            System.out.println("Enter marks:");
            for (int j = 0; j < subjects; j++) {
                marks[j] = sc.nextInt();
            }

       
            students[i] = new Student(name, rollNo, subjects);
            students[i].setMarks(marks);
            students[i].calculateTotal();
            students[i].calculateAverage();
            students[i].calculateGrade();
        }

        System.out.println("\n===== STUDENT REPORTS =====");
        for (Student s : students) {
            s.displayDetails();
        }

        sc.close();
    }
}
