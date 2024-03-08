package com.ratingservice.exceptions;

import com.ratingservice.payload.ApiErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    public ResponseEntity<ApiErrorResponse> handleRatingNotFound(RatingNotFound ratingNotFound) {
        String message = ratingNotFound.getMessage();
        ApiErrorResponse apiErrorResponse = ApiErrorResponse.builder()
                .message(message)
                .statusCode("404")
                .build();
        return ResponseEntity.status(404).body(apiErrorResponse);
    }
}
