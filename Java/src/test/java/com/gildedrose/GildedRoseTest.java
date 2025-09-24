package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    private Item updateOneDay(Item item) {
        Item[] items = new Item[] { item };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        return app.items[0].getItem();
    }

    @Test
    void normalItemDegradesAfterOneDay() {
        Item item = updateOneDay(new Item("foo", 5, 10));

        assertEquals(4, item.sellIn);
        assertEquals(9, item.quality);
    }

    @Test
    void normalItemDegradesTwiceAsFastAfterSellDate() {
        Item item = updateOneDay(new Item("foo", 0, 10));

        assertEquals(-1, item.sellIn);
        assertEquals(8, item.quality);
    }

    @Test
    void normalItemQualityNeverGoesBelowZero() {
        Item item = updateOneDay(new Item("foo", 5, 0));

        assertEquals(0, item.quality);
    }

    @Test
    void agedBrieIncreasesInQuality() {
        Item item = updateOneDay(new Item("Aged Brie", 5, 10));

        assertEquals(4, item.sellIn);
        assertEquals(11, item.quality);
    }

    @Test
    void agedBrieQualityCappedAt50() {
        Item item = updateOneDay(new Item("Aged Brie", 5, 50));

        assertEquals(50, item.quality);
    }

    @Test
    void sulfurasNeverChanges() {
        Item item = updateOneDay(new Item("Sulfuras, Hand of Ragnaros", 5, 80));

        assertEquals(5, item.sellIn);
        assertEquals(80, item.quality);
    }

    @Test
    void backstagePassesIncreaseBy1WhenMoreThan10Days() {
        Item item = updateOneDay(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));

        assertEquals(14, item.sellIn);
        assertEquals(21, item.quality);
    }

    @Test
    void backstagePassesIncreaseBy2When10DaysOrLess() {
        Item item = updateOneDay(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20));

        assertEquals(9, item.sellIn);
        assertEquals(22, item.quality);
    }

    @Test
    void backstagePassesIncreaseBy3When5DaysOrLess() {
        Item item = updateOneDay(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20));

        assertEquals(4, item.sellIn);
        assertEquals(23, item.quality);
    }

    @Test
    void backstagePassesDropToZeroAfterConcert() {
        Item item = updateOneDay(new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20));

        assertEquals(-1, item.sellIn);
        assertEquals(0, item.quality);
    }
}
