package com.gildedrose;

abstract class UpdatableItem {
    protected final Item item;

    protected UpdatableItem(Item item) {
        this.item = item;
    }

    public abstract void update();

    // Quality
    protected void increaseQuality() {
        if (item.quality < 50) item.quality++;
    }

    protected void decreaseQuality() {
        if (item.quality > 0) item.quality--;
    }

    protected void decreaseQuality(int amount) {
        for (int i = 0; i < amount; i++) decreaseQuality();
    }

    // Sell in
    protected void decreaseSellIn() {
        item.sellIn--;
    }

    protected boolean isExpired() {
        return item.sellIn < 0;
    }


    protected void resetQuality() {
        item.quality = 0;
    }



    public Item getItem() {
        return item;
    }
}
