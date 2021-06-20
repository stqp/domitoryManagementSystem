package jp.co.dms.domain.model.rentalproperty;


import jp.co.dms.domain.shared.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@NamedQueries({
        @NamedQuery(name = "Room.findAll",
                query = "Select r from Room r"),
        @NamedQuery(name = "Room.findById",
                query = "Select r from Room r where r.id = :id")})
public class Room extends BaseEntity {

    public Room() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @Column(name = "name")
    String name;

    @Column(name = "floorLevel")
    Integer floorLevel;

    @Column(name = "capacity")
    Integer capacity;

    @Column(name = "squareMeters")
    float squareMeters;

    void copyValuesFrom(Room room) {
        this.name = room.getName();
        this.capacity = room.getCapacity();
        this.squareMeters = room.getSquareMeters();
    }

}
