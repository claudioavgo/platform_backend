package com.claudioav.eplataform.domain.user;

import com.claudioav.eplataform.dtos.UserDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity(name="user")
@Table(name="users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private String email;

    private String phone;

    private int balance;

    private String password;

    private Date created_at;

    public User(UserDTO userDTO) {
        this.name = userDTO.name();
        this.email = userDTO.email();
        this.phone = userDTO.phone();
        this.created_at = new Date();
    }
}
