import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class ListShoppingCartTest {

	@Test
	public void shouldCalculateTotalPriceAndReturnIt() {
		Apple ap = new Apple("Apple1","opa",2.5);
		Chocolate a = new Chocolate("al","opa",2.5);
		
		List<Item> ls = new LinkedList<>();
		ls.add(a);
		ls.add(ap);
		ListShoppingCart cart = new ListShoppingCart(ls);
		
		assertEquals(5.0, cart.getTotal(),0.1);
	}

}
