package guilded;

import items.Item;

import java.util.ArrayList;

public class GildedRose {

    private ArrayList<Item> items;

    public GildedRose(Item item) {
        ArrayList<Item> items = new ArrayList<>();
        items.add(item);
        this.items = items;
    }

    public GildedRose(ArrayList<Item> items) {

        this.items = items;
    }

    public void updatesInventory() {
        items.forEach(item -> {
            item.sellIn -= 1;
            item.quality -= 1;
        });
    }
}
