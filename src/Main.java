import java.util.Scanner;
public class Main {
    static StudentManager manager = new StudentManager();
    static Scanner        input   = new Scanner(System.in);

    public static void main(String[] args) {

        FileUtil.setup();

        System.out.println("\n  Welcome to Student Record Management System");
        System.out.println("  Loading data from text file...");

        manager.setAll(TextFileManager.loadAll());


        boolean running = true;
        while (running) {
            printMenu();
            int choice = readInt("  Enter your choice: ");

            switch (choice) {
                case 1  -> addStudent();
                case 2  -> searchStudent();
                case 3  -> updateStudent();
                case 4  -> deleteStudent();
                case 5  -> manager.displayAll();
                case 6  -> saveToAllFormats();
                case 7  -> loadFromTextFile();
                case 8  -> loadFromBinaryFile();
                case 9  -> loadFromSerialFile();
                case 10 -> ReportGenerator.printReport(manager.getAll());
                case 11 -> FileUtil.showAllFileProperties();
                case 12 -> createBackup();
                case 0  -> {
                    System.out.println("\n  Goodbye!");
                    running = false;
                }
                default -> System.out.println("  [!] Invalid choice. Try again.");
            }
        }

        input.close();
    }

    static void printMenu() {
        System.out.println("\n  " + "─".repeat(40));
        System.out.println("       STUDENT RECORD MANAGEMENT");
        System.out.println("  " + "─".repeat(40));
        System.out.println("   1.  Add Student");
        System.out.println("   2.  Search Student by ID");
        System.out.println("   3.  Update Student");
        System.out.println("   4.  Delete Student");
        System.out.println("   5.  Display All Students");
        System.out.println("  " + "─".repeat(40));
        System.out.println("   6.  Save to ALL file formats");
        System.out.println("   7.  Load from Text File (.txt)");
        System.out.println("   8.  Load from Binary File (.dat)");
        System.out.println("   9.  Load from Serialized File (.ser)");
        System.out.println("  " + "─".repeat(40));
        System.out.println("   10. Generate Report");
        System.out.println("   11. Show File Properties");
        System.out.println("   12. Create Backup");
        System.out.println("  " + "─".repeat(40));
        System.out.println("   0.  Exit");
        System.out.println("  " + "─".repeat(40));
    }
    static void addStudent() {
        System.out.println("\n  -- Add New Student --");
        int    id   = readInt("  Enter Student ID   : ");
        String name = readStr("  Enter Name         : ");
        String dept = readStr("  Enter Department   : ");
        double gpa  = readDbl("  Enter GPA (0-4.0)  : ");
        manager.addStudent(id, name, dept, gpa);
    }


    static void searchStudent() {
        System.out.println("\n  -- Search Student --");
        int     id = readInt("  Enter Student ID: ");
        Student s  = manager.findById(id);

        if (s != null) {
            System.out.println("  Found: " + s);
        } else {
            System.out.println("  [!] No student with ID " + id);
        }
    }

    static void updateStudent() {
        System.out.println("\n  -- Update Student --");
        int id = readInt("  Enter Student ID to update: ");

        Student s = manager.findById(id);
        if (s == null) {
            System.out.println("  [!] Student not found.");
            return;
        }

        System.out.println("  Current: " + s);
        String name = readStr("  New Name         : ");
        String dept = readStr("  New Department   : ");
        double gpa  = readDbl("  New GPA (0-4.0)  : ");
        manager.updateStudent(id, name, dept, gpa);
    }


    static void deleteStudent() {
        System.out.println("\n  -- Delete Student --");
        int id = readInt("  Enter Student ID to delete: ");
        manager.deleteStudent(id);
    }


    static void saveToAllFormats() {
        System.out.println("\n  -- Saving to all formats --");
        TextFileManager .saveAll(manager.getAll());
        BinaryFileManager.saveAll(manager.getAll());
        SerialFileManager.saveAll(manager.getAll());
    }

    static void loadFromTextFile() {
        System.out.println("\n  -- Loading from text file --");
        manager.setAll(TextFileManager.loadAll());
    }

    static void loadFromBinaryFile() {
        System.out.println("\n  -- Loading from binary file --");
        manager.setAll(BinaryFileManager.loadAll());
    }

    static void loadFromSerialFile() {
        System.out.println("\n  -- Loading from serialized file --");
        manager.setAll(SerialFileManager.loadAll());
    }

    static void createBackup() {
        System.out.println("\n  -- Creating backup --");
        SerialFileManager.createBackup(manager.getAll());
    }

    static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(input.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("  [!] Please enter a whole number.");
            }
        }
    }

    static double readDbl(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                double val = Double.parseDouble(input.nextLine().trim());
                if (val < 0 || val > 4.0) {
                    System.out.println("  [!] GPA must be between 0.0 and 4.0");
                    continue;
                }
                return val;
            } catch (NumberFormatException e) {
                System.out.println("  [!] Please enter a valid number.");
            }
        }
    }

    static String readStr(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = input.nextLine().trim();
            if (!s.isEmpty()) return s;
            System.out.println("  [!] This field cannot be empty.");
        }
    }
}
