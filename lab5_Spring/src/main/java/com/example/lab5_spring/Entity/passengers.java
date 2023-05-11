package com.example.lab5_spring.Entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(name = "passengers")
public class passengers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_flight")
    private flight flight;

    public passengers(String name){
        this.name=name;
    }

    @Override
    public String toString() {
        return id + " \t\t " + name +" \t\t " + flight.getId();
    }



    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
