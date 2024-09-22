package com.halmira.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @ElementCollection
    private List<String> locations = new ArrayList<>();

    @OneToMany
    private List<Review> reviews = new ArrayList<>();

    // Calculate average rating based on reviews
    public double getAverageRating() {
        return reviews.stream().mapToInt(Review::getWorkLifeBalance).average().orElse(0.0);
    }

    public Company(String name, String locations) {
        this.name = name;
        this.locations.add(locations);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getLocations() {
        return locations;
    }

    public void setLocations(List<String> locations) {
        this.locations = locations;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
