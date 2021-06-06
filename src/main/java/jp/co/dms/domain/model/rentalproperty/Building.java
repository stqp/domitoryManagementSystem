package jp.co.dms.domain.model.rentalproperty;


import jp.co.dms.domain.shared.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "Building.findAll",
                query = "Select b from Building b")})
@Data
public class Building extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public Building(String name) {
        this.name = name;
    }

    public Building() {

    }
}
