import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import javafx.util.Pair;

public class MemoryCache<K, V> implements Cache<K,V> {

	private final long DEFAULT_CAPACITY = 10_000;
	@SuppressWarnings("unused")
	private Map<K, Pair<V, LocalDateTime>> pairs;
	private long capacity;
	
	
    public MemoryCache(long capacity) {
    	this.pairs = new HashMap<K,Pair<V, LocalDateTime>>();
    	this.capacity = capacity;
    }

    public MemoryCache() {
    	this.pairs = new HashMap<K,Pair<V, LocalDateTime>>();
    	this.capacity = DEFAULT_CAPACITY;
    }
	
	@Override
	public V get(K key) {
		return null;
	}

	@Override
	public void set(K key, V value, LocalDateTime expiresAt) throws CapacityExceededException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public LocalDateTime getExpiration(K key) {
		return null;
	}

	@Override
	public boolean remove(K key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getHitRate() {
		// TODO Auto-generated method stub
		return 0;
	}

}
