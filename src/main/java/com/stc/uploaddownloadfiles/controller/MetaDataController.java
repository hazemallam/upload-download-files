package com.stc.uploaddownloadfiles.controller;

import com.stc.uploaddownloadfiles.model.Response;
import com.stc.uploaddownloadfiles.model.dto.FileMetadata;
import com.stc.uploaddownloadfiles.model.enums.ResponseStatus;
import com.stc.uploaddownloadfiles.service.FileService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MetaDataController {

    private final FileService fileService;

    public MetaDataController(FileService fileService) {
        this.fileService = fileService;
    }

    @QueryMapping
    public ResponseEntity<Response<FileMetadata>> getFileMetadata(@Argument Long id){

        return ResponseEntity.ok(new Response<>(ResponseStatus.SUCCESS, fileService.getMetaData(id)));

    }
}
