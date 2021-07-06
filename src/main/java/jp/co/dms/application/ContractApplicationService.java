package jp.co.dms.application;

import jp.co.dms.domain.model.payment.Payment;
import jp.co.dms.domain.model.rent.Contract;
import jp.co.dms.domain.model.rent.ContractBody;
import jp.co.dms.domain.model.rent.ContractRepository;
import jp.co.dms.domain.model.rentalproperty.Room;
import jp.co.dms.domain.model.resident.RentParty;
import jp.co.dms.domain.model.resident.RentPartyType;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ContractApplicationService {

    @Autowired
    private ContractRepository contractRepository;

    public void signContract(Room room,
                             Payment payment,
                             RentParty renter,
                             ContractBody contractBody,
                             RentParty lessee,
                             RentParty guarantor,
                             Date startAt,
                             Date endAt) {

        renter.setRentPartyType(RentPartyType.RENTER);
        lessee.setRentPartyType(RentPartyType.LESSEE);
        guarantor.setRentPartyType(RentPartyType.GUARANTOR);

        List<RentParty> rentPartyList = new ArrayList<>();
        rentPartyList.add(renter);
        rentPartyList.add(lessee);
        rentPartyList.add(guarantor);

        Contract contract = new Contract(
                room,
                payment,
                rentPartyList,
                contractBody,
                startAt,
                endAt
        );
        contractRepository.save(contract);

    }

}
