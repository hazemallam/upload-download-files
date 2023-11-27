package com.stc.uploaddownloadfiles.controller;

import com.stc.uploaddownloadfiles.model.Response;
import com.stc.uploaddownloadfiles.model.dto.FolderDto;
import com.stc.uploaddownloadfiles.model.dto.ItemResponseDto;
import com.stc.uploaddownloadfiles.model.enums.ResponseStatus;
import com.stc.uploaddownloadfiles.service.FolderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/folder")
public class FolderController {

    private final FolderService folderService;


    public FolderController(FolderService folderService) {
        this.folderService = folderService;
    }

    @PostMapping("/create")
    public ResponseEntity<Response<ItemResponseDto>> createFolder(@RequestBody FolderDto folder){

        return ResponseEntity.ok(new Response<>(ResponseStatus.SUCCESS, folderService.createFolder(folder)));
    }
}
