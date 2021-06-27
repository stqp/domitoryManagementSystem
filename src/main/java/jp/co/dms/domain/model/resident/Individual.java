package jp.co.dms.domain.model.resident;

import jp.co.dms.domain.shared.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;


@Entity
@Data
public class Individual extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Date birth;

}
