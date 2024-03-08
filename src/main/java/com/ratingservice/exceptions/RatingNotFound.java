package com.ratingservice.exceptions;

public class RatingNotFound extends RuntimeException {
    public RatingNotFound(String ratingNotFound) {
        super(ratingNotFound);
    }

    public RatingNotFound() {
        super("Rating not found");
    }
}
