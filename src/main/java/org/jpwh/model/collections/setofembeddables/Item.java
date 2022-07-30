package org.jpwh.model.collections.setofembeddables;

import org.jpwh.model.Constants;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
public class Item {

    @Id
    @GeneratedValue(generator = Constants.ID_GENERATOR)
    protected Long id;

//    @ElementCollection
//    @CollectionTable(name = "IMAGE")
//    @OrderBy("filename, width ASC")
//    @AttributeOverride(
//            name = "filename",
//            column = @Column(name = "FNAME", nullable = false)
//    )
//    protected Set<Image> images = new HashSet<Image>();
@ElementCollection
@CollectionTable(name = "IMAGE")
@OrderBy("filename, width ASC")
protected Set<Image> images = new LinkedHashSet<Image>();

    public Long getId() {
        return id;
    }

    public Set<Image> getImages() {
        return images;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }

    // ...
}
