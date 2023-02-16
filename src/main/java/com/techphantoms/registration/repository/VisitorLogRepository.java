package com.techphantoms.registration.repository;

import com.techphantoms.registration.entity.VisitorLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitorLogRepository extends JpaRepository<VisitorLog, Long>, JpaSpecificationExecutor<VisitorLog> {

}