package jp.co.dms.interfaces.user.rest;

import jp.co.dms.domain.model.rentalproperty.Building;
import lombok.Data;

@Data
public class PostBuildingResponse {

    private int id;
    private String name;

    public static PostBuildingResponse from(Building building) {
        PostBuildingResponse res = new PostBuildingResponse();
        res.setId(building.getId());
        res.setName(building.getName());
        return res;
    }
}
