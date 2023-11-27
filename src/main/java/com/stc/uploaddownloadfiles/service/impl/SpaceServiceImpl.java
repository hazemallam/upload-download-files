package com.stc.uploaddownloadfiles.service.impl;

import com.stc.uploaddownloadfiles.model.dto.ItemResponseDto;
import com.stc.uploaddownloadfiles.model.dto.SpaceDto;
import com.stc.uploaddownloadfiles.model.entity.Item;
import com.stc.uploaddownloadfiles.model.entity.PermissionGroup;
import com.stc.uploaddownloadfiles.model.enums.ItemType;
import com.stc.uploaddownloadfiles.repository.ItemRepository;
import com.stc.uploaddownloadfiles.repository.PermissionGroupRepository;
import com.stc.uploaddownloadfiles.service.SpaceService;
import com.stc.uploaddownloadfiles.utils.impl.FolderUtils;
import org.springframework.stereotype.Service;

@Service
public class SpaceServiceImpl implements SpaceService {

    private final ItemRepository itemRepository;

    private final PermissionGroupRepository permissionGroupRepository;

    public SpaceServiceImpl(ItemRepository itemRepository, PermissionGroupRepository permissionGroupRepository) {
        this.itemRepository = itemRepository;
        this.permissionGroupRepository = permissionGroupRepository;
    }

    @Override
    public ItemResponseDto createSpace(SpaceDto space) {
        FolderUtils.createFolder(space.getPath(), space.getName());
        Item item = persist(space);
        return new ItemResponseDto(item.getName(), item.getId());
    }

    private Item persist(SpaceDto space) {
        PermissionGroup permissionGroupById = permissionGroupRepository.getPermissionGroupById(space.getPermissionGroup()).orElseThrow();
        Item item = new Item();
        item.setName(space.getName());
        item.setType(ItemType.SPACE);
        item.setPermissionGroup(permissionGroupById);
        item.setPath(space.getPath() + "/" + space.getName());
        return itemRepository.save(item);
    }

}
