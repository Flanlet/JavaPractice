import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class DataLoader {
    // Method to read student data from a file
    public static ArrayList<Student> loadStudentData(String filename) {
        ArrayList<Student> studentList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the data by comma (assuming you saved the data as comma-separated values)
                String[] data = line.split(",");
                if (data.length == 4) {
                    Student student = new Student();
                    student.setId(data[0]);
                    student.setName(data[1]);
                    student.setAge(Integer.parseInt(data[2]));
                    student.setAddress(data[3]);
                    studentList.add(student);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading manager data: " + e.getMessage());
        }
        return studentList;
    }

    public static ArrayList<Manager> loadManagerData(String filename) {
        ArrayList<Manager> managerList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the data by comma (assuming you saved the data as comma-separated values)
                String[] data = line.split(",");
                if (data.length == 4) {
                    Manager manager = new Manager();
                    manager.setUsername(data[0]);
                    manager.setPassword(data[1]);
                    manager.setIdnumber(data[2]);
                    manager.setPhonenumber(data[3]);
                    managerList.add(manager);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading manager data: " + e.getMessage());
        }
        return managerList;
    }
}

