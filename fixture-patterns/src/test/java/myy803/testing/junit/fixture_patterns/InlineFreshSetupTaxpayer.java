package myy803.testing.junit.fixture_patterns;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InlineFreshSetupTaxpayer {

	@Test
    void constructorThrowsForNegativeIncome() {
        assertThrows(IllegalArgumentException.class, () ->
                new Taxpayer(
                        "John",
                        -100,
                        0,
                        false,
                        new Address("Athens", "Ermou", 10)
                )
        );
    }
	
    @Test
    void calculatesTaxWithoutDiscounts() {
        Taxpayer t = new Taxpayer(
                "John",
                30000,
                0,
                false,
                new Address("Athens", "Ermou", 10)
        );

        assertEquals(6000, t.calculateTax());
    }

    @Test
    void appliesChildrenDiscount() {
        Taxpayer t = new Taxpayer(
                "Anna",
                30000,
                2,
                false,
                new Address("Athens", "Ermou", 10)
        );

        // 30000 * 0.2 = 6000
        // children discount: 6000 * 0.9 = 5400
        assertEquals(5400, t.calculateTax());
    }

    @Test
    void appliesMarriageDiscount() {
        Taxpayer t = new Taxpayer(
                "Bob",
                30000,
                0,
                true,
                new Address("Athens", "Ermou", 10)
        );

        // 6000 * 0.8 = 4800
        assertEquals(4800, t.calculateTax());
    }

    @Test
    void appliesBothChildrenAndMarriageDiscounts() {
        Taxpayer t = new Taxpayer(
                "Maria",
                30000,
                2,
                true,
                new Address("Thessaloniki", "Tsimiski", 54624)
        );

        // 6000 * 0.9 = 5400
        // 5400 * 0.8 = 4320
        assertEquals(4320, t.calculateTax());
    }
}
