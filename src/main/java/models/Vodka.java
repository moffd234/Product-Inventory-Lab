package models;

public class Vodka {
    private String brand;
    private int proof;
    private BottleSize bottleSize;
}

enum BottleSize{
    pint(.375),
    fifth(.750),
    liter(1),
    handle(1.75);

    private final double liters;

    BottleSize(double liters) {
        this.liters = liters;
    }

    public double getLiters() {
        return liters;
    }
}