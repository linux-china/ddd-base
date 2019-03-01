package org.mvnsearch.demo.application;

import org.mvnsearch.ddd.application.annotations.ApplicationService;
import org.mvnsearch.demo.domain.model.Account;

/**
 * account facade
 *
 * @author linux_china
 */
@ApplicationService
public interface AccountFacade {

    Account findByEmail(String email);

}
