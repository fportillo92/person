package com.person.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name = "person")
public class Person {

    @OneToOne(fetch=FetchType.LAZY,cascade={CascadeType.PERSIST,CascadeType.REMOVE},optional=false)
    @JoinColumn(name = "id_person", referencedColumnName = "id")
    private GeneralSequenceNumber idPerson;

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

    @ManyToOne
    private Person person;

    public Person() { }

    public Person(PersonIdentity personIdentity) { }

    public Person(PersonIdentity personIdentity, GeneralSequenceNumber idPerson, String name, String surname, int age, @Email @Size(max = 60) String email, @Size(max = 20) String phone) {
        this.personIdentity = personIdentity;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.idPerson = idPerson;
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


    public GeneralSequenceNumber getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(GeneralSequenceNumber idPerson) {
        this.idPerson = idPerson;
    }
}
