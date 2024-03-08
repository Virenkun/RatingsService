package com.ratingservice.repository;

import com.ratingservice.entity.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingRepository extends MongoRepository<Rating, String> {
    List<Rating> findAllByHotelId(String hotelId);

    List<Rating> findAllByUserId(String userId);
}
