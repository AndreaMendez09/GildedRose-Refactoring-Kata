package com.gildedrose;

class GildedRose {
    Item[] items;

    private static final int MAX_QUALITY = 50;
    private static final int MIN_QUALITY = 0;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch (item.name) {
                case "Aged Brie":
                    decreaseSellIn(item);
                    calculateQualityAgedBrie(item);
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    decreaseSellIn(item);
                    calculateQualityBackstage(item);
                    break;
                case "Sulfuras, Hand of Ragnaros":
                    break;
                default:
                    decreaseSellIn(item);
                    decreaseQuality(item);
                    if (item.sellIn < 0 && item.quality > 0) {
                        decreaseQuality(item);
                    }
                    break;
            }
        }
    }

    private void calculateQualityAgedBrie(Item item) {
        if (item.quality < 50) {
            increaseQuality(item);
        }
        if (item.quality < 50 && item.sellIn < 0) {
            increaseQuality(item);
        }
    }

    private void calculateQualityBackstage(Item item) {
        if (item.quality < 50) {
            increaseQuality(item);
        }
        if (item.sellIn < 10 && (item.quality < 50)) {
            increaseQuality(item);
        }

        if (item.sellIn < 5 && (item.quality < 50)) {
            increaseQuality(item);
        }
        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }


    private void decreaseSellIn(Item item) {
        item.sellIn -= 1;
    }

    private void increaseQuality(Item item) {
        if (item.quality < MAX_QUALITY) {
            item.quality += 1;
        }
    }

    private void decreaseQuality(Item item) {
        if (item.quality > MIN_QUALITY) {
            item.quality -= 1;
        }
    }
}
