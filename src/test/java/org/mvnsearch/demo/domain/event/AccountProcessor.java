package org.mvnsearch.demo.domain.event;

import org.springframework.context.event.EventListener;

/**
 * account processor
 *
 * @author linux_china
 */
public interface AccountProcessor {

    @EventListener
    public void handleLogin(LoginEvent event) ;
}
