package com.gildedrose;

public class UpdateConjuredItemStrategy  implements UpdateItemStrategy {

	@Override
	public Item updateItem(Item itemToUpdate) {
        int newQuality = itemShouldStillBeSold(itemToUpdate) ? itemToUpdate.quality -2 : itemToUpdate.quality -4;

        if(isQualityNegative(newQuality)) {
            newQuality = 0;
        }

        return new Item(itemToUpdate.name, itemToUpdate.sellIn - 1, newQuality);
    }

    private boolean isQualityNegative(int newQuality) {
        return newQuality < 0;
    }

    private boolean itemShouldStillBeSold(Item item) {
        return item.sellIn > -1;
    }
}
