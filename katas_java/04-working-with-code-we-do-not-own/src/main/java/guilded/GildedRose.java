package guilded;

import items.Item;

import java.util.ArrayList;
import java.util.List;

public class GildedRose {

    private List<Item> items;

    public GildedRose(Item item) {
        List<Item> items = new ArrayList<>();
        items.add(item);
        this.items = items;
    }

    public GildedRose(List<Item> items) {
        this.items = items;
    }

    public void updatesInventory() {
        items.forEach(this::updateItem);
    }

    private void updateItem(Item item) {
        decreaseSellIn(item);

        decreaseQualityByOne(item);
        if (hasExpired(item)) {
            decreaseQualityByOne(item);
        }
    }

    private void decreaseQualityByOne(Item item) {
        if (item.quality > 0) {
            item.quality -= 1;
        }
    }

    private void decreaseSellIn(Item item) {
        item.sellIn -= 1;
    }

    private boolean hasExpired(Item item) {
        return item.sellIn < 0;
    }
}
