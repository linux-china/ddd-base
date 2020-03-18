package org.mvnsearch.demo.domain.model;

import org.mvnsearch.ddd.domain.BaseDomainAggregate;

import java.util.List;

/**
 * Order: aggregate
 *
 * @author linux_china
 */
public class Order implements BaseDomainAggregate<Long> {
    private Long id;
    private List<OrderLineItem> items;
    private Account buyer;

    @Override
    public Long getId() {
        return null;
    }

    public List<OrderLineItem> getItems() {
        return items;
    }

    public void setItems(List<OrderLineItem> items) {
        this.items = items;
    }

    public Account getBuyer() {
        return buyer;
    }

    public void setBuyer(Account buyer) {
        this.buyer = buyer;
    }
}
