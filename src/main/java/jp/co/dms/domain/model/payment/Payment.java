package jp.co.dms.domain.model.payment;

import jp.co.dms.domain.model.rent.Money;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
public class Payment {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Money deposit;

    private PaymentTerm paymentType;

}
