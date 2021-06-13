package jp.co.dms.domain.shared;

import java.io.Serializable;
import java.util.Date;

public class BaseEntity implements Serializable {
    protected Date createdAd;
    protected Date deletedAt;
}
