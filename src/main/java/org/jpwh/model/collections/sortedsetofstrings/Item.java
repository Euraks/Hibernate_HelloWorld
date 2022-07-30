package org.jpwh.model.collections.sortedsetofstrings;

import org.jpwh.model.Constants;

import javax.persistence.*;
import java.util.SortedSet;
import java.util.TreeSet;

@Entity
public class Item {

    @Id
    @GeneratedValue(generator = Constants.ID_GENERATOR)
    protected Long id;

    @ElementCollection
    @CollectionTable(name = "IMAGE")
    @Column(name = "FILENAME")
    @org.hibernate.annotations.SortNatural
    protected SortedSet<String> images = new TreeSet<String>();

    public Long getId() {
        return id;
    }

    public SortedSet<String> getImages() {
        return images;
    }

    public void setImages(SortedSet<String> images) {
        this.images = images;
    }

    // ...
}
