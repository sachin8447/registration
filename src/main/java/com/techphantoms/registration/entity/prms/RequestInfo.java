package com.techphantoms.registration.entity.prms;

import org.hibernate.annotations.Type;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.TypeDef;

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
@Table(name = "request_info", schema = "prms")
@DynamicInsert
@TypeDef(
        name = "jsonb",
        typeClass = JsonBinaryType.class
)
public class RequestInfo {
    private long requestInfoId;
    @Id
    private String requestInfoGuid;
    private String applicationNumber;
    private String dataXml;
    @Type(type = "jsonb")
    private String dataJson;
    private String formContentUri;
    private LocalDateTime submittedDate;
    private String citizenGuid;
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
