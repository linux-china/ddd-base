package org.mvnsearch.demo.infrastructure;

import org.mvnsearch.ddd.infrastructure.annotations.InfrastructureService;

import java.io.Serializable;
import java.util.Optional;

/**
 * cache service
 *
 * @author linux_china
 */
@InfrastructureService
public interface CacheService {

    void put(String key, Serializable object);

    Optional<Serializable> get(String key);
}
