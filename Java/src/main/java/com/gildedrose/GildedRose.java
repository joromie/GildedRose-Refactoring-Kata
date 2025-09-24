package com.gildedrose;

public class GildedRose {
    final UpdatableItem[] items;

    public GildedRose(Item[] items) {
        this.items = new UpdatableItem[items.length];
        for (int i = 0; i < items.length; i++) {
            this.items[i] = ItemFactory.create(items[i]);
        }
    }

    public void updateQuality() {
        for (UpdatableItem item : items) {
            item.update();
        }
    }
}
