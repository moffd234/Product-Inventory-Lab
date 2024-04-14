package services;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import models.BottleSize;
import models.Kit;
import models.Vodka;
import utils.CSVUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
                shiftIdsBack(id);
                nextId -= 1;
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

    private void shiftIdsBack(int id) {
        for (Vodka vodka : inventory) {
            if(vodka.getId() > id) {
                vodka.setId(vodka.getId() - 1);
            }
        }
    }

    public void writeToCSV() throws IOException {
        String csvFile = "/Users/dan/Dev/Zipcode/Week 5/Product-Inventory-Lab/Vodka.csv";
        FileWriter writer = new FileWriter(csvFile);

        CSVUtils.writeLine(writer, new ArrayList<>(Arrays.asList(String.valueOf(nextId))));  // (2)

        for (Vodka v : inventory) {
            List<String> list = new ArrayList<>(); // (3)
            list.add(String.valueOf(v.getBrand()));
            list.add(String.valueOf(v.getProof()));
            list.add(String.valueOf(v.getBottleSize()));
            list.add(String.valueOf(v.getPrice()));
            list.add(String.valueOf(v.getQuantity()));
            CSVUtils.writeLine(writer, list);  // (4)
        }

        // (5)
        writer.flush();
        writer.close();
    }

    public void writeToJSON() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        writer.writeValue(new File("vodka.json"), inventory);
    }

    // Mostly used for testing so far
    @Override
    public String toString() {
        return "{" + inventory + '}';
    }
}
