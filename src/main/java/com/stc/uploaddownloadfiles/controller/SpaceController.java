package com.stc.uploaddownloadfiles.controller;

import com.stc.uploaddownloadfiles.model.Response;
import com.stc.uploaddownloadfiles.model.dto.SpaceDto;
import com.stc.uploaddownloadfiles.model.dto.ItemResponseDto;
import com.stc.uploaddownloadfiles.model.enums.ResponseStatus;
import com.stc.uploaddownloadfiles.service.SpaceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/space")
public class SpaceController {

    private final SpaceService spaceService;

    public SpaceController(SpaceService spaceService) {
        this.spaceService = spaceService;
    }

    @PostMapping("/create")
    public ResponseEntity<Response<ItemResponseDto>> createSpace(@RequestBody SpaceDto space){
        return ResponseEntity.ok(new Response<>(ResponseStatus.SUCCESS, spaceService.createSpace(space)));
    }
}
