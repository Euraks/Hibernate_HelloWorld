package org.jpwh.model.collections.setofstrings;

import org.jpwh.model.Constants;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Item {

    @Id
    @GeneratedValue(generator = Constants.ID_GENERATOR)
    protected Long id;

    @ElementCollection
    @CollectionTable(
            name = "IMAGE", // Defaults to ITEM_IMAGES
            joinColumns = @JoinColumn(name = "ITEM_ID")) // Default, actually
    @Column(name = "FILENAME") // Defaults to IMAGES
    protected Set<String> images = new HashSet<String>(); // Initialize field here

    public Long getId() {
        return id;
    }

    public Set<String> getImages() {
        return images;
    }

    public void setImages(Set<String> images) {
        this.images = images;
    }

    // ...
}
