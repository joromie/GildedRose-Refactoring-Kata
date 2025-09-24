package com.gildedrose;

class BackstagePassItem extends UpdatableItem {
    BackstagePassItem(Item item) {
        super(item);
    }

    @Override
    public void update() {
        increaseQuality();

        if (item.sellIn < 11) {
            increaseQuality();
        }
        if (item.sellIn < 6) {
            increaseQuality();
        }

        item.sellIn--;

        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }
}
