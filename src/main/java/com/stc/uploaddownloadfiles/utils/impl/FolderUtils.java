package com.stc.uploaddownloadfiles.utils.impl;

import com.stc.uploaddownloadfiles.exceptions.FolderAlreadyExistException;
import com.stc.uploaddownloadfiles.model.dto.SpaceDto;
import com.stc.uploaddownloadfiles.model.enums.ErrorCode;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FolderUtils {
    public static void createFolder(String path, String name) {
        Path folderPath = Paths.get(path + "/" + name);
        if (!Files.exists(folderPath)) {
            try {
                Files.createDirectory(folderPath);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            throw new FolderAlreadyExistException(ErrorCode.STC_401);
        }
    }

    public static void createFile(String path, byte[] content){
        try (FileOutputStream fos = new FileOutputStream(path)) {
            fos.write(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
