import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class HomePage {
    public static void main(String[] args) {
        ArrayList<Manager> Managerlist = DataLoader.loadManagerData("managers.txt");
        Scanner sc = new Scanner(System.in);
        boolean isLogin =false;
        /// loginPage
        while (true) {
            System.out.println("Welcome to SMS!");
            System.out.println("Please select:1.Login in 2.Register 3.Forget password");


            int option1 = sc.nextInt();

            switch (option1) {
                case 1 -> isLogin =Login(Managerlist);
                case 2 -> RegisterPage(Managerlist);
                case 3 -> Managerlist = ForgetPasswordPage(Managerlist);
            }

            if (isLogin) break;
        }
        /// Student Management Page
        ArrayList<Student> studentlist = DataLoader.loadStudentData("students.txt");
        loop:while (true) {
                System.out.println("Welcome to Student Management System.");
                System.out.println("Please select: 1.add student 2.delete student 3.modify student 4.query student information 5.exit");
                System.out.println("please confirm your option:");

                int option2 = sc.nextInt();

                switch (option2) {
                    case 1:
                        studentlist = addStudent(studentlist);
                        break;
                    case 2:
                        studentlist = deleteStudent(studentlist);
                        break;
                    case 3:
                        studentlist = modifyStudent(studentlist);
                        break;
                    case 4:
                        studentlist = queryStudent(studentlist);
                        break;
                    case 5:
                        System.exit(0);
                    default:
                        System.out.println("Wrong option.");
                }
            }

        }


    public static ArrayList<Student> addStudent(ArrayList<Student>  studentlist){
        Scanner sc = new Scanner(System.in);
        Student student = new Student();
        System.out.println("Please enter the username:");
        student.setName(sc.next());
        System.out.println("Please enter age:");
        student.setAge(sc.nextInt());
        while (true) {
            System.out.println("Please enter id:");
            String id =sc.next();
            if (!id.matches("\\d{3}")) {
                System.out.println("Invalid ID. Please follow the format as 3 numbers.");
                continue;
            }

            if (IdExist(id,studentlist)){
                System.out.println("This Id exists, please enther another one.");
                continue;

            }
            else {
                student.setId(id);
                break;
            }
        }

        System.out.println("Please enter address:");
        student.setAddress(sc.next());

        studentlist.add(student);
        student.saveStudentData("students.txt");
        System.out.println("Student added successfully!");

        return studentlist;


    }


    public static ArrayList<Student> deleteStudent(ArrayList<Student>  studentlist){
        Scanner sc = new Scanner(System.in);
        Student student = new Student();
        System.out.println("Please enter the Id of student you want to delete:");
        String id = sc.next();
        if(IdExist(id, studentlist)){
            for (int i = 0; i < studentlist.size(); i++) {
                if(id.equals(studentlist.get(i).getId())){
                    studentlist.remove(i);
                }
            }
        }
        else {
            System.out.println("Id doesn't exist. Return to homepage.");

        }

        return studentlist;

    }


    public static ArrayList<Student> modifyStudent(ArrayList<Student>  studentlist){
        Scanner sc = new Scanner(System.in);
        Student student = new Student();
        System.out.println("Please enter the id of student you want to modify.");
        String id = sc.next();
        if(IdExist(id, studentlist)){
            for (int i = 0; i < studentlist.size(); i++) {
                if(id.equals(studentlist.get(i).getId())){
                    Student s =studentlist.get(i);
                    System.out.println("Please enter the username:");
                    s.setName(sc.next());
                    System.out.println("Please enter age:");
                    s.setAge(sc.nextInt());
                    System.out.println("Please enter address:");
                    s.setAddress(sc.next());
                }
            }
        }
        else {
            System.out.println("Id doesn't exist. Return to homepage.");

        }
        return studentlist;

    }


    public static ArrayList<Student> queryStudent(ArrayList<Student>  studentlist){
        Scanner sc = new Scanner(System.in);
        Student student = new Student();
        System.out.println("Please enter the id of student you want to query.");
        String id = sc.next();
        if(IdExist(id, studentlist)){
            for (int i = 0; i < studentlist.size(); i++) {
                if(id.equals(studentlist.get(i).getId())){
                    System.out.println("id:"+id+"\tname:"+studentlist.get(i).getName()+"\tage:"+studentlist.get(i).getAge()+"\taddress:"+studentlist.get(i).getAddress());
                    System.out.println();
                }
            }
        }
        else {
            System.out.println("Id doesn't exist. Returning to homepage.");

        }
        return studentlist;
    }

    public static boolean IdExist(String id, ArrayList<Student> users){

        if (users.size()>0) {
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getId().equals(id)) {

                    return true;
                }

            }
        }


        return false;

    }

    public static boolean ManagerNameExist(ArrayList<Manager>  Mangagelist, String username){
        if (Mangagelist.size()>0) {
            for (int i = 0; i < Mangagelist.size(); i++) {
                if (Mangagelist.get(i).getUsername().equals(username)) {


                    return true;
                }

            }

        }
        return false;
    }

//    public static boolean isValid(String id){
//
//    }
    public static ArrayList<Manager>  RegisterPage(ArrayList<Manager>  Managerlist){
        Scanner sc = new Scanner(System.in);
        Manager mg = new Manager();


        /// verify if username is valid
        while (true){
            System.out.println("Please enter username:");
            String username = sc.next();
            if (ManagerNameExist(Managerlist,username)){
                System.out.println("This username exists. Please enter another one.");
                continue;
            }
            else{
                mg.setUsername(username);
                if (mg.getUsername()!= null) {
                    break;
                }
                else continue;
            }
        }
        /// set password
        while (true) {

            System.out.println("Please enter your password:");
            String password = sc.next();
            System.out.println("Please enter your password again, it should be same as the first:");
            String password2 = sc.next();
            if (password2.equals(password)){
                mg.setPassword(password);
                break;
            }
            else {
                System.out.println("Two password is different. Please enter again.");
                continue;
            }

        }
        ///set idnumber

        while (true){

            System.out.println("Please enter your id number:");
            String idnumber =sc.next();
            mg.setIdnumber(idnumber);
            if (mg.getIdnumber()!=null){
                break;
            }
        }

        /// set phone number
        while (true){
            System.out.println("Please enter your phone number:");
            String phonenumber =sc.next();
            mg.setPhonenumber(phonenumber);
            if (mg.getPhonenumber()!=null){
                break;
            }
        }


        Managerlist.add(mg);
        mg.saveManagerData("managers.txt");

        return Managerlist;


    }


    public static boolean  Login(ArrayList<Manager>  Managerlist){
        Scanner sc = new Scanner(System.in);
        Manager mg = new Manager();

        for (int i =0 ; i<3;i++) {

            System.out.println("Please enter username:");
            String username = sc.next();

            if (!ManagerNameExist(Managerlist,username)){
                System.out.println("Username doesn't exist, please register first. Returning to Login page.");
                return  false;
            }


            for (int j = 0; j < Managerlist.size(); j++) {
                if(Managerlist.get(j).getUsername().equals(username)){
                    mg = Managerlist.get(j);
                }

            }

            ///
            if (mg==null){
                System.out.println("error");
                return  false;
            }

            System.out.println("Please enter password:");
            String password = sc.next();

            /// verify code
            while (true) {
                String vc = RandomVerifyingCode.randomVerifyingCode();
                System.out.println("verifying code is:"+vc);
                System.out.println("Please enter verifing code:");
                String verifingCode = sc.next();
                if (verifingCode.equals(vc)) break;  //modify
                else System.out.println("verifying code incorrect!");

            }
            /// password
            if (mg.getPassword().equals(password)){
                break;
            }
            if (i==2){
                System.out.println("Three chances run out. Returning to Login page.");
                return false;
            }
            System.out.println("Username or password is incorrect, please try again.");

        }

        System.out.println("Login successfully!");

        return true;
    }

    public static ArrayList<Manager> ForgetPasswordPage(ArrayList<Manager> Managerlist){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enther your username:");
        String username =sc.next();
        Manager mg = new Manager();
        if (!ManagerNameExist(Managerlist,username)){
            System.out.println("No such user.");
            System.out.println("Returning to login page");
            return  Managerlist;
        }

        System.out.println("Please enter your IDnumber:");
        String idnumber =sc.next();
        System.out.println("Please enter your phone number:");
        String phonenumber =sc.next();

        for (int j = 0; j < Managerlist.size(); j++) {
            if(Managerlist.get(j).getUsername().equals(username)){
                mg = Managerlist.get(j);
            }

        }
        String newpassword;
        if (mg.getPhonenumber().equals(phonenumber)&&mg.getIdnumber().equals(idnumber)){
            System.out.println("Please enther your new password:");
            newpassword = sc.next();
            mg.setPassword(newpassword);

            if (mg.getPassword()!=null) {
                System.out.println("Modify password successfully!");
            }
        }
        else{
            System.out.println("Idnumber or phone number is incorrect. Returning to Login page.");
            return Managerlist;
        }
        saveManagerListToFile("managers.txt", Managerlist);

        return Managerlist;

    }


    public static void saveManagerListToFile(String filename, ArrayList<Manager> managerList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, false))) { // false 表示覆盖写入
            for (Manager manager : managerList) {
                // 按行写入每个 Manager 的数据
                writer.write(manager.getUsername() + "," + manager.getPassword() + ","
                        + manager.getIdnumber() + "," + manager.getPhonenumber());
                writer.newLine(); // 写入换行符
            }
        } catch (IOException e) {
            System.out.println("Error saving manager list to file: " + e.getMessage());
        }
    }
}





