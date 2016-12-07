package org.mvnsearch.demo.domain.factory;

import org.mvnsearch.ddd.domain.annotations.DomainFactory;
import org.mvnsearch.demo.domain.model.Account;

/**
 * account factory
 *
 * @author linux_china
 */
@DomainFactory
public interface AccountFactory {

    public Account createFromWechat(String wechatXml);
}
