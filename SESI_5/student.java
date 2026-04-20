import java.util.Arrays;

public class student extends person {
    private int numCourses;
    private String[] courses;
    private int[] grades;

    public student(String name, String address) {
        super(name, address);
        this.numCourses = 0;
        this.courses = new String[10];
        this.grades = new int[10];
    }

    public void addCourseGrade(String courses, int grades) {
        this.courses[numCourses] = courses;
        this.grades[numCourses] = grades;
        this.numCourses++;
    }

    public void printGrades() {
        if (numCourses == 0) {
            System.out.println("Belum ada data mata kuliah");
            return;
        }

        for (int i = 0; i < numCourses; i++) {
            System.out.println(courses[i] + "   : " + grades[i]);
        }
    }

    public double getAverageGrade() {
        int total = 0;
        if (numCourses == 0) {
            return 0.0;
        }
        for (int i = 0; i < courses.length; i++) {
            total += grades[i];
        }
        return (double) total / numCourses;
    }

    @Override
    public String toString() {
        return "\nStudent:" + super.toString();
    }
}
