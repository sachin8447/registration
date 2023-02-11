package com.techphantoms.registration.repository;

import com.techphantoms.registration.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, String>, JpaSpecificationExecutor<UserInfo> {

}