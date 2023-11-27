package com.stc.uploaddownloadfiles.service;

import com.stc.uploaddownloadfiles.model.dto.SpaceDto;
import com.stc.uploaddownloadfiles.model.dto.ItemResponseDto;

public interface SpaceService {

    ItemResponseDto createSpace(SpaceDto space);
}
