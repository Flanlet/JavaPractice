import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Student{

    private String id;
    private String name;
    private int age;
    private String address;

    public Student(String id, String name, int age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Student() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void saveStudentData(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            // Writing manager data into the file in a readable format (e.g., CSV or simple text)
            writer.write(this.id + "," + this.name + "," + this.age + "," + this.address);
            writer.newLine();  // Add a new line for each new record
        } catch (IOException e) {
            System.out.println("Error saving manager data: " + e.getMessage());
        }
    }
}
