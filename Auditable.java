package pelijee.entities.base;

import lombok.Getter;
import lombok.Setter;
import org.threeten.bp.LocalDateTime;
import pelijee.services.user.UserHelper;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.io.Serializable;

/**
 * @author Marek Tomas on 12.12.2019
 */
@Getter
@Setter
@MappedSuperclass
public class Auditable implements Serializable {

    @Column(name = "created_by")
    private String createdBy;


    @Column(name = "created_date")
    private LocalDateTime createdDate;


    @Column(name = "last_modified_by")
    private String lastModifiedBy;


    @Column(name = "last_modified_date")
    private LocalDateTime lastModifiedDate;

    @PrePersist
    private void prePersist() {
        this.createdDate = LocalDateTime.now();
        this.createdBy = UserHelper.getUserLogin();
    }

    @PreUpdate
    private void preUpdate() {
        this.lastModifiedDate = LocalDateTime.now();
        this.lastModifiedBy = UserHelper.getUserLogin();
    }

}
