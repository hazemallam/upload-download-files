package com.stc.uploaddownloadfiles.repository;

import com.stc.uploaddownloadfiles.model.entity.PermissionGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PermissionGroupRepository extends JpaRepository<PermissionGroup, Long> {
    Optional<PermissionGroup> getPermissionGroupById(Long id);
}
