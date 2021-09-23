package ch.zli.m223.addressbook.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.logging.Logger;


/**
 * @author P. Gatzka
 * @version 23.09.2021
 * Project: addressbookserver
 */
@Entity
public abstract class AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private static final Logger LOGGER = Logger.getLogger(AbstractEntity.class.getName());

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "update_date")
    private LocalDateTime updateDate;

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
