package jp.co.dms.infrastructure.persistence.jpa;

import jp.co.dms.domain.model.location.Address;
import jp.co.dms.domain.model.rentalproperty.Building;
import jp.co.dms.domain.model.rentalproperty.BuildingRepository;
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
    public void save(Building building) {
        entityManager.persist(building);
    }
}
