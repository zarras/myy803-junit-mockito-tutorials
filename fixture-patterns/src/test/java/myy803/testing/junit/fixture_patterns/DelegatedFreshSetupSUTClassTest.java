package myy803.testing.junit.fixture_patterns;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import myy803.testing.junit.fixture_patterns.DOCClass;
import myy803.testing.junit.fixture_patterns.SUTClass;

class DelegatedFreshSetupSUTClassTest {
	
	@Test
	void testDoWorkReturnsInputValue() {
		DOCClass docObject = new DOCClass("");
		SUTClass sutObject = new SUTClass(0.05, docObject);
		
		String result = sutObject.doWork("_postfix");
		
		Assertions.assertEquals("_postfix", result);
	}
	
	@Test
	void testDoWorkReturnsConcatenatedProperty() {
		SUTClass sutObject = delegatedFreshSetup();
		
		String result = sutObject.doWork("_postfix");
		
		Assertions.assertEquals("property_value_postfix", result);
	}
	
	@Test
	void testDoMoreWork() {
		SUTClass sutObject = delegatedFreshSetup();
		
		double result = sutObject.doMoreWork(0.024);
		Assertions.assertEquals(0.0012, result, 0.00005);
	}
	
	private SUTClass delegatedFreshSetup() {
		DOCClass docObject = new DOCClass("property_value");
		SUTClass sutObject = new SUTClass(0.05, docObject);
		return sutObject;
	}
}
