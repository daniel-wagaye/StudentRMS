import java.io.*;
import java.util.*;

public class TextFileManager {

    private static final String FILE_PATH = "data/students.txt";

    public static void saveAll(List<Student> students) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_PATH))) {

            for (Student s : students) {
                pw.println(s.getId()            + ","
                         + s.getName()          + ","
                         + s.getDepartment()    + ","
                         + s.getGpa());
            }
            System.out.println("  [✓] Saved to text file: " + FILE_PATH);

        } catch (IOException e) {
            System.out.println("  [!] Text save error: " + e.getMessage());
        }
    }

    public static List<Student> loadAll() {
        List<Student> list = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(FILE_PATH))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (line.isEmpty()) continue;
                String[] parts = line.split(",");
                int    id   = Integer.parseInt(parts[0]);
                String name = parts[1];
                String dept = parts[2];
                double gpa  = Double.parseDouble(parts[3]);
                list.add(new Student(id, name, dept, gpa));
            }

            System.out.println("  [✓] Loaded " + list.size() + " student(s) from text file.");
        } catch (FileNotFoundException e) {
            System.out.println("  [!] Text file not found. Starting with empty list.");
        } catch (Exception e) {
            System.out.println("  [!] Text read error: " + e.getMessage());
        }

        return list;
    }
}
