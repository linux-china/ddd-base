package org.mvnsearch.demo.infrastructure.impl.domain.event;

import org.mvnsearch.demo.domain.event.AccountEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * account processor implementation
 *
 * @author linux_china
 */
@Component
public class AccountEventProcessor  {

    @EventListener(AccountEvent.class)
    public void handleAccountCreate(AccountEvent accountEvent) {

    }
}
