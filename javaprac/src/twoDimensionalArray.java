public class twoDimensionalArray {
    public static void main(String[] args){
        int[][] array = {
                {22,66,44},
                {77,33,88},
                {25,45,65},
                {11,66,99}
        };
        int yearSum =0;
        for(int i=0; i<array.length;i++){
            int seasonSum = 0;
            for (int j=0; j<array[i].length;j++){
                seasonSum +=array[i][j];

            }
            yearSum +=seasonSum;
            System.out.println("第"+(i+1)+"季度的营业额为："+seasonSum);
        }

        System.out.println("全年的营业额为:"+yearSum);

    }
}
