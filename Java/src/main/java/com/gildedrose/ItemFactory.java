package com.gildedrose;

class ItemFactory {
    public static UpdatableItem create(Item item) {
        return switch (item.name) {
            case "Aged Brie" -> new AgedBrieItem(item);
            case "Backstage passes to a TAFKAL80ETC concert" -> new BackstagePassItem(item);
            case "Sulfuras, Hand of Ragnaros" -> new SulfurasItem(item);
            default -> new NormalItem(item);
        };
    }
}
