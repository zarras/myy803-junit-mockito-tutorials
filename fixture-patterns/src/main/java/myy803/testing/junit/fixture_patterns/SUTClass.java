package myy803.testing.junit.fixture_patterns;

public class SUTClass {
	
	private double dProperty;
	private DOCClass docObject;
	
	public SUTClass() {}
	
	public SUTClass(double dProperty, DOCClass docObject) {
		this.dProperty = dProperty;
		this.docObject = docObject;
	}

	public double getdProperty() {
		return dProperty;
	}

	public DOCClass getDocObject() {
		return docObject;
	}
	
	public String doWork(String input) {
		return docObject.getSProperty() + input;
	}
	
	public double doMoreWork(double factor) {
		return dProperty*factor;
	}
}
