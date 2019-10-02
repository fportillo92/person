package com.person.model;

import javax.persistence.*;

@Entity
@Table(name = "general_sequence_number")
public class GeneralSequenceNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}