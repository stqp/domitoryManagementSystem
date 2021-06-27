package jp.co.dms.domain.model.resident;

import jp.co.dms.domain.shared.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
public class Lessee extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Party party;

}
