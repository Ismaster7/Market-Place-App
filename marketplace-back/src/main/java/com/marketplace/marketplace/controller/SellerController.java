package com.marketplace.marketplace.controller;

import com.marketplace.marketplace.dtos.SellerRequestDto;
import com.marketplace.marketplace.dtos.SellerRequestPut;
import com.marketplace.marketplace.dtos.SellerResponse;
import com.marketplace.marketplace.model.Seller;
import com.marketplace.marketplace.repository.SellerRepository;
import com.marketplace.marketplace.service.SellerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1")
public class SellerController {

    public final SellerService sellerService;
    public SellerController(SellerService sellerService){
        this.sellerService = sellerService;
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<SellerResponse> getSellers(){
        return sellerService.getSellers();
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Seller> getSellerById(@PathVariable(name = "id") Long id){
        return ResponseEntity.status(HttpStatus.FOUND).body(sellerService.findSellerById(id));
    }

    @PostMapping
    public ResponseEntity<Seller> saveSeller(@RequestBody  @Valid SellerRequestDto seller){
       return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(sellerService.saveSeller(seller));
    }

    @PutMapping
    public ResponseEntity<Seller> updateSeller(@RequestBody @Valid SellerRequestPut seller){
        return ResponseEntity.status(HttpStatus.FOUND).body(sellerService.updateSeller(seller));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Seller> deleteSeller(@PathVariable(name = "id") Long id){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(sellerService.deleteSeller(id));
    }

}
