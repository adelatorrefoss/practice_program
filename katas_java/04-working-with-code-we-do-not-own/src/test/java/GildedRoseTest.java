import guilded.GildedRose;
import items.Item;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class GildedRoseTest {

    @Test
    public void decrease_item_value() {
        Item item = new Item("name", 1, 1);
        GildedRose store = new GildedRose(item);

        store.updatesInventory();

        Item newExpectedItem = new Item("name", 0, 0);

        assertItemAreEquals(item, newExpectedItem);
    }

    @Test
    public void decrease_all_items_in_store() {
        Item apple = new Item("apple", 1, 1);
        Item orange = new Item("orange", 5, 20);


        ArrayList<Item> items = new ArrayList<>();
        items.add(apple);
        items.add(orange);
        GildedRose store = new GildedRose(items);

        store.updatesInventory();

        Item updatedApple = new Item("apple", 0, 0);
        assertItemAreEquals(apple, updatedApple);

        Item updatedOrange = new Item("orange", 4, 19);
        assertItemAreEquals(orange, updatedOrange);
    }

    private void assertItemAreEquals(Item actual, Item expected) {
        assertThat(actual.name, is(expected.name));
        assertThat(actual.quality, is(expected.quality));
        assertThat(actual.sellIn, is (expected.sellIn));
    }


}


// date has passed, quality degrades twice as fast
//