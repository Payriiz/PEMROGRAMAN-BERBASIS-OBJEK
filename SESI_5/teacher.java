import java.util.Arrays;

public class teacher extends person {
    private int numCourses;
    private String[] courses;

    public teacher(String name, String address) {
        super(name, address);
        this.numCourses = 0;
        this.courses = new String[10];
    }

    public boolean addCourses(String course) {
        for (int i = 0; i < numCourses; i++) {
            if (courses[i].equals(course)) {
                return false;
            }
        }

        courses[numCourses] = course;
        numCourses++;
        return true;
    }

    public boolean removeCourse(String course) {
        int indexFound = -1;
        for (int i = 0; i < numCourses; i++) {
            if(courses[i].equals(course)) {
                indexFound = i;
                break;
            }
        }

        if (indexFound == -1) {
            return false;
        }

        for (int i = indexFound; i < numCourses - 1; i++) {
            courses[i] = courses[i + 1];
        }

        numCourses--;
        return true;
    }

    @Override
    public String toString() {
        String data = "\nTeacher:   " + super.toString();
        data += "\nMata Kuliah yang Diampu:\n";

        if (numCourses == 0) {
            data += "Tidak Ada Mata Kuliah yang Diampu";
        } else {
            for (int i = 0; i < numCourses; i++) {
                data += (i+1) + ". " + courses[i] + "\n";
            }
        }
        return data;
    }
}
