package myy803.testing.junit.verification_patterns;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {

    @Test
    void calculateTotalReturnsCorrectSum() {
        ShoppingCart cart = new ShoppingCart();

        cart.addItem(10);
        cart.addItem(20);
        cart.addItem(5);

        // RESULT verification (pure function-style check)
        assertEquals(35, cart.calculateTotal());
    }

    @Test
    void calculateTotalOnEmptyCartIsZero() {
        ShoppingCart cart = new ShoppingCart();

        assertEquals(0, cart.calculateTotal());
    }

    @Test
    void checkoutChangesStateToCheckedOut() {
        ShoppingCart cart = new ShoppingCart();

        cart.addItem(10);
        cart.addItem(20);

        cart.checkout();

        // STATE verification
        assertTrue(cart.isCheckedOut());
    }

    @Test
    void checkoutWithEmptyCartThrowsException() {
        ShoppingCart cart = new ShoppingCart();

        assertThrows(IllegalStateException.class, () -> {
            cart.checkout();
        });
    }

    @Test
    void addingItemsAffectsInternalState() {
        ShoppingCart cart = new ShoppingCart();

        cart.addItem(10);
        cart.addItem(20);

        // STATE verification
        assertEquals(2, cart.getItemCount());
    }
}