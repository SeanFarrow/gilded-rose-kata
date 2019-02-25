package com.gildedrose;

public class UpdateItemStrategyFactoryImpl  implements UpdateItemStrategyFactory {
	@Override
	public UpdateItemStrategy FindUpdateStrategyForItem(Item updatingItem) {
		if (updatingItem.name.equals("Conjured Mana Cake")) {
			return new UpdateConjuredItemStrategy();
		} else if (updatingItem.name.equals("Sulfuras, Hand of Ragnaros")) {  
return new UpdateSulfurasItemStrategy(); 
		} else
			return null;		
	}
}