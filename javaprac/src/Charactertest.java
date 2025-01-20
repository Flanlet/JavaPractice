public class Charactertest {
   public static void main(String[] args){
       Character c1 = new Character("界徐盛", 4561, 89);
       Character c2 = new Character("泡狐龙", 5131, 231);

       while(c1.isalive()&&c2.isalive()){
           c1.attack(c2);
           c2.attack(c1);

       }


   }
}
