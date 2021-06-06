package jp.co.dms.application.internal;

import jp.co.dms.application.BuildingService;
import jp.co.dms.domain.model.rentalproperty.Building;
import jp.co.dms.domain.model.rentalproperty.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultBuildingService implements BuildingService {

    @Autowired
    private BuildingRepository buildingRepository;

    public Building addBuilding(String buildingName) {
        Building building = new Building(buildingName);
        buildingRepository.save(building);
        return building;
    }

    @Override
    public List<Building> findAll() {
        return buildingRepository.findAll();
    }

}
