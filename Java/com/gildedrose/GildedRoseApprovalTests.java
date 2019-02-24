package com.gildedrose;

import org.junit.Test;
import org.approvaltests.combinations.CombinationApprovals;
import org.approvaltests.reporters.UseReporter;
import org.approvaltests.reporters.JunitReporter;

@UseReporter(JunitReporter.class)
public class GildedRoseApprovalTests {

    @Test
    public void testUpdateQuality()  throws Exception { 
    String[] availableItemNames = new String[] {
	"+5 Dexterity Vest",
	"Aged Brie",
	"Elixir of the Mongoose",
	"Sulfuras, Hand of Ragnaros",
	"Backstage passes to a TAFKAL80ETC concert",
	"Conjured Mana Cake"
    };
    
    Integer[] availableSellInValues = new Integer[] {0, 12, -1, 6, 2};
    Integer[] availableQualityValues = new Integer[] {0, 3, 51, 49};

    CombinationApprovals.verifyAllCombinations(this::doUpdateQuality, availableItemNames, availableSellInValues, availableQualityValues);
}

private Item doUpdateQuality(String itemName, int initialSellInValue, int initialQualityValue) {
    //GIVEN
Item[] items = new Item[]{new Item(itemName, initialSellInValue, initialQualityValue)};        
GildedRose app = new GildedRose(items);   
//When.
//Update the item.
app.updateQuality();
return items[0];
}
}