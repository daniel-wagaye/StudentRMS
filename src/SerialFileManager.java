import java.io.*;
import java.util.*;

public class SerialFileManager {

    private static final String FILE_PATH   = "data/students.ser";
    private static final String BACKUP_PATH = "data/students_backup.ser";


    public static void saveAll(List<Student> students) {

        try (ObjectOutputStream oos = new ObjectOutputStream(
                                      new FileOutputStream(FILE_PATH))) {

            oos.writeObject(students);  // saves the entire list in one line!
            System.out.println("  [✓] Saved to serialized file: " + FILE_PATH);

        } catch (IOException e) {
            System.out.println("  [!] Serialization error: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")  // tells Java we know the cast is safe
    public static List<Student> loadAll() {

        try (ObjectInputStream ois = new ObjectInputStream(
                                     new FileInputStream(FILE_PATH))) {

            List<Student> list = (List<Student>) ois.readObject();
            System.out.println("  [✓] Loaded " + list.size() + " student(s) from serialized file.");
            return list;

        } catch (FileNotFoundException e) {
            System.out.println("  [!] Serialized file not found. Starting with empty list.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("  [!] Deserialization error: " + e.getMessage());
        }

        return new ArrayList<>();
    }

    public static void createBackup(List<Student> students) {

        try (ObjectOutputStream oos = new ObjectOutputStream(
                                      new BufferedOutputStream(
                                      new FileOutputStream(BACKUP_PATH)))) {

            oos.writeObject(students);
            System.out.println("  [✓] Backup created: " + BACKUP_PATH);

        } catch (IOException e) {
            System.out.println("  [!] Backup error: " + e.getMessage());
        }
    }
}
