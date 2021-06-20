package jp.co.dms.domain.model.rentalproperty;

import jp.co.dms.domain.shared.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NamedQueries({
        @NamedQuery(name = "Floor.findAll",
                query = "Select f from Floor f"),
        @NamedQuery(name = "Floor.findById",
                query = "Select f from Floor f where f.id = :id")})
public class Floor extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    Integer level;

    @OneToMany(orphanRemoval = true)
    List<Room> rooms = new ArrayList<>();

    public Floor(Integer level) {
        this.level = level;
    }

    public Floor() {
    }

    public void updateRoom(Room room) {
        Room oldRoom = findRoom(room);
        oldRoom.copyValuesFrom(room);
    }

    public void addNewRoom(Room room) {
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
