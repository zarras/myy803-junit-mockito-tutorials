package myy803.testing.junit.test_double_patterns;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import myy803.testing.junit.test_double_patterns.DOCClass;
import myy803.testing.junit.test_double_patterns.SUTClass;

class SUTClassTest {
	
	@Test
	void testDoWorkReturnsConcatenatedPropertyWithMock() {
		DOCClass mockDocObject = Mockito.mock(DOCClass.class);
		Mockito.when(mockDocObject.getSProperty()).thenReturn("property_value");
		
		SUTClass sutObject = new SUTClass(0.05, mockDocObject);
		
		String result = sutObject.doWork("_postfix");
		
		Assertions.assertEquals("property_value_postfix", result);
		Mockito.verify(mockDocObject).getSProperty();
	}
	
	@Test
	void testDoWorkReturnsConcatenatedPropertyWithSpy() {
		DOCClass docObject = new DOCClass("property_value");		
		DOCClass spyDocObject = Mockito.spy(docObject);
		SUTClass sutObject = new SUTClass(0.05, spyDocObject);

		String result = sutObject.doWork("_postfix");
		
		Assertions.assertEquals("property_value_postfix", result);		
		Mockito.verify(spyDocObject).getSProperty();
	}
	
}
