package com.marketplace.marketplace.controller;

import com.marketplace.marketplace.dtos.SellerRequestDto;
import com.marketplace.marketplace.dtos.SellerRequestPut;
import com.marketplace.marketplace.dtos.SellerResponse;
import com.marketplace.marketplace.model.Seller;
import com.marketplace.marketplace.repository.SellerRepository;
import com.marketplace.marketplace.service.SellerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class SellerController {

    public final SellerService sellerService;

    public SellerController(SellerService sellerService){
        this.sellerService = sellerService;
    }

    @GetMapping
    public List<SellerResponse> getSellers(){
        return sellerService.getSellers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Seller> getSellerById(@PathVariable(name = "id") Long id){
        return ResponseEntity.status(HttpStatus.FOUND).body(sellerService.findSellerById(id));
    }

    @PostMapping
    public ResponseEntity<Seller> saveSeller(@RequestBody  @Valid SellerRequestDto seller){
       return ResponseEntity.status(HttpStatus.CREATED).body(sellerService.saveSeller(seller));
    }

    @PutMapping
    public ResponseEntity<Seller> updateSeller(@RequestBody @Valid SellerRequestPut seller){
        return ResponseEntity.status(HttpStatus.FOUND).body(sellerService.updateSeller(seller));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Seller> deleteSeller(@PathVariable(name = "id") Long id){
        return ResponseEntity.status(HttpStatus.CREATED).body(sellerService.deleteSeller(id));
    }

}
