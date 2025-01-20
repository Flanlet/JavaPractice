import java.util.Random;


public class verifiedcode {
    public static void main(String[] args) {
        System.out.println(getCode());

    }
    public static String getCode(){
        Random random = new Random();
        String code = "";
        for(int i = 0; i <= 4; i++){
            int a = random.nextInt(52);
            if(i == 4){
                code += random.nextInt(9);
                break;
            }
            if(a < 26){
                code += (char)(a + 'A') + "";
            }
            if(a >=26){
                code += (char)(a - 26 + 'a') + "";
            }


        }
        return code;
    }
}
