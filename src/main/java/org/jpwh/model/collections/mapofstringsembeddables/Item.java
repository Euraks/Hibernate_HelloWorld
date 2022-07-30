package org.jpwh.model.collections.mapofstringsembeddables;

import org.jpwh.model.Constants;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
public class Item {

    @Id
    @GeneratedValue(generator = Constants.ID_GENERATOR)
    protected Long id;

    @ElementCollection
    @CollectionTable(name = "IMAGE")
    @MapKeyColumn(name = "FILENAME") // Optional, defaults to IMAGES_KEY
    protected Map<String, Image> images = new HashMap<String, Image>();

    public Long getId() {
        return id;
    }

    public Map<String, Image> getImages() {
        return images;
    }

    public void setImages(Map<String, Image> images) {
        this.images = images;
    }

    // ...
}
