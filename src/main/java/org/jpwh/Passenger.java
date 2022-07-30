/**
 * @author @Euraks 22.07.2022
 */
package org.jpwh;

import javax.persistence.*;

@Entity
public class Passenger {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    public Passenger() {
    }

    public Passenger(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
