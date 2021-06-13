package jp.co.dms.domain.model.rentalproperty;

import jp.co.dms.domain.shared.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "Building.findAll",
                query = "Select b from Building b")})
@Data
public class Building extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany
    private List<Floor> floors;

    public Building(String name) {
        this.name = name;
    }

    public Building() {
    }

    void addNewFloor(Floor floor) {
        this.floors.add(floor);
    }

    void addNewRoom(Long floorId, Room room) {
        findFloorById(floorId).addNewRoom(room);
    }

    List<Floor> findAllFloor() {
        return floors;
    }

    Floor findFloorById(Long floorId) {
        for (Floor f : floors) {
            if (f.getId().equals(floorId)) {
                return f;
            }
        }
        return null;
    }

}
