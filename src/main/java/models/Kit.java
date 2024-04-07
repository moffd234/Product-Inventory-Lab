package models;

public class Kit {
    private int id;
    private int kitNum;
    private int quantity;
    private double price;
    private String team;
    private String brand;
    private String player;
    private Size size;

    public Kit(){
        this.size = Size.SMALL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKitNum() {
        return kitNum;
    }

    public void setKitNum(int kitNum) {
        this.kitNum = kitNum;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
}
enum Size{
    SMALL,
    MEDIUM,
    LARGE;
}
