
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ListShoppingCart implements ShoppingCart{

	private List<Item> items;
	
	public ListShoppingCart(List<Item> items) {
		this.items = items;
	}

	@Override
	public Collection<Item> getUniqueItems() {
		Set<Item> uniques = new HashSet<>(this.items);
		return uniques;
	}

	@Override
	public Collection<Item> getSortedItems() {
		Map<Item,Integer> entries = new HashMap<>();
		for(Item i : items) {
			if(!entries.containsKey(i)) {
				entries.put(i, 1);
			}
			else {
				entries.replace(i,entries.get(i),entries.get(i)+1);
			}
		}
		
		List<Item> ls = new LinkedList<>(entries.keySet());
		ls.sort(new Comparator<Item>() {

			@Override
			public int compare(Item o1, Item o2) {
				return entries.get(o1).compareTo(entries.get(o2));
			}
		});
		return ls;
	}

	@Override
	public void addItem(Item item) {
		if(item!=null) {
			if(items.contains(item)) {
				items.add(item);
			}
		}
	}

	@Override
	public void removeItem(Item item) throws ItemNotFoundException {
		if(!items.contains(item)) {
			throw new ItemNotFoundException();
		}
		items.remove(item);
	}

	@Override
	public double getTotal() {
		double total = 0;
		for(Item i:items) {
			total += i.getPrice();
		}
		return total;
	}

}
