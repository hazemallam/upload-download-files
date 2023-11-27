package com.stc.uploaddownloadfiles.utils;

import com.stc.uploaddownloadfiles.model.entity.Item;

public interface SecurityUtils {
    void authenticate(Item item);
    void authenticateDownload(Item item);
}
