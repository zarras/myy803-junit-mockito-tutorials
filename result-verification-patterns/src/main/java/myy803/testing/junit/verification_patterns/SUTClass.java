package myy803.testing.junit.verification_patterns;

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
	
	@Override
	public boolean equals(Object sutObject) {
		if(sutObject.getClass() == SUTClass.class)
			if(this.dProperty == ((SUTClass)sutObject).dProperty && this.docObject.equals(((SUTClass)sutObject).docObject))	
				return true;
		
		return false;
	}
	
	public String doWork(String input) {
		return docObject.getSProperty() + input;
	}
	
	public void doMoreWork(double factor) {
		dProperty = dProperty * factor;
	}
}
