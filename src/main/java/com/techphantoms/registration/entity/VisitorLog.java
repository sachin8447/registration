package com.techphantoms.registration.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "visitor_log")
public class VisitorLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "visitor_log_id", nullable = false)
    private Long visitorLogId;

    @Column(name = "counter")
    private Long counter;

    @Column(name = "request_from_uri")
    private String requestFromUri;

    @Column(name = "request_for_uri")
    private String requestForUri;

    @Column(name = "access_from_browser")
    private String accessFromBrowser;

    @Column(name = "access_from_ip_addr")
    private String accessFromIpAddr;

    @Column(name = "access_from_mac_addr")
    private String accessFromMacAddr;

    @Column(name = "application")
    private String application;

    @Column(name = "corporation")
    private String corporation;

    @Column(name = "is_active", nullable = false)
    private String active;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_date", nullable = false)
    private Date createdDate;

    @Column(name = "created_ip_addr", nullable = false)
    private String createdIpAddr;

    @Column(name = "created_mac_addr")
    private String createdMacAddr;

    @Column(name = "created_remarks")
    private String createdRemarks;

    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "modified_date")
    private Date modifiedDate;

    @Column(name = "modified_ip_addr")
    private String modifiedIpAddr;

    @Column(name = "modified_mac_addr")
    private String modifiedMacAddr;

    @Column(name = "modified_remarks")
    private String modifiedRemarks;

}
