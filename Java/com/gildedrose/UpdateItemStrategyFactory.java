package com.gildedrose;

public interface UpdateItemStrategyFactory {
	public UpdateItemStrategy FindUpdateStrategyForItem(Item updatingItem);
}
