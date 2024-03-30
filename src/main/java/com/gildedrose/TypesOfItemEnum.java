package com.gildedrose;

public enum TypesOfItemEnum {
    SULFURAS("Sulfuras, Hand of Ragnaros"),
    BRIE("Aged Brie"),
    CONCERT("Backstage passes to a TAFKAL80ETC concert");

    public final String name;

    private TypesOfItemEnum(String name) {
        this.name = name;
    }

}
