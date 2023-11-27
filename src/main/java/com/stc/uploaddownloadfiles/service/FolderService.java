package com.stc.uploaddownloadfiles.service;

import com.stc.uploaddownloadfiles.model.dto.FolderDto;
import com.stc.uploaddownloadfiles.model.dto.ItemResponseDto;

public interface FolderService {
    ItemResponseDto createFolder(FolderDto folder);
}
