package myy803.testing.junit.basic_xunit_patterns;

class Grade {

    private int value;

    Grade(int initialValue) {
        this.value = initialValue;
    }

    int addBonus(int x) {
        return value + x;
    }

    int scaleDown(int x) {
        if (x == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return value / x;
    }
    
    int scaleUp(int x) {
        return value * x;
    }

    int getValue() {
        return value;
    }
}