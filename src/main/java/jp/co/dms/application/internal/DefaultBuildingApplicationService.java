package jp.co.dms.application.internal;

import jp.co.dms.application.BuildingApplicationService;
import jp.co.dms.domain.model.rentalproperty.Building;
import jp.co.dms.domain.model.rentalproperty.BuildingRepository;
import jp.co.dms.domain.model.rentalproperty.Floor;
import jp.co.dms.domain.model.rentalproperty.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DefaultBuildingApplicationService implements BuildingApplicationService {

    @Autowired
    private BuildingRepository buildingRepository;

    @Override
    public Building addBuilding(String buildingName, Integer floorLevel, List<Room> rooms) {
        Building building = new Building(buildingName);

        for (int i = 1; i <= floorLevel; i++) {
            Floor floor = new Floor(i);
            for (Room room : rooms) {
                if (floor.getLevel().equals(room.getFloorLevel())) {
                    floor.addNewRoom(room);
                }
            }
            building.addNewFloor(floor);
        }
        buildingRepository.save(building);
        return building;
    }

    @Override
    public List<Building> findAll() {
        return buildingRepository.findAll();
    }

    @Override
    public void remove(Long buildingId, Long floorId, Long roomId) {
        if (roomId != null && roomId > 0) {
            Room room = buildingRepository.findByRoomId(roomId);
            Floor floor = buildingRepository.findByFloorId(floorId);
            floor.getRooms().remove(room);
            buildingRepository.save(floor);
        } else if (floorId != null && floorId > 0) {
            Floor floor = buildingRepository.findByFloorId(floorId);
            Building building = buildingRepository.findByBuildingId(buildingId);
            building.getFloors().remove(floor);
            buildingRepository.save(building);
        } else if (buildingId != null && buildingId > 0) {
            buildingRepository.removeByBuildingId(buildingId);
        }
    }

    @Override
    public void removeByBuildingId(Long id) {
        buildingRepository.removeByBuildingId(id);
    }

    @Override
    public void removeByFloorId(Long id) {
        buildingRepository.removeByFloorId(id);
    }

}
