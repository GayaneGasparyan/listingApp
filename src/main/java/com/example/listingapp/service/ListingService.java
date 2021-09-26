package com.example.listingapp.service;

import com.example.listingapp.model.Listing;

import java.util.List;
import java.util.Optional;

public interface ListingService {

    List<Listing> getAllListings();

    Optional<Listing> getListingsById(int id);

    Listing addListing(Listing listing);

    List<Listing> getByUserEmail(String email);

    List<Listing> getByCategory(int categoryId);

    void deleteListingByID(int id);


}
