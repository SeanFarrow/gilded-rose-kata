package com.gildedrose;

import org.junit.Test;
import org.approvaltests.Approvals;
import org.approvaltests.reporters.UseReporter;
import org.approvaltests.reporters.JunitReporter;

@UseReporter(JunitReporter.class)
public class GildedRoseApprovalTests {

    @Test
    public void testUpdateQuality() {
        Item expectedItem =new Item("foo", -1, 0);
    	Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Approvals.verify(expectedItem);
    }

}
