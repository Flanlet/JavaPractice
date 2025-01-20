import java.util.ArrayList;

public class SelectPhone {
    public static void main(String[] args) {
        Phone xiaomi = new Phone("Xiaomi",1000);
        Phone apple = new Phone("Apple",8000);
        Phone hammer = new Phone("Hammer",2999);

        ArrayList<Phone> phoneList = new ArrayList<>();
        phoneList.add(xiaomi);
        phoneList.add(apple);
        phoneList.add(hammer);

        ArrayList<Phone> cheapPhone = priceUnder3000(phoneList);
        for (int i = 0; i < cheapPhone.size(); i++) {
            System.out.println(cheapPhone.get(i).getBrand());
        }
    }

    public static ArrayList<Phone> priceUnder3000(ArrayList<Phone> phoneList){
        int price;
        ArrayList<Phone> priceUnder3000 = new ArrayList<>();

        for (int i = 0; i < phoneList.size(); i++) {
            price = phoneList.get(i).getPrice();
            if (price<=3000){
                priceUnder3000.add(phoneList.get(i));

            }
        }
        return priceUnder3000;
    }
}
