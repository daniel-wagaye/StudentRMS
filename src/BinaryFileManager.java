import java.io.*;
import java.util.*;

public class BinaryFileManager {

    private static final String FILE_PATH = "data/students.dat";

    public static void saveAll(List<Student> students) {

        try (DataOutputStream dos = new DataOutputStream(
                                    new BufferedOutputStream(
                                    new FileOutputStream(FILE_PATH)))) {

            dos.writeInt(students.size());

            for (Student s : students) {
                dos.writeInt(s.getId());
                dos.writeUTF(s.getName());
                dos.writeUTF(s.getDepartment());
                dos.writeDouble(s.getGpa());
            }

            System.out.println("  [✓] Saved to binary file: " + FILE_PATH);

        } catch (IOException e) {
            System.out.println("  [!] Binary save error: " + e.getMessage());
        }
    }

    public static List<Student> loadAll() {

        List<Student> list = new ArrayList<>();

        try (DataInputStream dis = new DataInputStream(
                                   new BufferedInputStream(
                                   new FileInputStream(FILE_PATH)))) {

            int count = dis.readInt();  // read the count we wrote first

            for (int i = 0; i < count; i++) {
                int    id   = dis.readInt();
                String name = dis.readUTF();
                String dept = dis.readUTF();
                double gpa  = dis.readDouble();

                list.add(new Student(id, name, dept, gpa));
            }

            System.out.println("  [✓] Loaded " + list.size() + " student(s) from binary file.");

        } catch (FileNotFoundException e) {
            System.out.println("  [!] Binary file not found. Starting with empty list.");
        } catch (IOException e) {
            System.out.println("  [!] Binary read error: " + e.getMessage());
        }

        return list;
    }
}
