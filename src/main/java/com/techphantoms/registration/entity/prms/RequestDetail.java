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
@Table(name = "request_detail", schema = "prms")
public class RequestDetail {
    private long requestDetailId;
    @Id
    private String requestDetailGuid;
    private String fileNumber;
    private String dataXml;
    @Type(type = "jsonb")
    private String dataJson;
    private String formContentUri;
    private LocalDateTime submittedDate;
    private Boolean isSubmitted;
    private String submittedByGuid;
    private Boolean isActive;
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
