package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item updatingItem : items) {
        	if (!updatingItem.name.equals("Aged Brie")
                    && !updatingItem.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (updatingItem.quality > 0) {
                    if (!updatingItem.name.equals("Sulfuras, Hand of Ragnaros")) {
                        updatingItem.quality = updatingItem.quality - 1;
                    }
                }
            } else {
                if (updatingItem.quality < 50) {
                    updatingItem.quality = updatingItem.quality + 1;

                    if (updatingItem.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (updatingItem.sellIn < 11) {
                            if (updatingItem.quality < 50) {
                                updatingItem.quality = updatingItem.quality + 1;
                            }
                        }

                        if (updatingItem.sellIn < 6) {
                            if (updatingItem.quality < 50) {
                                updatingItem.quality = updatingItem.quality + 1;
                            }
                        }
                    }
                }
            }

            if (!updatingItem.name.equals("Sulfuras, Hand of Ragnaros")) {
                updatingItem.sellIn = updatingItem.sellIn - 1;
            }

            if (updatingItem.sellIn < 0) {
                if (!updatingItem.name.equals("Aged Brie")) {
                    if (!updatingItem.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (updatingItem.quality > 0) {
                            if (!updatingItem.name.equals("Sulfuras, Hand of Ragnaros")) {
                                updatingItem.quality = updatingItem.quality - 1;
                            }
                        }
                    } else {
                        updatingItem.quality = updatingItem.quality - updatingItem.quality;
                    }
                } else {
                    if (updatingItem.quality < 50) {
                        updatingItem.quality = updatingItem.quality + 1;
                    }
                }
            }
        }
    }
}
