import java.util.Random;

public class RandomVerifyingCode {
    public static String randomVerifyingCode() {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder(5);
        int number = rand.nextInt(10);
        int index = rand.nextInt(5);


        for (int i = 0; i < 5; i++) {
            if (i == index) {
                sb.append(number);
                continue;
            }
            int iscapital = rand.nextInt(2);
            if (iscapital==0)sb.append((char)('a'+rand.nextInt(26)));
            else if (iscapital==1)sb.append((char)('A'+rand.nextInt(26)));
        }
        return sb.toString();

    }
}
