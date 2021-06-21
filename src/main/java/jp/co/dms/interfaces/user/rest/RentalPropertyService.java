package jp.co.dms.interfaces.user.rest;

import jp.co.dms.application.BuildingService;
import jp.co.dms.domain.model.rentalproperty.Building;
import jp.co.dms.interfaces.shared.BaseRestService;
import jp.co.dms.interfaces.user.rest.dto.DeleteBuildingRequest;
import jp.co.dms.interfaces.user.rest.dto.GetBuildingResponse;
import jp.co.dms.interfaces.user.rest.dto.PostBuildingRequest;
import jp.co.dms.interfaces.user.rest.dto.PostBuildingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class RentalPropertyService extends BaseRestService {

    private static final String BUILDING_API_URL = "/building";

    @Autowired
    private BuildingService buildingService;

    @PostMapping(value = ROOT_API_URL + BUILDING_API_URL)
    public PostBuildingResponse postBuilding(@RequestBody PostBuildingRequest req) {
        Building building = buildingService.addBuilding(req.getName(), req.getTopFloorLevel(), req.getRooms());
        return PostBuildingResponse.from(building);
    }

    @GetMapping(value = ROOT_API_URL + BUILDING_API_URL)
    public GetBuildingResponse getBuilding() {
        return GetBuildingResponse.from(buildingService.findAll());
    }

    @DeleteMapping(value = ROOT_API_URL + BUILDING_API_URL)
    public void deleteBuilding(@RequestBody DeleteBuildingRequest req) {
        buildingService.remove(req.getBuildingId(), req.getFloorId(), req.getRoomId());
    }
}
