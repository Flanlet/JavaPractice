import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class doubleColor {

    public static void main(String[] args){
        int[] rednumber = buyRedLoto();
        int bluenumber = buyBlueLoto();
        Object[] result = shotnumber(rednumber,bluenumber);
        String shotnumber =(String)result[1];
        String prize =(String) result[0];

        switch (prize){


            case "[0, 1]":
                System.out.println("中六等奖");
                break;
            case "[1, 1]":
                System.out.println("中六等奖");
                break;
            case "[2, 1]":
                System.out.println("中六等奖");
                break;
            case "[3, 1]":
                System.out.println("中五等奖");
                break;
            case "[4, 0]":
                System.out.println("中五等奖");
                break;

            case "[4, 1]":
                System.out.println("中四等奖");
                break;

            case "[5, 0]":
                System.out.println("中四等奖");
                break;
            case "[5, 1]":
                System.out.println("中三等奖");
                break;
            case "[6, 0]":
                System.out.println("恭喜你！！！！！！中了二等奖！！！！！！芜湖！！！起飞！！！！！99999999999999999元人民币！！！！！");
                break;
            case "[6, 1]":
                System.out.println("中一等奖");
                break;
            default:
                System.out.println("很遗憾没中奖");
        }
        System.out.println("中奖号码是："+shotnumber);
    }

    public static Object[] shotnumber(int[] rednumber, int bluenumber){
        Random rd = new Random();
        int redcount = 0;
        int bluecount = 0;
        int[] shotNumber =new int[7];
        for(int j=0; j< rednumber.length;j++){
            shotNumber[j] = rd.nextInt(33)+1;
        }


        for (int i=0; i< shotNumber.length;i++){
            shotNumber[i] =i+1;//cheat
        }


        for (int i=0; i< rednumber.length;i++){
            for(int j=0; j< rednumber.length;j++){
                if(rednumber[i]==shotNumber[j]){
                    redcount++;
                }
            };

        }
        shotNumber[6] = rd.nextInt(16)+1;




        if(bluenumber == shotNumber[6])bluecount++;
        int[] result = {redcount, bluecount};
        String result2 = Arrays.toString(result);

        String shotNumber2 = Arrays.toString(shotNumber);
        Object[] ob = {result2, shotNumber2};
        return ob;
    }

    public static int[] buyRedLoto(){
        Scanner sc = new Scanner(System.in);
        int[] rednumber = new int[6];

        for (int i=0; i< 6;i++) {
            System.out.println("请输入要购买的红色球的号码（1-33）:");
            rednumber[i]=sc.nextInt();

        }
        return rednumber;
    }
    public static int buyBlueLoto(){
        Scanner sc = new Scanner(System.in);

        int bluenumber = 0;

        System.out.println("请输入要购买的蓝色球的号码（1-16）");
        bluenumber=sc.nextInt();

        return bluenumber;



}
}

