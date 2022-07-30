package org.jpwh.model.associations.onetomany.bidirectional;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @ManyToOne() // Defaults to EAGER
    protected Item item;

    @NotNull
    protected BigDecimal amount;

    public Bid() {
    }

    public Bid(BigDecimal amount, Item item) {
        this.amount = amount;
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    // ...
}
