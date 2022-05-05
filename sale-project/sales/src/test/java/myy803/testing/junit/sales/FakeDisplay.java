package myy803.testing.junit.sales;

public class FakeDisplay implements Display {

	private String productDescriptionToBeDisplayed;
	
	@Override
	public void showLine(String productDescription) {
		productDescriptionToBeDisplayed = productDescription;
	}

	public String getProductDescriptionToBeDisplayed() {
		return productDescriptionToBeDisplayed;
	}
}
