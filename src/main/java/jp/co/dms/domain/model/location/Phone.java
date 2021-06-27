package jp.co.dms.domain.model.location;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Phone {

    @Id
    @GeneratedValue
    private Long id;

    private String phone;

}
