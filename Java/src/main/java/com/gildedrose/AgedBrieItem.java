package com.gildedrose;

class AgedBrieItem extends UpdatableItem {
    AgedBrieItem(Item item) {
        super(item);
    }

    @Override
    public void update() {
        increaseQuality();
        item.sellIn--;

        if (item.sellIn < 0) {
            increaseQuality();
        }
    }
}
