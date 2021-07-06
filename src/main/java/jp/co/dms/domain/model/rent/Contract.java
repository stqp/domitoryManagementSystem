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
import java.util.List;

@Entity
@Data
public class Contract extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Room room;

    @OneToOne
    private List<RentParty> rentParties;

    @OneToOne
    private Payment payment;

    @OneToOne
    private ContractBody contractBody;

    private Date startAt;

    private Date endAt;

    public Contract(
            Room room,
            Payment payment,
            List<RentParty> rentParties,
            ContractBody contractBody,
            Date startAt,
            Date endAt) {
        this.room = room;
        this.payment = payment;
        this.rentParties = rentParties;
        this.contractBody = contractBody;
        this.startAt = startAt;
        this.endAt = endAt;
    }
    

}
