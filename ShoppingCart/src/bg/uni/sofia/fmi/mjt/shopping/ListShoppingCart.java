package bg.uni.sofia.fmi.mjt.shopping;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ListShoppingCart implements ShopppingCart{
	private LinkedList<Item> items;
	

	public ListShoppingCart() {
		this.items = new LinkedList<Item>();
	}
	
	public ListShoppingCart(List<Item> items2) {
		items = (LinkedList<Item>) items2;
	}

	@Override
	public Collection<Item> getUniqueItems() {
		Set<Item> itemSet = new HashSet<Item>();
		for(Item i : items) {
			itemSet.add(i);
		}
		return itemSet;
	}

	@Override
	public Collection<Item> getSortedItems() {
		Map<Item, Integer> sorted = new HashMap<>();
		for (Item  item : items) {
			if (!sorted.containsKey(item)) {
				sorted.put(item, 1);
			} else {
				sorted.put(item, sorted.get(item) + 1);
			}
		}
		List<Map.Entry<Item, Integer>> list = new LinkedList<>(sorted.entrySet());
	    Collections.sort( list, new Comparator<Map.Entry<Item, Integer>>() {
	        @Override
	        public int compare(Map.Entry<Item, Integer> o1, Map.Entry<Item, Integer> o2) {
	            return (o2.getValue()).compareTo(o1.getValue());
	        }
	    });

	    List<Item> sortedList= new LinkedList<>();
	    for(Map.Entry<Item, Integer> entry: list) {
	    	sortedList.add(entry.getKey());
	    }
	   return sortedList;
	}

	@Override
	public void addItem(Item item) {
		if(item==null) {
			return;
		}
		this.items.add(item);
		
	}

	@Override
	public void removeItem(Item item) throws ItemNotFoundException {
		if(!this.items.contains(item)) {
			throw new ItemNotFoundException();
		}
		this.items.remove(item);
		
	}


	@Override
	public double getTotal() {
		int total = 0;
		for(Item im:this.items) {
			total+=im.getPrice();
		}
		return total;
	}
}