package com.example.lab5_spring.Entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "flight")
public class flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "flight")
    private String flight;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "flight")
    private final Collection<passengers> passengers = new ArrayList<>();

    public flight(String name){this.flight = name;}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFlight() {
        return flight;
    }

    public void setFlight(String flight) {
        this.flight = flight;
    }

    @Override
    public String toString() {
        return " \t\t " + id + " \t\t " + flight;
    }

}
