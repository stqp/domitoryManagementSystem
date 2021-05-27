package jp.co.dms.domain.model.rentalproperty;

import jp.co.dms.domain.shared.Entity;
import lombok.Data;

import java.util.List;

@Data
public class Building extends Entity {

    private int id;
    private String name;

    private List<Floor> floors;

    public Building(String name) {
        this.name = name;
    }
}
