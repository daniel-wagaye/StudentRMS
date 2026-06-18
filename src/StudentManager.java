import java.util.ArrayList;
import java.util.List;

public class StudentManager {

    private List<Student> students = new ArrayList<>();

    public void addStudent(int id, String name, String dept, double gpa) {
        if (findById(id) != null) {
            System.out.println("  [!] Student with ID " + id + " already exists.");
            return;
        }

        students.add(new Student(id, name, dept, gpa));
        System.out.println("  [+] Student added successfully.");
    }

    public Student findById(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                return s;   // found it!
            }
        }
        return null;        // not found
    }

    public void updateStudent(int id, String newName, String newDept, double newGpa) {

        Student s = findById(id);

        if (s == null) {
            System.out.println("  [!] Student with ID " + id + " not found.");
            return;
        }

        s.setName(newName);
        s.setDepartment(newDept);
        s.setGpa(newGpa);
        System.out.println("  [✓] Student updated successfully.");
    }

    public void deleteStudent(int id) {
        boolean removed = students.removeIf(s -> s.getId() == id);
        if (removed) {
            System.out.println("  [✓] Student deleted successfully.");
        } else {
            System.out.println("  [!] Student with ID " + id + " not found.");
        }
    }

    public void displayAll() {

        if (students.isEmpty()) {
            System.out.println("  [!] No students found.");
            return;
        }

        System.out.println("  " + "-".repeat(65));
        System.out.printf("  %-5s | %-20s | %-12s | %s%n",
                          "ID", "Name", "Department", "GPA");
        System.out.println("  " + "-".repeat(65));

        for (Student s : students) {
            System.out.println("  " + s);
        }

        System.out.println("  " + "-".repeat(65));
        System.out.println("  Total: " + students.size() + " student(s)");
    }
    public List<Student> getAll() {
        return students;
    }
    public void setAll(List<Student> list) {
        students = list;
    }
}
