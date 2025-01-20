import java.util.ArrayList;

public class addUsers {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        User user1 =new User("001", "Nana","123456");
        User user2 =new User("002", "Ceylan","8888888");
        User user3 =new User("003", "Gevin","asdzxcdqwe123");

        users.add(user1);
        users.add(user2);
        users.add(user3);

        checkId("004",users);



    }

    public static boolean checkId(String id, ArrayList<User> users){
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(id)) {
                System.out.println("Id:"+id+" Username:"+users.get(i).getUsername()+" password:"+users.get(i).getPassword());
                return true;
            }

        }
        System.out.println("Users with Id "+id+" dosen't exist.");
        return false;

    }
}
