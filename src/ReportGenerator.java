import java.util.List;

public class ReportGenerator {

    public static void printReport(List<Student> students) {

        System.out.println("\n  " + "=".repeat(45));
        System.out.println("             STUDENT REPORT");
        System.out.println("  " + "=".repeat(45));

        if (students.isEmpty()) {
            System.out.println("  No student data available.");
            System.out.println("  " + "=".repeat(45));
            return;
        }

        int    total   = students.size();
        double highest = students.get(0).getGpa();
        double lowest  = students.get(0).getGpa();
        double sum     = 0;

        String topStudent = students.get(0).getName();
        String lowStudent = students.get(0).getName();

        for (Student s : students) {
            double g = s.getGpa();

            if (g > highest) {
                highest    = g;
                topStudent = s.getName();
            }
            if (g < lowest) {
                lowest    = g;
                lowStudent = s.getName();
            }
            sum += g;
        }

        double average = sum / total;

        System.out.printf("  Total Students  : %d%n",      total);
        System.out.printf("  Average GPA     : %.2f%n",    average);
        System.out.printf("  Highest GPA     : %.2f  (%s)%n", highest, topStudent);
        System.out.printf("  Lowest GPA      : %.2f  (%s)%n", lowest,  lowStudent);
        System.out.println("  " + "=".repeat(45));
    }
}
