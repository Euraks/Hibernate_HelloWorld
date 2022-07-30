package org.jpwh.model.cache;

import org.jpwh.model.Constants;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "USERS")
@Cacheable
@org.hibernate.annotations.Cache(
    usage = org.hibernate.annotations
             .CacheConcurrencyStrategy.NONSTRICT_READ_WRITE,
    region = "org.jpwh.model.cache.User" // Default name
)
@org.hibernate.annotations.NaturalIdCache
public class User {

    @Id
    @GeneratedValue(generator = Constants.ID_GENERATOR)
    protected Long id;


    @NotNull // Ignored for schema generation because of @NaturalId
    @org.hibernate.annotations.NaturalId(mutable = true) // Makes it UNIQUE
    @Column(nullable = false) // For schema generation
    protected String username;

    protected User() {
    }

    public User(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // ...
}
