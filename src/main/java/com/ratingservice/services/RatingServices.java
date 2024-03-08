package com.ratingservice.services;

import com.ratingservice.entity.Rating;

import java.util.List;

public interface RatingServices {
    List<Rating> getAllRatings();
    Rating getRatingById(String ratingId);
    Rating addRating(Rating rating);
    void deleteRating(String ratingId);
    List<Rating> getRatingsByHotelId(String hotelId);
    List<Rating> getRatingsByUserId(String userId);
}
