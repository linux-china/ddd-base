package org.mvnsearch.demo.domain.application;

import org.mvnsearch.ddd.application.annotations.ApplicationService;
import org.mvnsearch.demo.domain.model.Account;

/**
 *  account manager
 *
 * @author linux_china
 */
@ApplicationService
public interface ApplicationManager {

    public Account findByEmail(String email);
}
