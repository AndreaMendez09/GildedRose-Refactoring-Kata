package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (!item.name.equals(TypesOfItemEnum.BRIE.name)
                    && !item.name.equals(TypesOfItemEnum.CONCERT.name)) {
                if (item.quality > 0 && (!item.name.equals(TypesOfItemEnum.SULFURAS.name))) {
                    item.quality = item.quality - 1;

                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                    if (item.name.equals(TypesOfItemEnum.CONCERT.name)) {
                        if (item.sellIn < 11 && (item.quality < 50)) {
                            item.quality = item.quality + 1;

                        }

                        if (item.sellIn < 6 && (item.quality < 50)) {
                            item.quality = item.quality + 1;

                        }
                    }
                }
            }

            if (!item.name.equals(TypesOfItemEnum.SULFURAS.name)) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!item.name.equals(TypesOfItemEnum.BRIE.name)) {
                    if (!item.name.equals(TypesOfItemEnum.CONCERT.name)) {
                        if (item.quality > 0 && (!item.name.equals(TypesOfItemEnum.SULFURAS.name))) {
                            item.quality = item.quality - 1;

                        }
                    } else {
                        item.quality = 0;
                    }
                } else {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }
    }
}
