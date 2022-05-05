package myy803.testing.junit.sales;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TestSaleWithMockito {
	
	@Mock
	Display fakeDisplay;
	
	@InjectMocks
	Sale sale;

	@Test
	void testThatScanCallsMockDisplayWithProductDescription() {
		// instead of the mock annotations on the above attributes could use the following code
		//Display fakeDisplay = Mockito.mock(Display.class);
		//Sale sale = new Sale(fakeDisplay);
		
		sale.scan("10110011000000111111");
		Mockito.verify(fakeDisplay).showLine("Some product description ....");
	}
}
