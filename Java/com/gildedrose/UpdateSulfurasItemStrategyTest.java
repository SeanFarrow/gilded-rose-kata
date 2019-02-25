package com.gildedrose;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import org.junit.Test;


import static org.junit.Assert.*;

import org.junit.Test;

public class UpdateSulfurasItemStrategyTest {

	@Test
	public void noneOfTheItemsPropertiesAreChangedWhenTheItemIsUpdated() {
		String itemName ="Sulfuras, Hand of Ragnaros";
		int initialSellInValue =1;
		int initialQualityValue =1;
		var itemToUpdate =new Item(itemName, initialSellInValue, initialQualityValue);        
		var updatingItemStrategy =new UpdateSulfurasItemStrategy();
		//When.
		//Update the item.
		var updatedItem =updatingItemStrategy.updateItem(itemToUpdate); 
		//The item class does not have an equals method, so we need to use multiple asserts.		assertThat(itemName, is(equalTo(updatedItem.name)));
		assertThat(initialQualityValue, is(equalTo(updatedItem.quality)));
		assertThat(initialSellInValue , is(equalTo(updatedItem.sellIn)));
	}

}
