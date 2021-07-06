package jp.co.dms.interfaces.rentalproperty.rest.dto;

import jp.co.dms.domain.model.rentalproperty.Building;
import lombok.Data;

@Data
public class PostBuildingResponse {

    private Long id;
    private String name;

    public static PostBuildingResponse from(Building building) {
        PostBuildingResponse res = new PostBuildingResponse();
        res.setId(building.getId());
        res.setName(building.getName());
        return res;
    }
}
