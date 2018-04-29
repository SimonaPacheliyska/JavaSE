package bg.uni.sofia.fmi.mjt.shopping;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class MapShoppingCart implements ShopppingCart{
	private Map<Item, Integer> items;
	
	public MapShoppingCart() {
		this.items = new HashMap<>();
	}

	@Override
	public Collection<Item> getUniqueItems() {
		return items.keySet();
	}

	@Override
	public Collection<Item> getSortedItems() {
		List<Item> it = new LinkedList<>(this.items.keySet());
	    Collections.sort( it, new Comparator<Item>(){
	        @Override
	        public int compare(Item o1, Item o2) {
	        	Integer iO1 = items.get(o1);
	        	Integer iO2 = items.get(o2);
	            return (iO1.compareTo(iO2));
	        }
	    });
		return it;
	}

	@Override
	public void addItem(Item item) {
		if(item==null) {
			return;
		}
		if(this.items.containsKey(item)) {
			this.items.replace(item, items.get(item), items.get(item)+1);
			return;
		}
		this.items.put(item, 1);
	}

	@Override
	public void removeItem(Item item) throws ItemNotFoundException {
		if(!this.items.containsKey(item)) {
			throw new ItemNotFoundException();
		}
		if(this.items.get(item)>1) {
			this.items.replace(item, items.get(item), items.get(item)-1);
		}
		else{
			this.items.remove(item);
		}
	}

	@Override
	public double getTotal() {
		double total = 0;
		for(Item i : items.keySet()) {
			total+= i.getPrice()*this.items.get(i);
		}
		return total;
	}
}
