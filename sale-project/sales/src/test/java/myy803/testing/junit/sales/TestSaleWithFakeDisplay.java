package myy803.testing.junit.sales;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TestSaleWithFakeDisplay {

	@Test
	void testThatScanShowsProductDescriptionInFakeDisplay() {
		FakeDisplay fakeDisplay = new FakeDisplay();
		Sale sale = new Sale(fakeDisplay);
		
		sale.scan("10110011000000111111");
		Assertions.assertEquals("Some product description ....", 
				fakeDisplay.getProductDescriptionToBeDisplayed());
	}

}
