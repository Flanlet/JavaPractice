import java.util.Scanner;

public class Romannumber {
    public static void main(String[] args) {
        String[] roman ={"","I", "II", "III", "IV","V","VI","VII","VIII","IX"};
        System.out.println("please enter a number to convert to roman");
        Scanner sc  = new Scanner(System.in);
        String number;
        while (true) {
            number = sc.next();
            if (number.length()>9){
                System.out.println("invalid number, please try again");
            }
            else break;
        }
        StringBuilder sb= new StringBuilder();

        for (int i = 0; i < number.length(); i++) {
            int index = number.charAt(i)-48;
            sb.append(roman[index]);

        }
        System.out.println(sb.toString());





    }
}
