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
@Table(name = "email_sms_otp_token")
public class EmailSmsOtpToken implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "email_sms_otp_token_id", nullable = false)
    private Long emailSmsOtpTokenId;

    @Id
    @Column(name = "email_sms_otp_token_guid", nullable = false)
    private String emailSmsOtpTokenGuid;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @Column(name = "auth_token", nullable = false)
    private String authToken;

    @Column(name = "token_for", nullable = false)
    private String tokenFor;

    @Column(name = "token_generate_date_time", nullable = false)
    private Date tokenGenerateDateTime;

    @Column(name = "token_expiry_date_time", nullable = false)
    private Date tokenExpiryDateTime;

    @Column(name = "token_type", nullable = false)
    private String tokenType;

    @Column(name = "created_by", nullable = false)
    private String createdBy;

    @Column(name = "created_date", nullable = false)
    private Date createdDate;

    @Column(name = "created_ip_addr", nullable = false)
    private String createdIpAddr;

    @Column(name = "created_mac_addr")
    private String createdMacAddr;

    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "modified_date")
    private Date modifiedDate;

    @Column(name = "modified_ip_addr")
    private String modifiedIpAddr;

    @Column(name = "modified_mac_addr")
    private String modifiedMacAddr;

    @Column(name = "is_active", nullable = false)
    private String active;

    @Column(name = "failed_attempts")
    private Long failedAttempts;

}
