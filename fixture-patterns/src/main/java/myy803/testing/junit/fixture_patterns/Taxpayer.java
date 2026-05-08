package myy803.testing.junit.fixture_patterns;

class Taxpayer {
	private String name;
    private double income;
    private int children;
    private boolean married;
    private Address address;

    Taxpayer(String name, double income, int children, boolean married, Address address) {
        if (income < 0) throw new IllegalArgumentException("Income cannot be negative");

        this.name = name;
        this.income = income;
        this.children = children;
        this.married = married;
        this.address = address;
    }
    
    public void setChildren(int children) {
		this.children = children;
	}

	public void setMarried(boolean married) {
		this.married = married;
	}

    double calculateTax() {
        double tax = income * 0.2;

        if (children > 0) tax *= 0.9;
        if (married) tax *= 0.8;

        return tax;
    }
}