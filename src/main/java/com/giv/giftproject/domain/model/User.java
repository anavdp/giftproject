package com.giv.giftproject.domain.model;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.giv.giftproject.domain.enums.Gender;
import com.giv.giftproject.domain.enums.Pronoun;

@Entity
public class User {
    @Id
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String lastname;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    @Temporal(value = TemporalType.DATE)
    private LocalDate birthdate;
    @Column
    private String phoneNumber;
    @Column
    @Enumerated(value = EnumType.STRING)
    private Gender gender;
    @Column
    @Enumerated(value = EnumType.STRING)
    private Pronoun pronoun;

    public User(String name, String lastname, String email, LocalDate birthdate, String phoneNumber, Gender gender,
            Pronoun pronoun) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.birthdate = birthdate;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.pronoun = pronoun;
    }
    
    public User(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Pronoun getPronoun() {
        return pronoun;
    }

    public void setPronoun(Pronoun pronoun) {
        this.pronoun = pronoun;
    }
    
}
