package jp.co.dms.infrastructure.persistence.jpa;

import jp.co.dms.domain.model.rentalproperty.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JpaBuildingRepository extends JpaRepository<Building, Integer> {
    Optional<Building> findByEmail(String email);

    Optional<Building> findFirstByName(String name);
}
