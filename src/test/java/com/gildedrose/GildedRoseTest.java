package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void quality_and_sellIn_decreased_on_item() {
        Item[] items = new Item[]{new Item("Bread", 5, 10)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(4, app.items[0].sellIn);
        assertEquals(9, app.items[0].quality);
    }

    @Test
    void quality_of_item_is_never_negative() {
        Item[] items = new Item[]{new Item("Bread", 5, 0)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertTrue(app.items[0].quality >= 0);
    }

    @Test
    void quality_of_item_is_never_more_then_50() {
        Item[] items = new Item[]{new Item("Aged Brie", 5, 50)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(50, app.items[0].quality);
        assertTrue(app.items[0].quality <= 50);
    }

    @Test
    void aged_brie_increased_queality_the_older_it_gets() {
        Item[] items = new Item[]{new Item("Aged Brie", 5, 20)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(4, app.items[0].sellIn);
        assertEquals(21, app.items[0].quality);
    }

    @Test
    void sulfuras_never_changes_queality_or_sellIn() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 15, 80)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(15, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void backstage_when_sellin_more_than_10_quality_increased_by_1() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 15, 24)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(14, app.items[0].sellIn);
        assertEquals(25, app.items[0].quality);
    }

    @Test
    void backstage_when_sellin_less_than_10_quality_increased_by_2() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 9, 24)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(8, app.items[0].sellIn);
        assertEquals(26, app.items[0].quality);
    }

    @Test
    void backstage_when_sellin_less_than_5_quality_increased_by_3() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 5, 24)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(4, app.items[0].sellIn);
        assertEquals(27, app.items[0].quality);
    }

    @Test
    void backstage_when_sellin_is_0_quality_drops_to_0() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 0, 24)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(-1, app.items[0].sellIn); //TODO this is correct?
        assertEquals(0, app.items[0].quality);
    }


}
