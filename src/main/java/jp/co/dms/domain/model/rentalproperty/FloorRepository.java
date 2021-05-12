package jp.co.dms.domain.model.rentalproperty;

import java.util.List;

public interface FloorRepository {

    Floor find(Building building, int floorId);

    List<Floor> findAll(Building building);

    void save(Floor floor);
}
