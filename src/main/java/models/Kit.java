package models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Kit {
    private int id;
    private int kitNum;
    private int quantity;
    private double price;
    private String team;
    private String brand;
    private String player;
    private KitSize kitSize;

    @JsonCreator
    public Kit(@JsonProperty("id") int id,
               @JsonProperty("kitNum") int kitNum,
               @JsonProperty("quantity") int quantity,
               @JsonProperty("price") double price,
               @JsonProperty("team") String team,
               @JsonProperty("brand") String brand,
               @JsonProperty("player") String player,
               @JsonProperty("kitSize") KitSize kitSize) {
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

    @Override
    public String toString() {
        return "Kit{" +
                "id: " + id + "\n" +
                "   - kitNum=" + kitNum + "\n" +
                "   - quantity=" + quantity + "\n" +
                "   - price=" + price + "\n" +
                "   - team='" + team + '\'' + "\n" +
                "   - brand='" + brand + '\'' + "\n" +
                "   - player='" + player + '\'' + "\n" +
                "   - kitSize=" + kitSize + "\n\n";
    }
}
