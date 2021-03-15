package org.mvnsearch.demo.infrastructure.impl.domain.specification;

import org.mvnsearch.demo.domain.specification.AccountSpec;

import java.util.Optional;

/**
 * account sepecification implementation
 *
 * @author linux_china
 */
public class AccountSpecImpl implements AccountSpec {

    public Optional<Long> isEmailUnique(String email) {
        return null;
    }
}
