package jp.co.dms.domain.model.rent;

import jp.co.dms.domain.model.resident.Party;
import jp.co.dms.domain.shared.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
public class Guaranty extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    // 保証人
    @OneToOne
    private Party guarantor;

    // 被保証人
    @OneToOne
    private Party Guarantee;
}
