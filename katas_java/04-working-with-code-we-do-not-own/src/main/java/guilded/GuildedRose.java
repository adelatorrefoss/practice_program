package guilded;

import items.Item;

public class GuildedRose {

    private final Item item;

    public GuildedRose(Item item) {
        this.item = item;
    }

    public void updatesInventory() {
        item.sellIn -= 1;
        item.quality -= 1;
    }
}
