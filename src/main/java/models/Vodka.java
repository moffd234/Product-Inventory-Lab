package models;

public class Vodka {
    private String brand;
    private int proof;
    private double price;
    private BottleSize bottleSize;
    private int quantity;
    private int id;


    public Vodka(String brand, int proof, BottleSize bottleSize, double price, int quantity, int id) {
        this.brand = brand;
        this.proof = proof;
        this.bottleSize = bottleSize;
        this.price = price;
        this.quantity = quantity;
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getProof() {
        return proof;
    }

    public void setProof(int proof) {
        this.proof = proof;
    }

    public BottleSize getBottleSize() {
        return bottleSize;
    }

    public void setBottleSize(BottleSize bottleSize) {
        this.bottleSize = bottleSize;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Mostly used for testing so far
    @Override
    public String toString() {
        return "Vodka: \n" +
                "id: " + id + "\n" +
                "   - brand=" + brand + "\n" +
                "   - proof=" + proof + "\n" +
                "   - price=" + price + "\n" +
                "   - bottleSize=" + bottleSize + "\n" +
                "   - quantity=" + quantity + "\n\n";
    }
}

