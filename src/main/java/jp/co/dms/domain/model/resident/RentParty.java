package jp.co.dms.domain.model.resident;

import jp.co.dms.domain.model.rent.Guaranty;
import jp.co.dms.domain.shared.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class RentParty extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private LocationParty locationParty;

    @OneToMany
    private List<Guaranty> guaranty;

    private RentPartyType rentPartyType;

}
