package myy803.testing.junit.fixture_patterns;

import java.util.HashMap;
import java.util.Map;

class ProductCatalog {

    private Map<String, Double> prices = new HashMap<>();

    void loadSampleData() {
        // expensive "setup" in real systems: DB load / file parsing
        prices.put("P1", 10.0);
        prices.put("P2", 25.0);
        prices.put("P3", 100.0);
    }

    double getPrice(String productId) {
        if (!prices.containsKey(productId)) {
            throw new IllegalArgumentException("Unknown product");
        }
        return prices.get(productId);
    }

    int size() {
        return prices.size();
    }
}
