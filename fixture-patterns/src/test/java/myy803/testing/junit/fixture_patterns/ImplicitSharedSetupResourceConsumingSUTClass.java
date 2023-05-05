package myy803.testing.junit.fixture_patterns;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ImplicitSharedSetupResourceConsumingSUTClass {

	private static ResourceConsumingSUTClass resourceConsumingSUTObject;
	
	@BeforeAll
	private static void setupSharedFixture() {
		resourceConsumingSUTObject = new ResourceConsumingSUTClass();
	}
	
	@Test
	public void testDoWork() {
		Assertions.assertDoesNotThrow(
			() -> {resourceConsumingSUTObject.doWork("....");});
	}
	
	@Test
	public void testDoMoreWork() {
		Assertions.assertDoesNotThrow(
			() -> {resourceConsumingSUTObject.doMoreWork("....");});
	}
	
}
