/**
 * @author @Euraks 22.07.2022
 */
package org.jpwh;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Cars {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToMany
    private Set<Passenger> passengerSet;


    public Cars() {
    }

    public Cars(Set<Passenger> passengerSet) {
        this.passengerSet = passengerSet;
    }

    public Set<Passenger> getPassengerSet() {
        return passengerSet;
    }

    public void setPassengerSet(Set<Passenger> passengerSet) {
        this.passengerSet = passengerSet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
