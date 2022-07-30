/**
 * @author @Euraks 24.07.2022
 */
package org.jpwh.model.simple;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Item1 {
    @Id
    @GeneratedValue(generator = "ID_GENERATOR")
    @Column(name = "id", nullable = false)
    private Integer id;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }
}
