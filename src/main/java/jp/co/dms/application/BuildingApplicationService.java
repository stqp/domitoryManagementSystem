package jp.co.dms.application;

import jp.co.dms.domain.model.rentalproperty.Building;
import jp.co.dms.domain.model.rentalproperty.Room;

import java.util.List;

public interface BuildingApplicationService {

    Building addBuilding(String buildingName, Integer floorLevel, List<Room> rooms);

    List<Building> findAll();

    void removeByBuildingId(Long id);

    void removeByFloorId(Long id);


    void remove(Long buildingId, Long floorId, Long roomId);

}
