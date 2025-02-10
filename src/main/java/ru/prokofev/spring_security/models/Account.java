package ru.prokofev.spring_security.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "username")
    @NotEmpty(message = "Необходимо указать имя пользователя")
    @Size(max = 64, message = "Имя пользователя должно быть не более 64 символов")
    String username;
    @Column(name = "password")
    @NotEmpty(message = "Необходимо указать пароль")
    @Size(max = 64, message = "Пароль должен быть не более 64 символов")
    String password;

    public Account() {
    }

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}