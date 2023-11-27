package com.stc.uploaddownloadfiles.repository;

import com.stc.uploaddownloadfiles.model.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query(value = "SELECT * FROM item i where i.id = :id", nativeQuery = true)
    List<Item> findMetaDataById(Long id);
}
