package services;

import models.Kit;
import models.KitSize;

import java.util.ArrayList;

public class KitsService {
    private ArrayList<Kit> kitsInventory = new ArrayList<>();
    private int nextId = 1;

    public Kit create(int kitNum, int quantity, double price, String team,
                      String brand, String player, KitSize kitSize){
        Kit createdKit = new Kit(nextId++, kitNum, quantity, price, team, brand, player, kitSize);
        kitsInventory.add(createdKit);
        return createdKit;
    }

    public ArrayList<Kit> getKitsInventory() {
        return kitsInventory;
    }

    public boolean delete(int id) {
        for(Kit kit: kitsInventory){
            if(kit.getId() == id){
                kitsInventory.remove(kit);
                return true;
            }
        }
        return false;
    }

    public Kit find(int id) {
        for(Kit kit : kitsInventory){
            if(kit.getId() == id){
                return kit;
            }
        }
        return null;
    }

    public Kit[] findAll() {
        Kit[] kits = new Kit[kitsInventory.size()];
        for(int i = 0; i < kitsInventory.size(); i++){
            kits[i] = kitsInventory.get(i);
        }
        return kits;
    }

    @Override
    public String toString() {
        return "" + kitsInventory;
    }
}
