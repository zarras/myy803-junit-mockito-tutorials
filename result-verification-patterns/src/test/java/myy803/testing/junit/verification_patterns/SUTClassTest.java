package myy803.testing.junit.verification_patterns;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import myy803.testing.junit.verification_patterns.DOCClass;
import myy803.testing.junit.verification_patterns.SUTClass;

class SUTClassTest {
	
	@Test
	void testDoWorkReturnsConcatenatedProperty() {
		DOCClass docObject = new DOCClass("property_value");
		SUTClass sutObject = new SUTClass(0.05, docObject);
		
		String result = sutObject.doWork("_postfix");
		
		Assertions.assertEquals("property_value_postfix", result);
	}
	
	@Test
	void testStateAfterDoMoreWork_Procedural() {
		DOCClass docObject = new DOCClass("property_value");
		SUTClass sutObject = new SUTClass(10.5, docObject);
		
		sutObject.doMoreWork(2);
		
		Assertions.assertEquals(21, sutObject.getdProperty());
	}
	
	@Test
	void testStateAfterDoMoreWork_ExpectedState() {
		DOCClass docObject = new DOCClass("property_value");
		SUTClass sutObject = new SUTClass(10.5, docObject);
		SUTClass expectedObject = new SUTClass(21, docObject);
		
		sutObject.doMoreWork(2);
		
		Assertions.assertTrue(expectedObject.equals(sutObject));
	}
	
	@Test
	void testBehaviorAfterDoWork() {
		DOCClass docObject = new DOCClass("property_value");		
		DOCClass spyDocObject = Mockito.spy(docObject);
		SUTClass sutObject = new SUTClass(0.05, spyDocObject);

		sutObject.doWork("_postfix");
		
		Mockito.verify(spyDocObject).getSProperty();
	}
	
}
