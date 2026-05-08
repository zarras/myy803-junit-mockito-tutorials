package myy803.testing.junit.fixture_patterns;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DelegatedFreshSetupTaxpayer {

	// -------------------------
	// 🧪 Tests
	// -------------------------

	@Test
	void baseTaxCalculation() {
		Taxpayer t = createTaxpayer("John", 30000, 0, false, "Athens");

		assertEquals(6000, t.calculateTax());
	}

	@Test
	void childrenReduceTax() {
		Taxpayer t = createTaxpayer("Anna", 30000, 2, false, "Athens");

		// 6000 * 0.9 = 5400
		assertEquals(5400, t.calculateTax());
	}

	@Test
	void marriageReducesTax() {
		Taxpayer t = createTaxpayer("Bob", 30000, 0, true, "Athens");

		// 6000 * 0.8 = 4800
		assertEquals(4800, t.calculateTax());
	}

	@Test
	void bothDiscountsApply() {
		Taxpayer t = createTaxpayer("Maria", 30000, 2, true, "Thessaloniki");

		// 6000 * 0.9 * 0.8 = 4320
		assertEquals(4320, t.calculateTax());
	}

	@Test
	void constructorRejectsNegativeIncome() {
		assertThrows(IllegalArgumentException.class, () ->
		createTaxpayer("John", -100, 0, false, "Athens")
				);
	}

	// -------------------------
	// 🔁 Parameterized helper
	// -------------------------
	private Taxpayer createTaxpayer(
			String name,
			double income,
			int children,
			boolean married,
			String city
			) {
		Address address = new Address(city, "Street", 10);
		return new Taxpayer(name, income, children, married, address);
	}
}
