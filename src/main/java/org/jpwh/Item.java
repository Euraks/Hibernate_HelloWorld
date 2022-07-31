package org.jpwh;

import javax.persistence.*;
import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;

@Entity
public class Item {

    @Id
    @GeneratedValue(generator = Constants.ID_GENERATOR)
    protected Long id;

    @ElementCollection
    @CollectionTable(name = "IMAGE")
    @MapKeyColumn(name = "FILENAME")
    @Column(name = "IMAGENAME")
    @org.hibernate.annotations.SortComparator(ReverseStringComparator.class)
    protected SortedMap<String, String> images = new TreeMap<String, String>();

    public Long getId() {
        return id;
    }

    public SortedMap<String, String> getImages() {
        return images;
    }

    public void setImages(SortedMap<String, String> images) {
        this.images = images;
    }

    public static class ReverseStringComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            return b.compareTo(a); // Inverse sorting
        }
    }


    // ...
}
