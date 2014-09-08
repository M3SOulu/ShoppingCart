import static org.junit.Assert.*;

import org.junit.Test;


public class TestItem {

	@Test
	public void testSetName() {
		//Arrange step
		Item it = new Item();
		//Act step
		it.setName("Pizza");
		//Assert
		assertNotNull(it);
		assertEquals("Pizza", it.getName());
		
	}

}
