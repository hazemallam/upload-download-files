package com.stc.uploaddownloadfiles.controller;

import com.stc.uploaddownloadfiles.model.Response;
import com.stc.uploaddownloadfiles.model.dto.FileDto;
import com.stc.uploaddownloadfiles.model.dto.FileMetadata;
import com.stc.uploaddownloadfiles.model.dto.FileResponseDto;
import com.stc.uploaddownloadfiles.model.enums.ResponseStatus;
import com.stc.uploaddownloadfiles.service.FileService;
import jakarta.annotation.Nonnull;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/file")
public class FileController {


    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping("/upload")
    public ResponseEntity<Response<FileResponseDto>> uploadFile(@Validated @Nonnull @RequestParam("name") String name,
                                                                @Nonnull @RequestParam("parentId") Long parentId,
                                                                @Nonnull @RequestParam("file")MultipartFile file){

        try {
            byte [] content = file.getBytes();
            String contentType = file.getContentType();
            String[] split = contentType.split("/");
            String originalFileName = file.getOriginalFilename();
            String extension = split[1];
            FileDto fileDto = new FileDto(name, extension, content, parentId);
            return ResponseEntity.ok(new Response<>(ResponseStatus.SUCCESS, fileService.upload(fileDto)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @GetMapping("/download")
    public ResponseEntity<byte[]> downloadFile(@Validated @Nonnull @RequestParam("name") String name, @Nonnull @RequestParam("id") Long id){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", MediaType.APPLICATION_OCTET_STREAM.toString());
        httpHeaders.add("Content-Disposition", "attachment; filename=" + name);
        return ResponseEntity.ok().headers(httpHeaders).body(fileService.download(id));
    }

    @GetMapping("/metadata/{id}")
    public ResponseEntity<Response<FileMetadata>> getFileMetadata(@PathVariable("id") Long id){

        return ResponseEntity.ok(new Response<>(ResponseStatus.SUCCESS, fileService.getMetaData(id)));

    }

}
