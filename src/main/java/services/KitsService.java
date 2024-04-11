package services;

import models.Kit;
import models.KitSize;
import utils.CSVUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KitsService {
    private ArrayList<Kit> kitsInventory = new ArrayList<>();
    private int nextId = 1;

    public Kit create(int kitNum, int quantity, double price, String team,
                      String brand, String player, KitSize kitSize){
        Kit createdKit = new Kit(nextId++, kitNum, quantity, price, team, brand, player, kitSize);
        kitsInventory.add(createdKit);
        return createdKit;
    }
    public Kit create(int kitNum, int quantity, double price, String team,
                      String brand, String player, KitSize kitSize, int id){
        Kit createdKit = new Kit(id, kitNum, quantity, price, team, brand, player, kitSize);
        kitsInventory.set(id - 1, createdKit);
        return createdKit;
    }

    public ArrayList<Kit> getKitsInventory() {
        return kitsInventory;
    }

    public boolean delete(int id) {
        for(Kit kit: kitsInventory){
            if(kit.getId() == id){
                kitsInventory.remove(kit);
                shiftIdsBack(id);
                nextId -= 1;
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
    private void shiftIdsBack(int id) {
        for (Kit kit : kitsInventory) {
            if(kit.getId() > id) {
                kit.setId(kit.getId() - 1);
            }
        }
    }
    @Override
    public String toString() {
        return "" + kitsInventory;
    }

    public void writeToCSV() throws IOException {
        String csvFile = "/Users/dan/Dev/Zipcode/Week 5/Product-Inventory-Lab/Kits.csv";
        FileWriter writer = new FileWriter(csvFile);

        CSVUtils.writeLine(writer, new ArrayList<>(Arrays.asList(String.valueOf(nextId))));  // (2)

        for (Kit k : kitsInventory) {
            List<String> list = new ArrayList<>(); // (3)
            list.add(String.valueOf(k.getId()));
            list.add(String.valueOf(k.getKitNum()));
            list.add(String.valueOf(k.getQuantity()));
            list.add(String.valueOf(k.getPrice()));
            list.add(k.getTeam());
            list.add(k.getBrand());
            list.add(k.getPlayer());
            list.add(String.valueOf(k.getSize()));
            CSVUtils.writeLine(writer, list);  // (4)
        }

        // (5)
        writer.flush();
        writer.close();
    }
}
