package jp.co.dms.domain.model.rentalproperty;

import jp.co.dms.domain.model.location.Address;

import java.util.List;

public interface BuildingRepository {

    Building find(Address address);

    List<Building> findAll();

    Building save(Building building);
}
