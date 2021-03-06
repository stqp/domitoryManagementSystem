package jp.co.dms.domain.model.location;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Address {

    @Id
    @GeneratedValue
    private Long id;

    private String postcode;

    private String country;

    private String prefecture;

    private String city;

    private String street;
}
