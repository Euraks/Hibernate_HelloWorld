package org.hibernate_lesson.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
//@Table(name = "message")
public class Message {

//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "player_generator")
    @SequenceGenerator(name="player_generator", sequenceName = "MY_SEQUENCE",   // SEQ_MESSAGE - ранее созданный sequence
                                                                                // в БД через SQL
            allocationSize = 1, initialValue = 1)

    private Integer id;

    private String text;

    //@Column(name = "test")
    @org.hibernate.annotations.ColumnTransformer(
            read = "test / 2.20462",
            write = "? * 2.20462")
    private Integer test = 100;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(insertable = false, updatable = false)
    @org.hibernate.annotations.Generated(
            org.hibernate.annotations.GenerationTime.ALWAYS
    )
    protected Date lastModified;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    @org.hibernate.annotations.CreationTimestamp
    protected Date createdOn;



    public Message() {
    }

    public Message(Integer id, String text) {
        this.id = id;
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
