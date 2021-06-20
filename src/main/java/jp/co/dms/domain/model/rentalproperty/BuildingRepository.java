package jp.co.dms.domain.model.rentalproperty;

import jp.co.dms.domain.model.location.Address;

import java.util.List;

public interface BuildingRepository {

    Building find(Address address);

    List<Building> findAll();

    Building findByBuildingId(Long id);

    Floor findByFloorId(Long id);

    Room findByRoomId(Long id);

    void save(Building building);

    void save(Floor floor);


    void removeByBuildingId(Long id);

    void removeByFloorId(Long id);

}
