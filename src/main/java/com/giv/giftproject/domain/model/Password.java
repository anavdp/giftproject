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

    public Password(User user, String encryptedPassword) {
        this.user = user;
        this.encryptedPassword = encryptedPassword;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

}
