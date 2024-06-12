package models;

public enum BottleSize{
    PINT(.375),
    FIFTH(.750),
    LITER(1),
    HANDLE(1.75);

    private final double liters;

    BottleSize(double liters) {
        this.liters = liters;
    }

    public double getLiters() {
        return liters;
    }
}