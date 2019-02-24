package com.gildedrose;

class GildedRose {
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
		else { 
		codeNeedingRefactoring(updatingItem);
	}
	}

	private void updateBackStage(Item updatingItem) {
		if (updatingItem.quality < 50) {
		    updatingItem.quality = updatingItem.quality + 1;

		        if (updatingItem.sellIn < 11) {
		            if (updatingItem.quality < 50) {
		                updatingItem.quality = updatingItem.quality + 1;
		            }
		        }

		        if (updatingItem.sellIn < 6) {
		            if (updatingItem.quality < 50) {
		                updatingItem.quality = updatingItem.quality + 1;
		            }
		        }
		    }
		
		updatingItem.sellIn = updatingItem.sellIn - 1;

if (updatingItem.sellIn < 0) {
			    updatingItem.quality = updatingItem.quality - updatingItem.quality;
		    }
	}

	private void updateAgedBrie(Item updatingItem) {
		if (updatingItem.quality < 50) {
		    updatingItem.quality = updatingItem.quality + 1;
		}
		    		
		updatingItem.sellIn = updatingItem.sellIn - 1;

if (updatingItem.sellIn < 0) {
		    if (updatingItem.quality < 50) {
		        //Update the quality again if the sell-in has passed and the quality isn't greater than 50.
		    	updatingItem.quality = updatingItem.quality + 1;
		    }
		}
	}
	
	private void codeNeedingRefactoring(Item updatingItem) {
			if (updatingItem.quality > 0) {
		        if (!updatingItem.name.equals("Sulfuras, Hand of Ragnaros")) {
		            updatingItem.quality = updatingItem.quality - 1;
		        }
		    }
			
		if (!updatingItem.name.equals("Sulfuras, Hand of Ragnaros")) {
		    updatingItem.sellIn = updatingItem.sellIn - 1;
		}

		if (updatingItem.sellIn < 0) {
		            if (updatingItem.quality > 0) {
		                if (!updatingItem.name.equals("Sulfuras, Hand of Ragnaros")) {
		                    updatingItem.quality = updatingItem.quality - 1;
		                }
		            }
		        }
		}
	}