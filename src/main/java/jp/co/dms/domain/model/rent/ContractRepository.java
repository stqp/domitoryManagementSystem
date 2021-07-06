package jp.co.dms.domain.model.rent;

import java.util.Date;
import java.util.List;

public interface ContractRepository {

    List<Contract> findAll();

    Contract findById(Long id);

    List<Contract> findByRoomId(Long id);

    List<Contract> findBetween(Date startAt, Date endAt);

    void save(Contract contract);
}
