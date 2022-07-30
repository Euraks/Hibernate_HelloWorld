package org.jpwh.model.collections.bagofstrings;

import org.jpwh.model.Constants;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Item {

    @Id
    @GeneratedValue(generator = Constants.ID_GENERATOR)
    protected Long id;

    @ElementCollection
    @CollectionTable(name = "IMAGE")
    @Column(name = "FILENAME")
    @org.hibernate.annotations.CollectionId( // Surrogate PK allows duplicates!
            columns = @Column(name = "IMAGE_ID"),
            type = @org.hibernate.annotations.Type(type = "long"),
            generator = Constants.ID_GENERATOR)
    protected Collection<String> images = new ArrayList<String>(); // No BagImpl in JDK!

    public Long getId() {
        return id;
    }

    public Collection<String> getImages() {
        return images;
    }

    public void setImages(Collection<String> images) {
        this.images = images;
    }

    // ...
}
