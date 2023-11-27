package com.stc.uploaddownloadfiles.repository;

import com.stc.uploaddownloadfiles.model.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionsRepository extends JpaRepository<Permission, Long> {
}
