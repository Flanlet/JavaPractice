public class Phone {
    String brand;
    int price;

    public Phone(String brand,int price) {
        this.price = price;
        this.brand = brand;
    }

    public Phone() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
