package com.example.hospital.controller;


import com.example.core.common.BaseResponse;
import com.example.hospital.model.ReviewDto;
import com.example.hospital.service.ReviewService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/review")
@Tag(name = "Review API", description = "Review API 입니다.")
public class ReviewController {
    private final ReviewService reviewService;
    private static final Logger logger = LogManager.getLogger(ReviewController.class);

    @PostMapping("/create")
    @Operation(summary = "리뷰 등록", description = "병원 방문 유저에게 리뷰 정보를 받아 등록하는 API입니다.")
    public ResponseEntity<ReviewDto.ReviewResponse> create (
            @RequestBody ReviewDto.ReviewRequest dto) {
        logger.info("Register review api");
        ReviewDto.ReviewResponse response = reviewService.create(dto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/read/{reviewIdx}")
    @Operation(summary = "리뷰 조회", description = "병원idx로 리뷰를 조회하는 API입니다.")
    public ResponseEntity<ReviewDto.ReviewResponse> read (
            @PathVariable Long reviewIdx) {
        logger.info("Read review api");
        ReviewDto.ReviewResponse response = reviewService.get(reviewIdx);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/list")
    @Operation(summary = "리뷰 리스트 조회", description = "병원 리뷰 리스트를 조회하는 API입니다.")
    public ResponseEntity<List<ReviewDto.ReviewResponse>> list () {
        logger.info("List review api");
        List<ReviewDto.ReviewResponse> response = reviewService.getList();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{reviewIdx}")
    @Operation(summary = "리뷰 삭제", description = "사용자가 병원 리뷰를 삭제하는 API입니다.")
    public BaseResponse<String> delete(@PathVariable Long reviewIdx) {
        logger.info("Delete review api");
        reviewService.delete(reviewIdx);
        return BaseResponse.success("Delete");
    }







}
