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
@Table(name = "user_info")
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "user_info_id", nullable = false)
    private Long userInfoId;

    @Id
    @Column(name = "user_guid", nullable = false)
    private String userGuid;

    @Column(name = "user_registration_number", nullable = false)
    private String userRegistrationNumber;

    @Column(name = "user_registration_date", nullable = false)
    private Date userRegistrationDate;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @Column(name = "email_id", nullable = false)
    private String emailId;

    @Column(name = "father_name")
    private String fatherName;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "age")
    private Long age;

    @Column(name = "ekyc_data", nullable = false)
    private String ekycData;

    @Column(name = "is_ekyc_verified", nullable = false)
    private String ekycVerified;

    @Column(name = "is_blocked", nullable = false)
    private String blocked;

    @Column(name = "blocked_date_time")
    private Date blockedDateTime;

    @Column(name = "blocked_reason")
    private String blockedReason;

    @Column(name = "is_active", nullable = false)
    private String active;

    @Column(name = "deactive_date_time")
    private Date deactiveDateTime;

    @Column(name = "deactive_reason")
    private String deactiveReason;

    @Column(name = "created_by", nullable = false)
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

    @Column(name = "country_code")
    private String countryCode;

    @Column(name = "form_data_xml")
    private String formDataXml;

    @Column(name = "form_data_json")
    private String formDataJson;

    @Column(name = "login_id")
    private String loginId;

    @Column(name = "pwd")
    private String pwd;

    @Column(name = "salt")
    private String salt;

    @Column(name = "user_type")
    private String userType;

    @Column(name = "auth_type_code")
    private String authTypeCode;

}
