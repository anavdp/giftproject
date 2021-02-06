package com.giv.giftproject.domain.model;

import com.giv.giftproject.domain.enums.RelationshipType;

import javax.persistence.*;
import java.util.Date;


@Entity
public class Relationship {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne(optional = false)
    private User userA;

    @ManyToOne(optional = false)
    private User userB;

    @Enumerated(EnumType.STRING)
    private RelationshipType relationshipType;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date creationDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationDate;


    public Relationship() {}

    public Relationship(User userA, User userB, RelationshipType relationshipType, Date creationDate, Date modificationDate) {
        this.userA = userA;
        this.userB = userB;
        this.relationshipType = relationshipType;
        this.creationDate = creationDate;
        this.modificationDate = modificationDate;
    }

    public User getUserA() {
        return userA;
    }

    public User getUserB() {
        return userB;
    }

    public RelationshipType getRelationshipType() {
        return relationshipType;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

}
