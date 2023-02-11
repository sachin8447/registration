package com.techphantoms.registration.repository;

import com.techphantoms.registration.entity.EmailSmsOtpToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailSmsOtpTokenRepository extends JpaRepository<EmailSmsOtpToken, String>, JpaSpecificationExecutor<EmailSmsOtpToken> {

}