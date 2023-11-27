package com.stc.uploaddownloadfiles.model.dto;

public class FileResponseDto {

    private String name;
    private String path;

    private Long id;

    public FileResponseDto(String name, String path, Long id) {
        this.name = name;
        this.path = path;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
