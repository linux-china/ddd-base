package org.mvnsearch.demo.domain.infrastructure;

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

    public void put(String key, Serializable object);

    public Optional<Serializable> get(String key);
}
