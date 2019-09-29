package com.person.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name = "person")
public class Person {

    @EmbeddedId
    private PersonIdentity personIdentity;

    private String name;
    private String surname;

    @Min(18) @Max(130)
    private int age;

    @Email
    @Size(max = 60)
    private String email;

    @Size(max = 20)
    private String phone;

    public Person() { }

    public Person(PersonIdentity personIdentity) { }

    public Person(PersonIdentity personIdentity, String name, String surname, int age, @Email @Size(max = 60) String email, @Size(max = 20) String phone) {
        this.personIdentity = personIdentity;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public PersonIdentity getPersonIdentity() {
        return personIdentity;
    }

    public void setPersonIdentity(PersonIdentity personIdentity) {
        this.personIdentity = personIdentity;
    }
}
