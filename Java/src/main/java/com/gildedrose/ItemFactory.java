package com.gildedrose;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

class ItemFactory {
    private static final Map<String, Function<Item, UpdatableItem>> registry = new HashMap<>();

    static {
        registry.put("Aged Brie", AgedBrieItem::new);
        registry.put("Backstage passes to a TAFKAL80ETC concert", BackstagePassItem::new);
        registry.put("Sulfuras, Hand of Ragnaros", SulfurasItem::new);
    }

    public static UpdatableItem create(Item item) {
        return registry.getOrDefault(item.name, NormalItem::new).apply(item);
    }
}
