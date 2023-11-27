package com.stc.uploaddownloadfiles.service;

import com.stc.uploaddownloadfiles.model.dto.FileDto;
import com.stc.uploaddownloadfiles.model.dto.FileMetadata;
import com.stc.uploaddownloadfiles.model.dto.FileResponseDto;
import com.stc.uploaddownloadfiles.model.entity.Item;

public interface FileService {
    FileResponseDto upload (FileDto fileRequest);

    byte[] download(Long id);

    FileMetadata getMetaData(Long id);
}
