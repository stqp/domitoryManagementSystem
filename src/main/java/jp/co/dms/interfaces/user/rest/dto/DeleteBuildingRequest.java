package jp.co.dms.interfaces.user.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DeleteBuildingRequest {

    @JsonProperty("buildingId")
    Long buildingId;

    @JsonProperty("floorId")
    Long floorId;

    @JsonProperty("roomId")
    Long roomId;

}
