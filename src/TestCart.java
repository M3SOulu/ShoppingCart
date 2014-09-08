import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TestCart {
	ShoppingCart cart;
	Item it;
	
	
	@Before
	public void setup(){
		this.cart = new ShoppingCart();
		this.it = new Item("Pizza", 9.90);
	}
	
	@Test
	public void testAddItemRetrieveByCount() {
		//Arrange
		//ShoppingCart cart = new ShoppingCart();
		//Item it = new Item("Pizza", 9.90);
		it.setName("Pizza");
		it.setPrice(9.90);
		//Act
		cart.addItem(it);
		//Assert
		assertEquals(1, cart.totalItems());
	}
	
	@Test
	public void testAddItemRetrieveByIndex() throws IndexOutOfCartException {
		//Arrange
		//ShoppingCart cart = new ShoppingCart();
		//Item it = new Item("Pizza", 9.90);
	
		//Act
		cart.addItem(it);
		
		//Assert
		Item expected = cart.pickItem(0);
		assertEquals("Pizza", expected.getName());
		assertEquals(9.90, expected.getPrice(), 0);
	}
	
	@Test(expected=IndexOutOfCartException.class)
	public void testPickItemZeroIndexOutOfCart() throws IndexOutOfCartException{
		//Arrage
		//ShoppingCart cart = new ShoppingCart();
		//Item it = new Item("Pizza", 9.90);
		//Act
		cart.pickItem(0);
	}
	
	@Test(expected=IndexOutOfCartException.class)
	public void testPickItemBigIndexOutOfCart() throws IndexOutOfCartException{
		//Arrage
		//ShoppingCart cart = new ShoppingCart();
		//Item it = new Item("Pizza", 9.90);
		cart.addItem(it);
		//Act
		cart.pickItem(100);
	}
	
	@Test
	public void testRemoveItem()  {
		//Arrage
		//ShoppingCart cart = new ShoppingCart();
		//Item it = new Item("Pizza", 9.90);
		cart.addItem(it);
		//Act
		cart.removeItem(0);
		//Assert
		assertEquals(0, cart.totalItems());
	}

	@Test
	public void testTotalPrice(){
		//Arrange
		Item ball = new Item("Ball", 9.98);
		cart.addItem(ball);
		cart.addItem(it);
		//Act
		Double expected = 9.90 + 9.98;
		Double actual = cart.totalPrice();
		
		//Assert
		assertEquals(expected, actual);
	}

}
