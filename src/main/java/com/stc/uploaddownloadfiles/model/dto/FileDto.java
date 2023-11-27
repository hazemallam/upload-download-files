package com.stc.uploaddownloadfiles.model.dto;

public class FileDto {
    private String name;
    private String extension;
    private byte [] content;

    private Long parentId;
    public FileDto(String name, String extension, byte[] content, Long parentId) {
        this.name = name;
        this.extension = extension;
        this.content = content;
        this.parentId = parentId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
