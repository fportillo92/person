package com.person.model;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PersonIdentity implements Serializable {

    @NotNull
    private String docType;

    @NotNull
    private String docNumber;

    @NotNull
    private String country;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Gender gender;

    public PersonIdentity(){ }

    public PersonIdentity(@NotNull String docType, @NotNull String docNumber, @NotNull String country, @NotNull Gender gender) {
        this.docType = docType;
        this.docNumber = docNumber;
        this.country = country;
        this.gender = gender;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonIdentity that = (PersonIdentity) o;
        return Objects.equals(docType, that.docType) &&
                Objects.equals(docNumber, that.docNumber) &&
                Objects.equals(country, that.country) &&
                gender == that.gender;
    }

    @Override
    public int hashCode() {

        return Objects.hash(docType, docNumber, country, gender);
    }

}
