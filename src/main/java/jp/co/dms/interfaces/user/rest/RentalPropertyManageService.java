package jp.co.dms.interfaces.user.rest;

import jp.co.dms.application.BuildingService;
import jp.co.dms.domain.model.rentalproperty.Building;
import jp.co.dms.interfaces.shared.BaseRestService;
import jp.co.dms.interfaces.user.rest.dto.GetBuildingResponse;
import jp.co.dms.interfaces.user.rest.dto.PostBuildingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RentalPropertyManageService extends BaseRestService {

    @Autowired
    private BuildingService buildingService;

    @PostMapping(value = ROOT_API_URL + "/building")
    public PostBuildingResponse postBuilding(String buildingName) {
        Building building = buildingService.addBuilding(buildingName);
        return PostBuildingResponse.from(building);
    }

    @GetMapping(value = ROOT_API_URL + "/building")
    public GetBuildingResponse getBuilding() {
        return GetBuildingResponse.from(buildingService.findAll());
    }


}
