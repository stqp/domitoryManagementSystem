package jp.co.dms.domain.model.rentalproperty;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Room {

    @Id
    @GeneratedValue
    Long id;

    @Column(name = "name")
    String name;

    @Column(name = "capacity")
    int capacity;

    @Column(name = "squareMeters")
    float squareMeters;

    void copyValuesFrom(Room room) {
        this.name = room.getName();
        this.capacity = room.getCapacity();
        this.squareMeters = room.getSquareMeters();
    }

}
