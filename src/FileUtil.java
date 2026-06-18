import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUtil {
    public static void setup() {

        File dataDir = new File("data");
        if (!dataDir.exists()) {
            dataDir.mkdirs();  // mkdirs() also creates parent folders
            System.out.println("  [+] Created folder: data/");
        }

        // List of files we need
        String[] filePaths = {
            "data/students.txt",
            "data/students.dat",
            "data/students.ser",
            "data/students_backup.ser"
        };

        for (String path : filePaths) {
            try {
                File f = new File(path);
                if (f.createNewFile()) {
                    System.out.println("  [+] Created file: " + path);
                }
            } catch (IOException e) {
                System.out.println("  [!] Could not create: " + path);
            }
        }
    }

    public static void showAllFileProperties() {

        String[] paths = {
            "data/students.txt",
            "data/students.dat",
            "data/students.ser",
            "data/students_backup.ser"
        };

        System.out.println("\n  " + "=".repeat(55));
        System.out.println("            FILE PROPERTIES");
        System.out.println("  " + "=".repeat(55));

        for (String path : paths) {
            showProperties(path);
            System.out.println("  " + "-".repeat(55));
        }
    }

    public static void showProperties(String path) {

        File f = new File(path);

        System.out.println("  File     : " + f.getName());
        System.out.println("  Path     : " + f.getAbsolutePath());

        if (!f.exists()) {
            System.out.println("  Status   : does not exist");
            return;
        }

        String lastModified = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                                  .format(new Date(f.lastModified()));

        System.out.println("  Size     : " + f.length() + " bytes");
        System.out.println("  Modified : " + lastModified);
        System.out.println("  Readable : " + f.canRead());
        System.out.println("  Writable : " + f.canWrite());
    }
}
