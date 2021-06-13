package jp.co.dms.domain.model.rentalproperty;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class Floor {

    @Id
    @GeneratedValue
    Long id;

    @OneToMany
    List<Room> rooms;

    void updateRoom(Room room) {
        Room oldRoom = findRoom(room);
        oldRoom.copyValuesFrom(room);
    }

    void addNewRoom(Room room) {
        rooms.add(room);
    }

    Room findRoom(Room room) {
        for (Room r : rooms) {
            if (r.equals(room)) {
                return r;
            }
        }
        return null;
    }

}
