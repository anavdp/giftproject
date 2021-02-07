package com.giv.giftproject.domain.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Password {
    
    @Id
    @GeneratedValue
    private int id;

    @OneToOne
    @JoinColumn(name = "id_user")
    private User user;
    
    @Column(nullable = false)
    private String encryptedPassword;

}
