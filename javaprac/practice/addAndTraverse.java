import java.util.ArrayList;

public class addAndTraverse {
    public static void main(String[] args) {
        ArrayList<Student> st = new ArrayList<>();
        Student st1 = new Student();
        Student st2 = new Student();

        st.add(st1);
        st.add(st2);

        for (int i = 0; i < st.size(); i++) {
            System.out.println(st.get(i).getName()+ ","+st.get(i).getAge()+" years old");
        }
    }
}


