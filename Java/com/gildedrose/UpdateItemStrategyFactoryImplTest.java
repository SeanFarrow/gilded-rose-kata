package com.gildedrose;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test; 

public class UpdateItemStrategyFactoryImplTest {

	@Test
	public void FindUpdateStrategyForItemReturnsAnUpdateConjuredItemStrategyWhenTheItemNameIsConjuredManaCake() {
		String itemName ="Conjured Mana Cake";
		int initialSellInValue =-2;
		int initialQualityValue =1;
		var itemToUpdate =new Item(itemName, initialSellInValue, initialQualityValue);        
 var factory =new UpdateItemStrategyFactoryImpl();
	var itemUpdateStrategy =factory.FindUpdateStrategyForItem(itemToUpdate);	
	assertThat(itemUpdateStrategy, is(instanceOf(UpdateConjuredItemStrategy.class)));
	}

}
