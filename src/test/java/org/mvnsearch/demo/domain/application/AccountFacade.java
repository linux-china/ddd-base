package org.mvnsearch.demo.domain.application;

import org.mvnsearch.ddd.application.annotations.ApplicationService;
import org.mvnsearch.ddd.application.annotations.RemoteFacade;
import org.mvnsearch.demo.domain.model.Account;

/**
 * account facade
 *
 * @author linux_china
 */
@ApplicationService
@RemoteFacade
public interface AccountFacade {

    Account findByEmail(String email);

}
