package myy803.testing.junit.fixture_patterns;

class Address {
    private String city;
    private String street;
    private int zip;

    Address(String city, String street, int zip) {
        this.city = city;
        this.street = street;
        this.zip = zip;
    }

    String getCity() {
        return city;
    }
}
