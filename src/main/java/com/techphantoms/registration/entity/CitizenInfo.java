package com.techphantoms.registration.entity;

import lombok.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class CitizenInfo {
    private long citizenInfoId;
    private String citizenGuid;
    private String citizenRegistrationNumber;
    private Timestamp citizenRegistrationDate;
    private String firstName;
    private String middleName;
    private String lastName;
    private String gender;
    private String mobileNumber;
    private String emailId;
    private String fatherName;
    private Date dateOfBirth;
    private Integer age;
    private String ekycData;
    private boolean isEkycVerified;
    private boolean isBlocked;
    private Timestamp blockedDateTime;
    private String blockedReason;
    private boolean isActive;
    private Timestamp deactiveDateTime;
    private String deactiveReason;
    private String createdBy;
    private Timestamp createdDate;
    private String createdIpAddr;
    private String createdMacAddr;
    private String createdRemarks;
    private String modifiedBy;
    private Timestamp modifiedDate;
    private String modifiedIpAddr;
    private String modifiedMacAddr;
    private String modifiedRemarks;
    private String countryCode;
    private String formDataXml;
    private Object formDataJson;
    private String loginId;
    private String pwd;
    private String salt;
    private String citizenType;
    private String authTypeCode;

}
