public class spin {
    public static void main(String[] args) {
        String A= "abcda";
        String B= "cdaab";
        System.out.println(check(A,B));

    }

    public static String spin(String s){

        StringBuilder sb = new StringBuilder(s);
        char firstchar;
        firstchar = s.charAt(0);
        sb.deleteCharAt(0);
        sb.append(firstchar);
        return sb.toString();
    }

    public static boolean check(String A, String B){


        for (int i =0; i <A.length();i++) {
            A = spin(A);
            if (A.equals(B)) {
                return true;
            }
        }


        return false;
    }
}
