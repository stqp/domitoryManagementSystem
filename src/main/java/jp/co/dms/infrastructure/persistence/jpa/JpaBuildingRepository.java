package jp.co.dms.infrastructure.persistence.jpa;

import jp.co.dms.domain.model.location.Address;
import jp.co.dms.domain.model.rentalproperty.Building;
import jp.co.dms.domain.model.rentalproperty.BuildingRepository;
import jp.co.dms.domain.model.rentalproperty.Floor;
import jp.co.dms.domain.model.rentalproperty.Room;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class JpaBuildingRepository implements BuildingRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Building find(Address address) {
        return null;
    }

    @Override
    public List<Building> findAll() {
        return entityManager.createNamedQuery("Building.findAll", Building.class).getResultList();
    }

    @Override
    public Building findByBuildingId(Long id) {
        return entityManager.createNamedQuery("Building.findById", Building.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public Floor findByFloorId(Long id) {
        return entityManager.createNamedQuery("Floor.findById", Floor.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public Room findByRoomId(Long id) {
        return entityManager.createNamedQuery("Room.findById", Room.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public void save(Building building) {
        for (Floor floor : building.getFloors()) {
            for (Room room : floor.getRooms()) {
                entityManager.persist(room);
            }
            entityManager.persist(floor);
        }
        entityManager.persist(building);
    }

    @Override
    public void save(Floor floor) {
        for (Room room : floor.getRooms()) {
            entityManager.persist(room);
        }
        entityManager.persist(floor);
    }

    @Override
    public void removeByBuildingId(Long id) {
        Building building = this.findByBuildingId(id);
        entityManager.remove(building);
    }

    @Override
    public void removeByFloorId(Long id) {
        Floor floor = this.findByFloorId(id);
        entityManager.remove(floor);
    }

}
