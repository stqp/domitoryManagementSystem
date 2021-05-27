package jp.co.dms.interfaces.user.rest;

import jp.co.dms.application.BuildingService;
import jp.co.dms.domain.model.rentalproperty.Building;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

@RestController
@Path("/")
public class RentalPropertyManageService {

    @Autowired
    private BuildingService buildingService;

    @Path("/building")
    @POST
    public PostBuildingResponse postBuilding(String buildingName) {
        Building building = buildingService.addBuilding(buildingName);
        return PostBuildingResponse.from(building);
    }
}
