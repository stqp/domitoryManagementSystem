package jp.co.dms.domain.model.rentalproperty;

import jp.co.dms.domain.shared.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NamedQueries({
        @NamedQuery(name = "Building.findAll",
                query = "Select b from Building b"),
        @NamedQuery(name = "Building.findById",
                query = "Select b from Building b where b.id = :id")})
public class Building extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
    private List<Floor> floors = new ArrayList<>();

    public Building(String name) {
        this.name = name;
    }

    public Building() {
    }

    public void addNewFloor(Floor floor) {
        this.floors.add(floor);
    }

    public void addNewRoom(Long floorId, Room room) {
        findFloorById(floorId).addNewRoom(room);
    }

    public List<Floor> findAllFloor() {
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
