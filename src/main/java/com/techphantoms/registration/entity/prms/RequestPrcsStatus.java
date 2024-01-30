package com.techphantoms.registration.entity.prms;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Entity
@Table(name = "request_prcs_status", schema = "prms")
public class RequestPrcsStatus {
    private long requestPrcsStatusId;
    @Id
    private String requestPrcsStatusGuid;
    private Boolean isStatusActive;
    private String docsDetailInfo;
    private String dataXml;
    @Type(type = "jsonb")
    private String dataJson;
    private LocalDateTime statusAsOnDate;
    private String createdBy;
    private LocalDateTime createdDate;
    private String createdIpAddr;
    private String createdMacAddr;
    private String creatorRemarks;
    private String createdUri;
    private String modifiedBy;
    private LocalDateTime modifiedDate;
    private String modifiedIpAddr;
    private String modifiedMacAddr;
    private String modifierRemarks;
    private String modifiedUri;

  }
