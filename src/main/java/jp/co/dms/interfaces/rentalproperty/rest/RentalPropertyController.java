package jp.co.dms.interfaces.rentalproperty.rest;

import jp.co.dms.application.BuildingApplicationService;
import jp.co.dms.domain.model.rentalproperty.Building;
import jp.co.dms.interfaces.rentalproperty.rest.dto.DeleteBuildingRequest;
import jp.co.dms.interfaces.rentalproperty.rest.dto.GetBuildingResponse;
import jp.co.dms.interfaces.rentalproperty.rest.dto.PostBuildingRequest;
import jp.co.dms.interfaces.rentalproperty.rest.dto.PostBuildingResponse;
import jp.co.dms.interfaces.shared.BaseRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class RentalPropertyController extends BaseRestService {

    private static final String BUILDING_API_URL = "/building";

    @Autowired
    private BuildingApplicationService buildingApplicationService;

    @PostMapping(value = ROOT_API_URL + BUILDING_API_URL)
    public PostBuildingResponse postBuilding(@RequestBody PostBuildingRequest req) {
        Building building = buildingApplicationService.addBuilding(req.getName(), req.getTopFloorLevel(), req.getRooms());
        return PostBuildingResponse.from(building);
    }

    @GetMapping(value = ROOT_API_URL + BUILDING_API_URL)
    public GetBuildingResponse getBuilding() {
        return GetBuildingResponse.from(buildingApplicationService.findAll());
    }

    @DeleteMapping(value = ROOT_API_URL + BUILDING_API_URL)
    public void deleteBuilding(@RequestBody DeleteBuildingRequest req) {
        buildingApplicationService.remove(req.getBuildingId(), req.getFloorId(), req.getRoomId());
    }
}
