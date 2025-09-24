package com.gildedrose;

class NormalItem extends UpdatableItem {
    NormalItem(Item item) {
        super(item);
    }

    @Override
    public void update() {
        decreaseQuality();
        decreaseSellIn();

        if (isExpired()) {
            decreaseQuality();
        }
    }
}
