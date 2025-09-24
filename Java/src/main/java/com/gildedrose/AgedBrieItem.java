package com.gildedrose;

class AgedBrieItem extends UpdatableItem {
    AgedBrieItem(Item item) {
        super(item);
    }

    @Override
    public void update() {
        increaseQuality();
        decreaseSellIn();

        if (isExpired()) {
            increaseQuality();
        }
    }
}
