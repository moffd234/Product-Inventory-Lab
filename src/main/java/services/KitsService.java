package services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import models.Kit;
import models.KitSize;
import utils.CSVUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KitsService {
    private ArrayList<Kit> kitsInventory = new ArrayList<>();
    private int nextId = 1;

    public KitsService(){
        loadCSVData();
    }


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

        CSVUtils.writeLine(writer, new ArrayList<>(Arrays.asList(String.valueOf(nextId))));

        for (Kit k : kitsInventory) {
            List<String> list = new ArrayList<>();
            list.add(String.valueOf(k.getId()));
            list.add(String.valueOf(k.getKitNum()));
            list.add(String.valueOf(k.getQuantity()));
            list.add(String.valueOf(k.getPrice()));
            list.add(k.getTeam());
            list.add(k.getBrand());
            list.add(k.getPlayer());
            list.add(String.valueOf(k.getSize()));
            CSVUtils.writeLine(writer, list);
        }

        writer.flush();
        writer.close();
    }
    private void loadCSVData(){
        // (1)
        String csvFile = "/Users/dan/Dev/Zipcode/Week 5/Product-Inventory-Lab/Kits.csv";
        String line = "";
        String csvSplitBy = ",";

        // (2)
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            nextId = Integer.parseInt(br.readLine());  // (3)

            while ((line = br.readLine()) != null) {
                // split line with comma
                String[] beer = line.split(csvSplitBy);

                // (4)
                int id = Integer.parseInt(beer[0]);
                int kitNum = Integer.parseInt(beer[1]);
                int qty = Integer.parseInt(beer[2]);
                double price = Double.parseDouble(beer[3]);
                String team = beer[4];
                String brand = beer[5];
                String player = beer[6];
                KitSize size = KitSize.valueOf(beer[7]);


                // (5)
                kitsInventory.add(new Kit(id, kitNum, qty, price, team, brand, player, size));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadJSONData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        this.kitsInventory = objectMapper.readValue(
                new File("kits.json"), new TypeReference<ArrayList<Kit>>(){});

    }

    public void writeJSONData() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        writer.writeValue(new File("kits.json"), kitsInventory);
    }
}
