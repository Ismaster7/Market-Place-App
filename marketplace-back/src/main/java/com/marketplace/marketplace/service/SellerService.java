package com.marketplace.marketplace.service;

import com.marketplace.marketplace.dtos.SellerRequestDto;
import com.marketplace.marketplace.dtos.SellerRequestPut;
import com.marketplace.marketplace.dtos.SellerResponse;
import com.marketplace.marketplace.exception.ResourceNotFound;
import com.marketplace.marketplace.mapper.SellerMapper;
import com.marketplace.marketplace.model.Seller;
import com.marketplace.marketplace.repository.SellerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerService {
    private final SellerRepository sellerRepository;
    private final SellerMapper sellerMapper;
    public SellerService(SellerRepository sellerRepository, SellerMapper sellerMapper){
        this.sellerRepository = sellerRepository;
        this.sellerMapper = sellerMapper;
    }

    public List<SellerResponse> getSellers(){
        List<Seller> sellers = sellerRepository.findAll();
        return sellerMapper.toDtoList(sellers);
    }

    public Seller findSellerById(Long id){
        return sellerRepository.findById(id).orElseThrow(()-> new ResourceNotFound("Id not found in database"));
    }


    public Seller saveSeller(SellerRequestDto sellerDto) {
        Seller sellerEntity = sellerMapper.toEntityPost(sellerDto);
        sellerRepository.save(sellerEntity);
        return sellerEntity;
    }

    public Seller updateSeller(SellerRequestPut sellerPut){
        Seller seller = sellerMapper.toEntityPut(sellerPut);
        Seller oldSeller = sellerRepository.findById(seller.getId()).orElseThrow(()-> new ResourceNotFound("Seller not found to update"));

        oldSeller.setName((oldSeller.getName() != seller.getName())
                && seller.getName() != null  ? seller.getName() : oldSeller.getName());
        oldSeller.setEmail((oldSeller.getEmail() != seller.getEmail())
                && seller.getEmail() != null  ? seller.getEmail() : oldSeller.getEmail());
        oldSeller.setLastName((oldSeller.getLastName() != seller.getLastName())
                && seller.getLastName() != null  ? seller.getLastName() : oldSeller.getLastName());
        return sellerRepository.save(oldSeller);
    }

    public Seller deleteSeller(Long id) {
        Seller seller = sellerRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Seller not found to delete"));
       sellerRepository.delete(seller);
        return seller;

    }

    public Seller getSeller(Long id){
        return sellerRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Seller not found"));
    }
}
