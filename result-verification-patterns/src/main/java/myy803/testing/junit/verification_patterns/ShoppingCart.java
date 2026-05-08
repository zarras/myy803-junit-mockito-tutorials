package myy803.testing.junit.verification_patterns;

import java.util.ArrayList;
import java.util.List;

class ShoppingCart {

    private List<Double> items = new ArrayList<>();
    private boolean checkedOut = false;

    // STATE: changes object state
    void addItem(double price) {
        if (checkedOut) {
            throw new IllegalStateException("Cart already checked out");
        }
        items.add(price);
    }

    // RESULT: computes and returns value
    double calculateTotal() {
        double sum = 0;
        for (double price : items) {
            sum += price;
        }
        return sum;
    }

    // STATE: changes object state
    void checkout() {
        if (items.isEmpty()) {
            throw new IllegalStateException("Cart is empty");
        }
        checkedOut = true;
    }

    boolean isCheckedOut() {
        return checkedOut;
    }

    int getItemCount() {
        return items.size();
    }
}
