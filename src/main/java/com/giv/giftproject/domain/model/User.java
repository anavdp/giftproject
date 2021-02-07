package com.giv.giftproject.domain.model;

import com.giv.giftproject.domain.enums.Gender;
import com.giv.giftproject.domain.enums.Pronoun;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    @NotBlank(message = "Name is mandatory")
    private String name;

    @Column(nullable = false)
    @NotBlank(message = "Lastname is mandatory")
    private String lastname;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "Email is mandatory")
    @Email(message = "Please provide a valid email")
    private String email;

    @Column(nullable = false)
    @Past
    @NotNull
    private LocalDate birthdate;

    @Column
    private String phoneNumber;

    @Column
    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @Column
    @Enumerated(value = EnumType.STRING)
    private Pronoun pronoun;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private final Date creationDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationDate;

    @OneToMany(mappedBy = "userB")
    private List<Relationship> relationships;


    public User(){
        this.creationDate = new Date();
    }

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
