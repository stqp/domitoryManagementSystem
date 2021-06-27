package jp.co.dms.domain.model.rent;

import jp.co.dms.domain.model.payment.Payment;
import jp.co.dms.domain.model.rentalproperty.Room;
import jp.co.dms.domain.model.resident.RentParty;
import jp.co.dms.domain.shared.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
@Data
public class Contract extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Room room;

    @OneToOne
    private RentParty rentParty;

    @OneToOne
    private Payment payment;

    @OneToOne
    private ContractBody contractBody;

    private Date startAt;

    private Date endAt;

}
