package myy803.testing.junit.basic_xunit_patterns;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SUTClassTest {

	@Test
	void testConstructor() {
		SUTClass sutObject = new SUTClass();
		
		Assertions.assertNull(sutObject.getSProperty());
		Assertions.assertEquals(0.0, sutObject.getDProperty());
	}
	
	@Test
	void testParameterizedConstructor() {
		SUTClass sutObject = new SUTClass("property_value", 0.05);
		
		Assertions.assertEquals("property_value", sutObject.getSProperty());
		Assertions.assertEquals(0.05, sutObject.getDProperty());
	}
	
	@Test
	void testDoWorkReturnsConcatenatedProperty() {
		SUTClass sutObject = new SUTClass("property_value", 0.03);
		
		String result = sutObject.doWork("_postfix");
		
		Assertions.assertEquals("property_value_postfix", result);	
	}
	
	@Test
	void testDoWorkThrowsException() {
		SUTClass sutObject = new SUTClass("property_value", 0.05);
		
		Assertions.assertThrows(NullPointerException.class, () -> {
			sutObject.doWork(null);
		});
	}

	@Test
	void testDoMoreWork() {
		SUTClass sutObject = new SUTClass("property_value", 0.03);
		
		// Fuzzy assertion
		double result = sutObject.doMoreWork(0.024);
		Assertions.assertEquals(0.0007, result, 0.00002);
	}
}
