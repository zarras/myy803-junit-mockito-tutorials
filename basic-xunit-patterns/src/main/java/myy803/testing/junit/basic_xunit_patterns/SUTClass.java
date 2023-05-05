package myy803.testing.junit.basic_xunit_patterns;

public class SUTClass {
	
	private String sProperty;
	private double dProperty;
	
	public SUTClass() {
	}
	
	public SUTClass(String sProperty, double dProperty) {
		this.sProperty = sProperty;
		this.dProperty = dProperty;
	}

	public String getSProperty() {
		return sProperty;
	}

	public double getDProperty() {
		return dProperty;
	}

	public String doWork(String input) throws NullPointerException {
		if(input != null)
			return sProperty = sProperty + input;
		else
			throw new NullPointerException("The input parameter was null");
	}
	
	public double doMoreWork(double factor) {
		return dProperty*factor;
	}
}
