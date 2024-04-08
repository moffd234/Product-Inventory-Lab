package services;

import models.BottleSize;
import models.Vodka;

import java.util.ArrayList;

public class VodkaService {
    private ArrayList<Vodka> inventory = new ArrayList<>();
    private static int nextId = 1;

    public Vodka create(String brand, int proof, BottleSize bottleSize, double price, int quantity) {

        Vodka newVodka = new Vodka(brand, proof, bottleSize, price, quantity, nextId);
        inventory.add(newVodka);

        return newVodka;
    }
}
