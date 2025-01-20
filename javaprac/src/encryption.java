import java.util.Scanner;


public class encryption {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        System.out.println("请输入要加密的数据：");
        int origin =sc.nextInt();
        System.out.println(encrypt(origin));
        System.out.println("请输入要解密的数据：");
        int encrypted =sc.nextInt();
        System.out.println(decrypt(encrypted));

    }

    public static String encrypt(int origin){
        int length = countDigits(origin);
        int[] number = new int[length];
        for (int i = 0; i < length; i++) {
            number[i] = (origin % 10+5)%10;
            origin /=10;

        }


        String result = "";
        for(int i =0;i<number.length;i++){
            result+= number[i];

        }
        return result;

    }

    public static int countDigits(int number){
        int count  = 0;
        while (number > 0) {
            number /= 10;
            count++;
        }
        return count;
    }
    public static int[] reverse(int[] number) {
        int reverse[] = new int[number.length];

        for(int i=0; i<number.length; i++){
            reverse[i] = number[number.length-i-1];
        }
        return reverse;
    }

    public static String decrypt(int origin){
        int length = countDigits(origin);
        int[] number = new int[length];
        for (int i = 0; i < length; i++) {
            number[i] = origin % 10;
            if (number[i]>=0 &&number[i]<=4){
                number[i]+=10;
                number[i]-=5;

            }
            else {
                number[i] -=5;
            }
            origin /=10;





        }


        String result = "";
        for(int i =0;i<number.length;i++){
            result+= number[i];

        }
        return result;

    }
}

