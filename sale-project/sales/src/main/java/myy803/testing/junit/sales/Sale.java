package myy803.testing.junit.sales;

public class Sale {
	private Display display;
	
	
	public Sale(Display display) {
		super();
		this.display = display;
	}

	public void scan(String barcode) {
		/*
		 * Method that derives product description 
		 * from barcode
		 */
		String productDescription = deriveProductDescription(barcode);
	
		display.showLine(productDescription);
	}

	private String deriveProductDescription(String barcode) {
		/*
		 *  Code that derives product description 
		 * from barcode
		 */
		return "Some product description ....";
	}
}
