package com.gildedrose;

public class UpdateItemStrategyFactoryImpl  implements UpdateItemStrategyFactory {
	@Override
	public UpdateItemStrategy FindUpdateStrategyForItem(Item updatingItem) {
		return updatingItem.name.equals("Conjured Mana Cake") ? new UpdateConjuredItemStrategy() : null;		
	}
}