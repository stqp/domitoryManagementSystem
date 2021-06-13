package jp.co.dms.infrastructure.persistence.jpa;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "\"user\"")
public class User {

    @Id
    @GeneratedValue
    Long id;

    @Column(name = "name")
    String name;

    @Column(name = "password")
    String password;

    @Column(name = "admin")
    Boolean admin;

    @Column(name = "email")
    String email;
}
