package org.mvnsearch.demo.domain.specification;

import java.util.Optional;

/**
 * account specification
 *
 * @author linux_china
 */
public interface AccountSpec {

    public Optional<Long> isEmailUnique(String email);
}
