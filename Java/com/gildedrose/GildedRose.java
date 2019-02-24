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
		if (updatingItem.name.equals("Aged Brie")) 
		{//start aged brie.
		    updateAgedBrie(updatingItem); 
		}//end aged brie. 
		else if (updatingItem.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
			//start backstage.
    updateBackStage(updatingItem); 
//end backstage.
		}
		else if (updatingItem.name.equals("Sulfuras, Hand of Ragnaros"))
		{// update Sulfuras, Hand of Ragnaros.
		//do nothing.
		}
			else  { 
//Update all standard items. 
			updateStandardItems(updatingItem);
	}
	}

	private void updateBackStage(Item updatingItem) {
		if (isTheItemsQualityLessThanTheMaximumQualityAllowed(updatingItem)) {
		    incrementItemQualityBy(updatingItem, 1);

		        if (isSellInIn10DaysOrLess(updatingItem)) {
		            if (isTheItemsQualityLessThanTheMaximumQualityAllowed(updatingItem)) {
		                incrementItemQualityBy(updatingItem, 1);
		            }
		        }

		        if (isSellInIn5DaysOrLess(updatingItem)) {
		            if (isTheItemsQualityLessThanTheMaximumQualityAllowed(updatingItem)) {
		                incrementItemQualityBy(updatingItem, 1);
		            }
		        }
		    }
		
		decrementItemSellInBy(updatingItem, 1);

if (isSellInPassed(updatingItem)) {
			    setTheItemQualityToTheMinimumQualityAllowed(updatingItem);
		    }
	}

								private void updateAgedBrie(Item updatingItem) {
		if (isTheItemsQualityLessThanTheMaximumQualityAllowed(updatingItem)) {
		    incrementItemQualityBy(updatingItem, 1);
		}
		    		
		decrementItemSellInBy(updatingItem, 1);

if (isSellInPassed(updatingItem)) {
		    if (isTheItemsQualityLessThanTheMaximumQualityAllowed(updatingItem)) {
		        incrementItemQualityBy(updatingItem, 1);
		    }
		}
	}
	
			private void updateStandardItems(Item updatingItem) {
			if (isTheItemsQualityGreaterThanTheMinimumQualityAllowed(updatingItem)) {
		            decrementItemQualityBy(updatingItem, 1);
		        }
		    
		    decrementItemSellInBy(updatingItem, 1);

		if (isSellInPassed(updatingItem)) {
		            if (isTheItemsQualityGreaterThanTheMinimumQualityAllowed(updatingItem)) {
		                    decrementItemQualityBy(updatingItem, 1);
		                }
		            }
		        }
		
			//Helper functions for the quality.			
			private boolean isTheItemsQualityLessThanTheMaximumQualityAllowed(Item updatingItem) {
				return updatingItem.quality < MAXIMUM_QUALITY;
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