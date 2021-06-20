package jp.co.dms.interfaces.user.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.dms.domain.model.rentalproperty.Room;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PostBuildingRequest {

    @JsonProperty("name")
    String name;
    int topFloorLevel;

    @JsonProperty("rooms")
    List<Room> rooms = new ArrayList<>();

}
