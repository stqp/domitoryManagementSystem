package jp.co.dms.application;

import jp.co.dms.domain.model.rentalproperty.Building;

import java.util.List;

public interface BuildingService {
    Building addBuilding(String buildingName);

    List<Building> findAll();
}
