package com.stc.uploaddownloadfiles.service.impl;

import com.stc.uploaddownloadfiles.exceptions.DBException;
import com.stc.uploaddownloadfiles.model.dto.FolderDto;
import com.stc.uploaddownloadfiles.model.dto.ItemResponseDto;
import com.stc.uploaddownloadfiles.model.entity.Item;
import com.stc.uploaddownloadfiles.model.enums.ErrorCode;
import com.stc.uploaddownloadfiles.model.enums.ItemType;
import com.stc.uploaddownloadfiles.repository.ItemRepository;
import com.stc.uploaddownloadfiles.service.FolderService;
import com.stc.uploaddownloadfiles.utils.impl.FolderUtils;
import com.stc.uploaddownloadfiles.utils.impl.SecurityUtilsImpl;
import org.springframework.stereotype.Service;

@Service
public class FolderServiceImpl implements FolderService {

    private final ItemRepository itemRepository;

    private final SecurityUtilsImpl securityUtils;


    public FolderServiceImpl(ItemRepository itemRepository, SecurityUtilsImpl securityUtils) {
        this.itemRepository = itemRepository;

        this.securityUtils = securityUtils;
    }

    @Override
    public ItemResponseDto createFolder(FolderDto folder) {
        Item item = itemRepository.findById(folder.getParentId()).orElseThrow(() -> new DBException(ErrorCode.STC_DB));
        securityUtils.authenticate(item);
        FolderUtils.createFolder(item.getPath(), folder.getName());
        Item savedItem = persist(folder, item);
        return new ItemResponseDto(savedItem.getName(), savedItem.getId());
    }

    private Item persist(FolderDto folder, Item space) {
        Item item = new Item();
        item.setPath(space.getPath() + "/" + folder.getName());
        item.setPermissionGroup(space.getPermissionGroup());
        item.setType(ItemType.FOLDER);
        item.setName(folder.getName());
        item.setParentId(folder.getParentId());
        return itemRepository.save(item);
    }

}
