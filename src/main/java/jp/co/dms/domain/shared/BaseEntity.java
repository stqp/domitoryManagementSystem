package jp.co.dms.domain.shared;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
public class BaseEntity {

    @CreationTimestamp
    @Column(name = "createdAd")
    protected Date createdAd;

    @UpdateTimestamp
    @Column(name = "deletedAt")
    protected Date deletedAt;
}
