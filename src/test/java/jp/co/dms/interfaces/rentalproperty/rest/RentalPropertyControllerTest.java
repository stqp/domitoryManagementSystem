package jp.co.dms.interfaces.rentalproperty.rest;


import jp.co.dms.domain.model.rentalproperty.Building;
import jp.co.dms.domain.model.rentalproperty.Floor;
import jp.co.dms.domain.model.rentalproperty.Room;
import jp.co.dms.interfaces.rentalproperty.rest.dto.PostBuildingRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@ContextConfiguration("classpath:applicationContext.xml")
@WebAppConfiguration
@RunWith(SpringRunner.class)
@Transactional
public class RentalPropertyControllerTest {

    @Autowired
    RentalPropertyController rentalPropertyController;

    @Test
    public void testCRUDBuilding() {
        List<Room> rooms = new ArrayList<>();
        Room room = new Room();
        room.setName("room1");
        room.setFloorLevel(1);
        room.setCapacity(10);
        room.setSquareMeters(50);
        rooms.add(room);
        PostBuildingRequest req = new PostBuildingRequest();
        req.setName("building1");
        req.setTopFloorLevel(2);
        req.setRooms(rooms);
        rentalPropertyController.postBuilding(req);
        List<Building> buildings = rentalPropertyController.getBuilding().getBuildings();
        List<Floor> floors = buildings.get(0).getFloors();
        assertThat(buildings.get(0).getName(), is("building1"));
        assertThat(buildings.get(0).getFloors().get(0).getRooms().get(0).getName(), is("room1"));

    }

}
