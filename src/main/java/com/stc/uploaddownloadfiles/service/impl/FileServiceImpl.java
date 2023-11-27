package com.stc.uploaddownloadfiles.service.impl;

import com.stc.uploaddownloadfiles.exceptions.DBException;
import com.stc.uploaddownloadfiles.model.dto.FileDto;
import com.stc.uploaddownloadfiles.model.dto.FileMetadata;
import com.stc.uploaddownloadfiles.model.dto.FileResponseDto;
import com.stc.uploaddownloadfiles.model.dto.SavedFileDto;
import com.stc.uploaddownloadfiles.model.entity.File;
import com.stc.uploaddownloadfiles.model.entity.Item;
import com.stc.uploaddownloadfiles.model.enums.ErrorCode;
import com.stc.uploaddownloadfiles.model.enums.ItemType;
import com.stc.uploaddownloadfiles.repository.FileRepository;
import com.stc.uploaddownloadfiles.repository.ItemRepository;
import com.stc.uploaddownloadfiles.service.FileService;
import com.stc.uploaddownloadfiles.utils.SecurityUtils;
import com.stc.uploaddownloadfiles.utils.impl.FolderUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    private final FileRepository fileRepository;

    private final ItemRepository itemRepository;

    private final SecurityUtils securityUtils;

    public FileServiceImpl(FileRepository fileRepository, ItemRepository itemRepository, SecurityUtils securityUtils) {
        this.fileRepository = fileRepository;
        this.itemRepository = itemRepository;
        this.securityUtils = securityUtils;
    }

    @Override
    public FileResponseDto upload(FileDto fileRequest) {
        Item item = itemRepository.findById(fileRequest.getParentId()).orElseThrow(() -> new DBException(ErrorCode.STC_DB));
        securityUtils.authenticate(item);
        String path = item.getPath() + "/" + fileRequest.getName() + "." + fileRequest.getExtension();
        FolderUtils.createFile(path, fileRequest.getContent());
        SavedFileDto savedFile = persist(fileRequest, item);
        return new FileResponseDto(savedFile.getName(), savedFile.getPath(), savedFile.getId());
    }

    @Override
    public byte[] download(Long id) {
        File file = fileRepository.findById(id).orElseThrow(() -> new DBException(ErrorCode.STC_DB));
        Item item = itemRepository.findById(file.getItem().getId()).get();
        securityUtils.authenticateDownload(item);
        return file.getContent();
    }

    private SavedFileDto persist(FileDto fileDto, Item file) {
        Item item = new Item();
        item.setPath(file.getPath() + "/" + fileDto.getName() + "." + fileDto.getExtension());
        item.setPermissionGroup(file.getPermissionGroup());
        item.setType(ItemType.FILE);
        item.setName(fileDto.getName() + "." + fileDto.getExtension());
        item.setParentId(fileDto.getParentId());
        Item savedItem = itemRepository.save(item);
        File fileToBeSaved = new File();
        fileToBeSaved.setItem(savedItem);
        fileToBeSaved.setContent(fileDto.getContent());
        File saveFile = fileRepository.save(fileToBeSaved);
        return new SavedFileDto(item.getName(), item.getPath(), saveFile.getId());
    }

    @Override
    public FileMetadata getMetaData(Long id) {
        List<Item> metaDataById = itemRepository.findMetaDataById(id);
        if(metaDataById.isEmpty())
            throw new DBException(ErrorCode.STC_DB);
        Item file = metaDataById.getFirst();
        securityUtils.authenticateDownload(file);
        return new FileMetadata(file.getId(), file.getName(), file.getPath());
    }
}
