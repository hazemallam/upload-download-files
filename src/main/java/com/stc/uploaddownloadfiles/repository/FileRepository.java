package com.stc.uploaddownloadfiles.repository;

import com.stc.uploaddownloadfiles.model.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {
}
