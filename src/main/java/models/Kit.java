package models;

public class Kit {
    private int id;
    private int kitNum;
    private int quantity;
    private double price;
    private String team;
    private String brand;
    private String player;
    private KitSize kitSize;

    public Kit(int id, int kitNum, int quantity, double price, String team,
               String brand, String player, KitSize kitSize) {
        this.id = id;
        this.kitNum = kitNum;
        this.quantity = quantity;
        this.price = price;
        this.team = team;
        this.brand = brand;
        this.player = player;
        this.kitSize = kitSize;
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

    public KitSize getSize() {
        return kitSize;
    }

    public void setSize(KitSize kitSize) {
        this.kitSize = kitSize;
    }
}
