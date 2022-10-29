package org.mvnsearch.demo.impl.infra;

import org.mvnsearch.demo.infra.CacheService;

import java.io.Serializable;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * cache service implementation
 *
 * @author linux_china
 */
public class CacheServiceImpl implements CacheService {
    private Map<String, Serializable> store = new ConcurrentHashMap<>();

    public void put(String key, Serializable object) {
        store.put(key, object);
    }

    public Optional<Serializable> get(String key) {
        if (store.containsKey(key)) {
            return Optional.of(store.get(key));
        } else {
            return Optional.empty();
        }
    }
}
