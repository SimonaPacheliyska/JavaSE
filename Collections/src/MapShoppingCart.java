import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MapShoppingCart implements ShoppingCart{

	private Map<Item,Integer> items;
	
	public MapShoppingCart() {
		this.items = new HashMap<>();
	}
	
	public MapShoppingCart(Map<Item,Integer> items) {
		this.items = items;
	}
	
	
	@Override
	public Collection<Item> getUniqueItems() {
		return items.keySet();
	}

	@Override
	public Collection<Item> getSortedItems() {
		List<Item> ls = new ArrayList<>(items.keySet());
		ls.sort(new Comparator<Item>() {

			@Override
			public int compare(Item o1, Item o2) {
				return items.get(o1).compareTo(items.get(o2));
			}
		});
		return ls;
		
		
	}

	@Override
	public void addItem(Item item) {
		if(item != null) {
			if(this.items.containsKey(item)) {
				this.items.replace(item, items.get(item), items.get(item)+1);
				return;
			}
			this.items.put(item,1);
		}
	}

	@Override
	public void removeItem(Item item) throws ItemNotFoundException {
		if(!items.containsKey(item)) {
			throw new ItemNotFoundException();
		}
		if(items.get(item)==1) {
			items.remove(item);
			return;
		}
		this.items.replace(item, this.items.get(item), this.items.get(item)-1);
	}

	@Override
	public double getTotal() {
		double price = 0;
		for(Item i : items.keySet()) {
			price += i.getPrice();
		}
		return price;
	}
	
	public static void main(String[] args) {
		Apple ap = new Apple("Apple1","opa",2.5);
		Chocolate a = new Chocolate("al","opa",2.5);
		
		List<Item> ls = new LinkedList<>();
		ls.add(a);
		ls.add(ap);
		ListShoppingCart cart = new ListShoppingCart(ls);
		
		System.out.println(cart.getTotal());
	}
}
		