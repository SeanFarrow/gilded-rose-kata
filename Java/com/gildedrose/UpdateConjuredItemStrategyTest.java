package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class UpdateConjuredItemStrategyTest {

	@Test
	public void AConjuredItemsSellInValueDecreasesBy1WhenTheItemIsUpdated() {
		String itemName ="Conjured Mana Cake";
		int initialSellInValue =1;
		int initialQualityValue =1;
		int expectedItemSellIn =0;
		var itemToUpdate =new Item(itemName, initialSellInValue, initialQualityValue);        
		var updatingItemStrategy =new UpdateConjuredItemStrategy();
		//When.
		//Update the item.
		var updatedItem =updatingItemStrategy.updateItem(itemToUpdate); 
assertEquals(expectedItemSellIn, updatedItem.sellIn);
	}
	@Test
	public void AConjuredItemsQualityValueDecreasesBy2WhenTheSellInValueIsPositive() {
		String itemName ="Conjured Mana Cake";
		int initialSellInValue =1;
		int initialQualityValue =3;
		int expectedItemQuality =1;
		var itemToUpdate =new Item(itemName, initialSellInValue, initialQualityValue);        
		var updatingItemStrategy =new UpdateConjuredItemStrategy();
		//When.
		//Update the item.
		var updatedItem =updatingItemStrategy.updateItem(itemToUpdate); 
assertEquals(expectedItemQuality, updatedItem.quality);
	}

	@Test
	public void AConjuredItemsQualityValueDecreasesBy4WhenTheSellInValueIsNegative() {
		String itemName ="Conjured Mana Cake";
		int initialSellInValue =-2;
		int initialQualityValue =5;
		int expectedItemQuality =1;
		var itemToUpdate =new Item(itemName, initialSellInValue, initialQualityValue);        
		var updatingItemStrategy =new UpdateConjuredItemStrategy();
		//When.
		//Update the item.
		var updatedItem =updatingItemStrategy.updateItem(itemToUpdate); 
assertEquals(expectedItemQuality, updatedItem.quality);
	}
	@Test
	public void AConjuredItemsQualityValueCanNeverBeNegative() {
		String itemName ="Conjured Mana Cake";
		int initialSellInValue =-2;
		int initialQualityValue =1;
		int expectedItemQuality =0;
		var itemToUpdate =new Item(itemName, initialSellInValue, initialQualityValue);        
		var updatingItemStrategy =new UpdateConjuredItemStrategy();
		//When.
		//Update the item.
		var updatedItem =updatingItemStrategy.updateItem(itemToUpdate); 
assertEquals(expectedItemQuality, updatedItem.quality);
	}
}