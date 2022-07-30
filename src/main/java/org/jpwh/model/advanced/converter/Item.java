package org.jpwh.model.advanced.converter;


import org.jpwh.converter.MonetaryAmountConverter;
import org.jpwh.model.advanced.MonetaryAmount;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Item {

    @Id
    @GeneratedValue(generator = "ID_GENERATOR")
    protected Long id;

    @NotNull
    protected String name;

    @NotNull
    @Convert( // Optional, autoApply is enabled
        converter = MonetaryAmountConverter.class,
        disableConversion = false)
    @Column(name = "PRICE", length = 63)
    protected MonetaryAmount buyNowPrice;

    @NotNull
    protected Date createdOn = new Date();

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MonetaryAmount getBuyNowPrice() {
        return buyNowPrice;
    }

    public void setBuyNowPrice(MonetaryAmount buyNowPrice) {
        this.buyNowPrice = buyNowPrice;
    }

    // ...
}
