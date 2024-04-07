package models;

public class Vodka {
    private String brand;
    private int proof;
    private BottleSize bottleSize;

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
}

