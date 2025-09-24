package com.gildedrose;

class NormalItem extends UpdatableItem {
    NormalItem(Item item) {
        super(item);
    }

    @Override
    public void update() {
        decreaseQuality();
        item.sellIn--;

        if (item.sellIn < 0) {
            decreaseQuality();
        }
    }
}
