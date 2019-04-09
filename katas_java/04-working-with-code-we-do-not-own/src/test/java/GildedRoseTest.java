import guilded.GuildedRose;
import items.Item;
import org.junit.Test;

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


}
