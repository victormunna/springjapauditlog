package com.example.entity;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
public class AuditLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="table_name")
    private String tableName;

    @Column(name="action")
    private String action;

    @Column(name="update_date")
    private ZonedDateTime updateDate;

    public AuditLog(String tableName, String action, ZonedDateTime updateDate) {
        this.tableName = tableName;
        this.action = action;
        this.updateDate = updateDate;
    }

    public AuditLog() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public ZonedDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(ZonedDateTime updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "AuditLog{" +
                "tableName='" + tableName + '\'' +
                ", action='" + action + '\'' +
                ", updateDate=" + updateDate +
                '}';
    }
}
