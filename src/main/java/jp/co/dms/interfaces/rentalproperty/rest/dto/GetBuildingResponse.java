package jp.co.dms.interfaces.rentalproperty.rest.dto;

import jp.co.dms.domain.model.rentalproperty.Building;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GetBuildingResponse {
    private List<Building> buildings = new ArrayList<>();

    public static GetBuildingResponse from(List<Building> buildings) {
        GetBuildingResponse res = new GetBuildingResponse();
        res.setBuildings(buildings);
        return res;
    }
}
