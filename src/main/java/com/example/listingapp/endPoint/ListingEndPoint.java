package com.example.listingapp.endPoint;

import com.example.listingapp.model.Listing;
import com.example.listingapp.service.ListingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

@RequiredArgsConstructor
public class ListingEndPoint {

    private final ListingService listingService;

    @GetMapping("/listings")
    public List<Listing> getAllListing() {
        return listingService.getAllListings();
    }

    @GetMapping("/listings/byUser/{email}")
    public List<Listing> getByEmail(@PathVariable("email") String email) {
        return listingService.getByUserEmail(email);
    }

    @GetMapping("/listings/byCategory/{categoryId}")
    public List<Listing> getByCategoryId(@PathVariable("categoryId") int id) {
        return listingService.getByCategory(id);
    }


    @GetMapping("/listings/{id}")
    public Optional<Listing> getById(@PathVariable("id") int id) {
        return listingService.getListingsById(id);
    }

    @PostMapping("/listings")
    public void addListing(@RequestBody Listing listing) {
        listingService.addListing(listing);
    }

    @PutMapping("/listings")
    public Object updateListing(@RequestBody Listing listing) {
    return listingService.getListingsById(listing.getId());

    }

    @DeleteMapping("/listings/{id}")
    public void deleteListing(@PathVariable("id") int id) {
        listingService.deleteListingByID(id);
    }

}
