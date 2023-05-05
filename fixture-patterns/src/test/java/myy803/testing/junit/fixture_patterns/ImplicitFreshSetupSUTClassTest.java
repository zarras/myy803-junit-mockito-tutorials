package myy803.testing.junit.fixture_patterns;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import myy803.testing.junit.fixture_patterns.DOCClass;
import myy803.testing.junit.fixture_patterns.SUTClass;

class ImplicitFreshSetupSUTClassTest {
	
	private DOCClass docObject;
	private SUTClass sutObject;

	@BeforeEach
	private void delegatedFreshSetup() {
		docObject = new DOCClass("property_value");
		sutObject = new SUTClass(0.05, docObject);
	}
	
	@Test
	void testDoWorkReturnsConcatenatedProperty() {
		String result = sutObject.doWork("_postfix");
		
		Assertions.assertEquals("property_value_postfix", result);
	}
	
	@Test
	void testDoMoreWork() {		
		double result = sutObject.doMoreWork(0.024);
		
		Assertions.assertEquals(0.0012, result, 0.00005);
	}
}
