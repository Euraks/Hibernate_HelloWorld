package org.jpwh.model.associations.onetomany.bidirectional;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    protected String name;

    @OneToMany // The default
    protected Set<Bid> bids = new HashSet<>();

    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Bid> getBids() {
        return bids;
    }

    public void setBids(Set<Bid> bids) {
        this.bids = bids;
    }
    // ...
}
