import guilded.GuildedRose;
import items.Item;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class GildedRoseTest {

    @Test
    public void decrease_item_value() {
        Item item = new Item("name", 1, 1);
        GuildedRose store = new GuildedRose(item);

        store.updatesInventory();

        assertThat(item.name, is("name"));
        assertThat(item.quality, is(0));
        assertThat(item.sellIn, is (0));
    }

    @Test
    public void decrease_all_items_in_store() {
        Item apple = new Item("apple", 1, 1);
        Item orange = new Item("orange", 5, 20);


        ArrayList<Item> items = new ArrayList<>();
        items.add(apple);
        items.add(orange);
        GuildedRose store = new GuildedRose(items);

        store.updatesInventory();

        assertThat(apple.name, is("apple"));
        assertThat(apple.quality, is(0));
        assertThat(apple.sellIn, is (0));

        assertThat(orange.name, is("orange"));
        assertThat(orange.quality, is(19));
        assertThat(orange.sellIn, is (4));
    }


}


// 2 items


// date has passed, quality degrades twice as fast
//