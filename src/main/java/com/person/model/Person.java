package com.person.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "person")
public class Person {

    @EmbeddedId
    private PersonIdentity personIdentity;

    @Column(name = "id", insertable = false, updatable = false)
    private Long id;

    private String name;
    private String surname;

    @Min(18) @Max(130)
    private int age;

    @Email
    @Size(max = 60)
    private String email;

    @Size(max = 20)
    private String phone;

    @ManyToOne
    private Person person;

    public Person() { }

    public Person(PersonIdentity personIdentity) {
        this.personIdentity = personIdentity;
    }

    public Person(PersonIdentity personIdentity, long id, String name, String surname, int age, @Email @Size(max = 60) String email, @Size(max = 20) String phone) {
        this.personIdentity = personIdentity;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.id = id;
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(personIdentity, person.personIdentity);
    }

    @Override
    public int hashCode() {

        return Objects.hash(personIdentity);
    }
}
