package org.jpwh.model.advanced;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Embeddable
public class Address {

    @NotNull
    @Column(nullable = false)
    protected String street;

    @Embedded
    @NotNull
    @AttributeOverrides(
        @AttributeOverride(
            name = "name",
            column = @Column(name = "CITY", nullable = false)
        )
    )
    protected City city;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    // ...
}