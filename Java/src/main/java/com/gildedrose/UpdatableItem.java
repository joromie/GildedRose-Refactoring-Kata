package com.gildedrose;

abstract class UpdatableItem {
    protected final Item item;

    protected UpdatableItem(Item item) {
        this.item = item;
    }

    public abstract void update();

    protected void increaseQuality() {
        if (item.quality < 50) {
            item.quality++;
        }
    }

    protected void decreaseQuality() {
        if (item.quality > 0) {
            item.quality--;
        }
    }

    public Item getItem() {
        return item;
    }
}
