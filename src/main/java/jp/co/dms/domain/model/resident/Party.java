package jp.co.dms.domain.model.resident;

import jp.co.dms.domain.model.location.Address;
import jp.co.dms.domain.model.location.Email;
import jp.co.dms.domain.model.location.Phone;
import jp.co.dms.domain.shared.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Party extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Individual individual;

    @OneToOne
    private Corporation corporation;

    @OneToOne
    private Address address;

    @OneToMany
    private List<Email> email;

    @OneToMany
    private List<Phone> phone;

}
