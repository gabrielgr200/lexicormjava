package com.web.lexicorm.lexicormWeb.models;

import jakarta.persistence.*;

@Entity
@Table(name = "cadastros")
public class Administrador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password.substring(0,0) + "****";
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "name") //length:100 ou mais
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;
}
