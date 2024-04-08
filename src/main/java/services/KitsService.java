package services;

import models.Kit;
import models.KitSize;

import java.util.ArrayList;

public class KitsService {
    private ArrayList<Kit> kitsInventory = new ArrayList<>();
    private static int nextId = 1;

    public Kit create(int kitNum, int quantity, double price, String team,
                      String brand, String player, KitSize kitSize){
        Kit createdKit = new Kit(++nextId, kitNum, quantity, price, team, brand, player, kitSize);
        kitsInventory.add(createdKit);
        return createdKit;
    }
}
