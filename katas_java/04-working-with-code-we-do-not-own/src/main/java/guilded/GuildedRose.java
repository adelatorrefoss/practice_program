package guilded;

import items.Item;

import java.util.ArrayList;

public class GuildedRose {

    private Item item;
    private ArrayList<Item> items;

    public GuildedRose(Item item) {
        ArrayList<Item> items = new ArrayList<>();
        items.add(item);
        this.items = items;
    }

    public GuildedRose(ArrayList<Item> items) {

        this.items = items;
    }

    public void updatesInventory() {
        items.stream().forEach(item -> {
            item.sellIn -= 1;
            item.quality -= 1;
        });
    }
}
