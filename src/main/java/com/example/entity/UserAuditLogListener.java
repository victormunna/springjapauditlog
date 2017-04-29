package com.example.entity;

import com.example.BeanUtility;
import com.example.repository.AuditLogRepository;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PreRemove;
import java.time.ZonedDateTime;

public class UserAuditLogListener {

    @PostPersist
    public void actionBeforeSave(final User user) {
        System.out.println("Inside user Entity listener");

        System.out.println(user.toString());
        AuditLog auditLog = new AuditLog();
        auditLog.setTableName("User");
        auditLog.setAction("Add new user");
        auditLog.setUpdateDate(ZonedDateTime.now());

        AuditLogRepository auditLogRepository
                = (AuditLogRepository) BeanUtility.getBean("auditLogRepository");

        auditLogRepository.save(auditLog);

    }

    @PostUpdate
    public void actionBeforeUpdate(final User user) {
        System.out.println("Inside user Entity listener");
        System.out.println(user.toString());
        AuditLog auditLog = new AuditLog();
        auditLog.setTableName("User");
        auditLog.setAction("Update User : " + user.getName());
        auditLog.setUpdateDate(ZonedDateTime.now());

        AuditLogRepository auditLogRepository
                = (AuditLogRepository) BeanUtility.getBean("auditLogRepository");

        auditLogRepository.save(auditLog);

    }

    @PreRemove
    public void actionBeforeDelete(final User user) {
        System.out.println("Inside user Entity listener");

        System.out.println(user.toString());
        AuditLog auditLog = new AuditLog();
        auditLog.setTableName("User");
        auditLog.setAction("Delete User : " + user.getName());
        auditLog.setUpdateDate(ZonedDateTime.now());

        AuditLogRepository auditLogRepository
                = (AuditLogRepository) BeanUtility.getBean("auditLogRepository");

        auditLogRepository.save(auditLog);


    }
}
