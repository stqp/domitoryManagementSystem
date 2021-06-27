package jp.co.dms.domain.model.rent;

import jp.co.dms.domain.shared.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Money extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;
}
