package myy803.testing.junit.fixture_patterns;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ImplicitSharedProductCatalogTest {

    private static ProductCatalog catalog;

    // 🔁 created once (expensive setup)
    @BeforeAll
    static void setUp() {
        catalog = new ProductCatalog();
        catalog.loadSampleData();
    }

    @Test
    void productP1HasCorrectPrice() {
        assertEquals(10.0, catalog.getPrice("P1"));
    }

    @Test
    void productP2HasCorrectPrice() {
        assertEquals(25.0, catalog.getPrice("P2"));
    }

    @Test
    void catalogContainsThreeProducts() {
        assertEquals(3, catalog.size());
    }

    @Test
    void unknownProductThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            catalog.getPrice("P999");
        });
    }
}