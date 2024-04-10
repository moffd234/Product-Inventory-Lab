package services;

import models.BottleSize;
import models.Vodka;

import java.util.ArrayList;

public class VodkaService {
    private ArrayList<Vodka> inventory = new ArrayList<>();
    private int nextId = 1;

    public Vodka create(String brand, int proof, BottleSize bottleSize, double price, int quantity) {

        Vodka newVodka = new Vodka(brand, proof, bottleSize, price, quantity, nextId++);
        inventory.add(newVodka);

        return newVodka;
    }

    public Vodka create(String brand, int proof, BottleSize bottleSize, double price, int quantity, int id) {

        Vodka newVodka = new Vodka(brand, proof, bottleSize, price, quantity, id);
        inventory.set(id - 1, newVodka);

        return newVodka;
    }


    public boolean delete(int id) {
        for(Vodka vodka : inventory){
            if(vodka.getId() == id){
                inventory.remove(vodka);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Vodka> getInventory() {
        return inventory;
    }

    public Vodka find(int id) {
        for(Vodka vodka : inventory){
            if(vodka.getId() == id){
                return vodka;
            }
        }
        return null;
    }

    public Vodka[] findAll() {
        Vodka[] inv = new Vodka[inventory.size()];
        for (int i = 0; i < inventory.size(); i++) {
            inv[i] = inventory.get(i);
        }
        return inv;
    }

    // Mostly used for testing so far
    @Override
    public String toString() {
        return "{" + inventory +
                '}';
    }
}
