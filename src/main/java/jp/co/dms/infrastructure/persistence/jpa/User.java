package jp.co.dms.infrastructure.persistence.jpa;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "User")
@Data
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    public String name;

    public String password;

    public Boolean admin;

    public String email;
}
