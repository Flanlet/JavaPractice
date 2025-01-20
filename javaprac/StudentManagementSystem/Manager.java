import java.io.*;
import java.util.ArrayList;


public class Manager {
    private String username;
    private String password;
    private String idnumber;
    private String phonenumber;

    public Manager(String username, String password, String idnumber, String phonenumber) {
        this.username = username;
        this.password = password;
        this.idnumber = idnumber;
        this.phonenumber = phonenumber;
    }

    public Manager() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (username.length()>15 || username.length()<3) {
            System.out.println("The length of username should be between 3 to 15.");
        }
        else if (username.matches("^\\d+$")){
            System.out.println("Username should include both number and letters.");
        }
        else this.username = username;



    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        if (idnumber.length()!=18) {
            System.out.println("Length of IDnumber is invalid!");
        } else if (idnumber.charAt(0)==0) {
            System.out.println("The first number cannot be 0!");
            
        } else this.idnumber = idnumber;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        if (phonenumber.length()!=11) {
            System.out.println("Length of phone number is invalid!");

        } else if (phonenumber.charAt(0)==0) {
            System.out.println("The first number cannot be 0!");

        } else {
            this.phonenumber = phonenumber;
        }
    }

    public void saveManagerData(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            // Writing manager data into the file in a readable format (e.g., CSV or simple text)
            writer.write(this.username + "," + this.password + "," + this.idnumber + "," + this.phonenumber);
            writer.newLine();  // Add a new line for each new record
        } catch (IOException e) {
            System.out.println("Error saving manager data: " + e.getMessage());
        }
    }

    public void updateManagerData(String filename, String username, String newPassword) {
        ArrayList<Manager> managerList = loadManagerData(filename); // 加载现有数据

        // 找到目标用户并修改密码
        boolean userFound = false;
        for (Manager manager : managerList) {
            if (manager.getUsername().equals(username)) {
                manager.setPassword(newPassword);
                userFound = true;
                break;
            }
        }

        if (userFound) {
            saveManagerData(filename); // 保存更新后的数据
        } else {
            System.out.println("User not found. No changes made.");
        }
    }

    public ArrayList<Manager> loadManagerData(String filename) {
        ArrayList<Manager> managerList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(","); // 假设数据以逗号分隔
                if (data.length == 4) {
                    Manager manager = new Manager(data[0], data[1], data[2], data[3]); // 根据构造函数创建 Manager
                    managerList.add(manager);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading manager data: " + e.getMessage());
        }

        return managerList;
    }
}
