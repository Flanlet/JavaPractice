import java.util.Random;

public class loto {
    public static void main(String[] args){
        int[] pool = {2, 588, 888, 1000, 10000};
        int[] result =prizeDraw(pool);
        for (int i =0;i<result.length; i++){
            System.out.println(result[i]+"元的奖金被抽出");
        }
    }

    public static int[] prizeDraw(int[] pool){

        int temp =0;
        int randomIndex =0 ;
        Random  rd = new Random();
        for (int i=0;i<pool.length;i++){
            temp = pool[i];
            randomIndex = rd.nextInt(4);
            pool[i]= pool[randomIndex];
            pool[randomIndex]=temp;
        }

        return pool;
    }
}
