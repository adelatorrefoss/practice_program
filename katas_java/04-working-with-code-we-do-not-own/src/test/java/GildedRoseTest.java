import guilded.GildedRose;
import items.Item;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class GildedRoseTest {

    @Test
    public void decrease_item_value() {
        Item item = createAnItem("name", 1, 1);
        GildedRose store = new GildedRose(item);

        store.updatesInventory();

        Item newExpectedItem = createAnItem("name", 0, 0);

        assertItemAreEquals(item, newExpectedItem);
    }

    @Test
    public void decrease_all_items_in_store() {
        Item apple = createAnItem("apple", 1, 1);
        Item orange = createAnItem("orange", 5, 20);

        GildedRose store = new GildedRose(asList(apple, orange));

        store.updatesInventory();

        Item updatedApple = createAnItem("apple", 0, 0);
        assertItemAreEquals(apple, updatedApple);

        Item updatedOrange = createAnItem("orange", 4, 19);
        assertItemAreEquals(orange, updatedOrange);
    }

    private Item createAnItem(String name, int sellIn, int quality) {
        return new Item(name, sellIn, quality);
    }

    private void assertItemAreEquals(Item actual, Item expected) {
        assertThat(actual.name, is(expected.name));
        assertThat(actual.quality, is(expected.quality));
        assertThat(actual.sellIn, is(expected.sellIn));
    }


}


// date has passed, quality degrades twice as fast
//