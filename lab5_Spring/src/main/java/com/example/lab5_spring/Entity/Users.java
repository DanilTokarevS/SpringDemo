package com.example.lab5_spring.Entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(name = "users")
public class Users {

    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "id_role")
    private int id_role;

    public Users(String username, String password, int idRole){
        this.username=username;
        this.password = password;
        this.id_role = idRole;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdRole() {
        return id_role;
    }

    public void setIdRole(int idRole) {
        this.id_role = idRole;
    }

    public void add(String username, String password, int role) {
        setUsername(username);
        setPassword(password);
        setIdRole(role);
    }


}
