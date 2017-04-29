package com.example.controller;

import com.example.entity.AuditLog;
import com.example.repository.AuditLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuditorController {
    @Autowired
    private AuditLogRepository auditLogRepository;

    @RequestMapping(value = "/getaudit" , method = RequestMethod.GET)
    public ResponseEntity<Iterable<AuditLog>> getAudit() {
        return new ResponseEntity<Iterable<AuditLog>>(auditLogRepository.findAll(), HttpStatus.OK);
    }
}
