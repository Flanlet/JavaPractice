import java.util.Scanner;

public class Score {
    public static void main(String[] args) {
        int[] a = getScore();
        System.out.println("最后成绩是："+scoreCalculator(a));
    }

    public static double scoreCalculator(int[] a){

        int[] maxAndMin = findMaxAndMin(a);
        int maxindex = maxAndMin[1];
        int minindex = maxAndMin[3];
        double sum = 0;
        for(int i = 0; i < a.length; i++){
            if(maxindex == i || minindex == i){
                continue;
            }
            sum += a[i];
        }
        return sum/(a.length-2);
    }
    public static int[] findMaxAndMin(int[] arr){
        int max= arr[0];
        int min= arr[0];
        int maxindex = 0;
        int minindex = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
                maxindex = i;
            }
            if(arr[i] < min){
                min = arr[i];
                minindex = i;
            }
        }
        int[] result={max,maxindex,min,minindex};
        return result;
    }

    public static int[] getScore(){
        int[] score =new int[6];
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < 6; i++){
            System.out.println("请输入第"+(i+1)+"个成绩:");

            score[i] = scanner.nextInt();
        }
        return score;
    }
}
