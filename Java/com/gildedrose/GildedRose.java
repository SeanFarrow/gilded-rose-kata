package com.gildedrose;

class GildedRose {
    //Maximum and minimum allowable quality values.
	private static final int MINIMUM_QUALITY =0;
	private static final int MAXIMUM_QUALITY =50;

	Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item updatingItem : items) {
        	UpdateValuesForAnIndividualItem(updatingItem);
        }
    }

	private void UpdateValuesForAnIndividualItem(Item updatingItem) {
		var updateItemStrategyFactory =new UpdateItemStrategyFactoryImpl();
		var itemUpdater =updateItemStrategyFactory .FindUpdateStrategyForItem(updatingItem);
		if (itemUpdater  ==null)
		{ //Use the old code for now.
			updateTheItemUsingTheOldCode(updatingItem);
		}
		else {
			//Use the newly written item update strategies.
		itemUpdater.updateItem(updatingItem);	
		}
	}

	private void updateTheItemUsingTheOldCode(Item updatingItem) {
		if (updatingItem.name.equals("Aged Brie")) 
{//start aged brie.
		updateAgedBrie(updatingItem); 
}//end aged brie. 
else if (updatingItem.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
		//start backstage.
   updateBackStage(updatingItem); 
//end backstage.
} else  { 
//Update all standard items. 
		updateStandardItems(updatingItem);
}
	}
	
	private void updateAgedBrie(Item updatingItem) {
		if (isSellInPassed(updatingItem)) {
			incrementItemQualityBy(updatingItem, 2); //Increment the quality by 2 if the sellin has passed.
		}
		else {
			incrementItemQualityBy(updatingItem, 1);
		}
		
		decrementItemSellInBy(updatingItem, 1);

		if (isTheItemsQualityGreaterThanTheMaximumQualityAllowed(updatingItem))
{
	setTheItemsQualityToTheMaximumQualityAllowed(updatingItem);
}
	}
	
	private void updateBackStage(Item updatingItem) {
		if (isSellInPassed(updatingItem)) {
		    setTheItemQualityToTheMinimumQualityAllowed(updatingItem);
	    }
		else if (isSellInIn10DaysOrLess(updatingItem)) {
		            incrementItemQualityBy(updatingItem, 2);
		        }
		else if (isSellInIn5DaysOrLess(updatingItem)) {
		            incrementItemQualityBy(updatingItem, 3);
		        }
		else {
			incrementItemQualityBy(updatingItem, 1);
		}
			
		if (isTheItemsQualityGreaterThanTheMaximumQualityAllowed(updatingItem))
		{
			setTheItemsQualityToTheMaximumQualityAllowed(updatingItem);
		}

		decrementItemSellInBy(updatingItem, 1);
	}

											private void updateStandardItems(Item updatingItem) {
												if (isSellInPassed(updatingItem)) {
													decrementItemQualityBy(updatingItem, 2);
												}
												else
												{
													decrementItemQualityBy(updatingItem, 1);
												}
												
												if (isTheItemsQualityLessThanTheMinimumQualityAllowed(updatingItem)) {
													setTheItemQualityToTheMinimumQualityAllowed(updatingItem);
		        }
		    
		    decrementItemSellInBy(updatingItem, 1);
		        }
		
			//Helper functions for the quality.			
			private boolean isTheItemsQualityLessThanTheMinimumQualityAllowed(Item updatingItem) {
				return updatingItem.quality < MINIMUM_QUALITY;
			}
			
			private boolean isTheItemsQualityGreaterThanTheMaximumQualityAllowed(Item updatingItem)
			{
				return updatingItem.quality > MAXIMUM_QUALITY;
			}

			private boolean isTheItemsQualityGreaterThanTheMinimumQualityAllowed(Item updatingItem) {
				return updatingItem.quality > 0;
			}

				private void incrementItemQualityBy(Item updatingItem, int delta) {
				updatingItem.quality = updatingItem.quality + delta;
			}
			
			private void decrementItemQualityBy(Item updatingItem, int delta) {
				updatingItem.quality = updatingItem.quality - delta;
			}

			private void setTheItemQualityToTheMinimumQualityAllowed(Item updatingItem) {
				updatingItem.quality = MINIMUM_QUALITY;
			}
			
			private void setTheItemsQualityToTheMaximumQualityAllowed(Item updatingItem) {
				updatingItem.quality = MAXIMUM_QUALITY; 
			}

			//Helper functions for an items sellin.
			private boolean isSellInPassed(Item updatingItem) {
			return updatingItem.sellIn < 1;
		}
		
		private boolean isSellInIn10DaysOrLess(Item updatingItem) {
			return updatingItem.sellIn < 11;
		}

		private boolean isSellInIn5DaysOrLess(Item updatingItem) {
			return updatingItem.sellIn < 6;
		}
		
		private void decrementItemSellInBy(Item updatingItem, int delta) {
			updatingItem.sellIn = updatingItem.sellIn - delta;
		}
}