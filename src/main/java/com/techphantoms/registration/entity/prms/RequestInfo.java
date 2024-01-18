package com.techphantoms.registration.entity.prms;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Objects;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Entity
@Table(name = "request_info", schema = "prms")
public class RequestInfo {
    private long requestInfoId;
    @Id
    private String requestInfoGuid;
    private String applicationNumber;
    private String dataXml;
    private Object dataJson;
    private String formContentUri;
    private Timestamp submittedDate;
    private String citizenGuid;
    private String submittedByGuid;
    private Boolean isActive;
    private String createdBy;
    private Timestamp createdDate;
    private String createdIpAddr;
    private String createdMacAddr;
    private String creatorRemarks;
    private String createdUri;
    private String modifiedBy;
    private Timestamp modifiedDate;
    private String modifiedIpAddr;
    private String modifiedMacAddr;
    private String modifierRemarks;
    private String modifiedUri;

   }
