package jp.co.dms.domain.model.resident;

import jp.co.dms.domain.shared.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Corporation extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;
}
