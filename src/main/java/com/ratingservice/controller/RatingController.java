package com.ratingservice.controller;

import com.ratingservice.entity.Rating;
import com.ratingservice.services.RatingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/ratings")
public class RatingController {

    @Autowired
    private RatingServices ratingServices;

    @GetMapping
    ResponseEntity<List<Rating>> getAllRatings() {
        return ResponseEntity.ok(ratingServices.getAllRatings());
    }

    @GetMapping("/hotel/{hotelId}")
    ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable String hotelId) {
        return ResponseEntity.ok(ratingServices.getRatingsByHotelId(hotelId));
    }

    @GetMapping("/user/{userId}")
    ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable String userId) {
        return ResponseEntity.ok(ratingServices.getRatingsByUserId(userId));
    }

    @GetMapping("/{ratingId}")
    ResponseEntity<Rating> getRatingById(@PathVariable String ratingId) {
        return ResponseEntity.ok(ratingServices.getRatingById(ratingId));
    }

    @PostMapping
    ResponseEntity<Rating> addRating(@RequestBody Rating rating) {
        Rating ratingAdded = ratingServices.addRating(rating);
        return new ResponseEntity<>(ratingAdded, HttpStatus.CREATED);
    }

    @PostMapping("/addRatings")
    ResponseEntity<List<Rating>> addRatings(@RequestBody List<Rating> ratings) {
        List<Rating> ratingsAdded = new ArrayList<>();
        for (Rating rating : ratings) {
            ratingsAdded.add(ratingServices.addRating(rating));
        }
        return new ResponseEntity<>(ratingsAdded, HttpStatus.CREATED);
    }
    @DeleteMapping("/{ratingId}")
    ResponseEntity<Void> deleteRating(@PathVariable String ratingId) {
        ratingServices.deleteRating(ratingId);
        return ResponseEntity.noContent().build();
    }
}
