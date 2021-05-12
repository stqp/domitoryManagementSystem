package jp.co.dms.domain.model.rentalproperty;

import java.util.List;

public interface RoomRepository {

    Room find(Building building, Floor floor, int roomId);

    List<Room> findAll(Building building, Floor floor);

    void save(Room room);
}
