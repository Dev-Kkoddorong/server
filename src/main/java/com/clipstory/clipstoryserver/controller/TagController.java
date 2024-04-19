package com.clipstory.clipstoryserver.controller;

import com.clipstory.clipstoryserver.global.response.ApiResponse;
import com.clipstory.clipstoryserver.global.response.Status;
import com.clipstory.clipstoryserver.responseDto.TagResponseDto;
import com.clipstory.clipstoryserver.service.TagService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tag")
@Tag(name = "tag", description = "태그 api")
public class TagController {

    private final TagService tagService;

    @Operation(summary = "태그 조회")
    @PostMapping("{tagId}")
    public ApiResponse<TagResponseDto> getTag(
            @PathVariable("tagId") Long tagId
    ) {
        TagResponseDto tagResponseDto =  tagService.getTag(tagId);
        return ApiResponse.onSuccess(Status.OK.getCode(), Status.OK.getMessage(), tagResponseDto);
    }

    @Operation(summary = "전체 태그 조회")
    @PostMapping("")
    public ApiResponse<List<TagResponseDto>> getAllTags() {
        List<TagResponseDto> tagResponseDtos = tagService.getAllTag();
        return ApiResponse.onSuccess(Status.OK.getCode(), Status.OK.getMessage(), tagResponseDtos);
    }

}
