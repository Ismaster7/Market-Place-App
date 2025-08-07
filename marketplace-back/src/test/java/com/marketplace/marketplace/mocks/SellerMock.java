package com.marketplace.marketplace.mocks;

import com.marketplace.marketplace.dtos.SellerRequestDto;
import com.marketplace.marketplace.dtos.SellerRequestPut;
import com.marketplace.marketplace.dtos.SellerResponse;
import com.marketplace.marketplace.model.Seller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SellerMock {
    public Seller mockEntity(){
        return mockEntity(0);
    }
    public SellerRequestDto mockDto(){
        return mockDto(0);
    }

    public SellerResponse mockResponse(){
        return mockResponse(0);
    }

    public SellerResponse mockResponse(Integer integer){
        SellerResponse sellerResponse = new SellerResponse(
                "Joana",
                "Arruda",
                "joana@email.com",
                new Date(), "F"
        );
    return sellerResponse;
    }

    public Seller mockEntity(Integer integer){
        Seller seller = new Seller();
        seller.setName("Ismael");
        seller.setLastName("Lima");
        seller.setEmail("ismael@email.com");
        seller.setBirthday(new Date());
        seller.setId((long) integer);
        return seller;
    }

    public SellerRequestDto mockDto(Integer integer){
        SellerRequestDto seller = new SellerRequestDto(
                "Ismael",
                "Lima",
                "ismael@email.com",
                new Date()
        );
        return  seller;
    }

    public SellerRequestPut mockDtoPut(Integer integer){
        SellerRequestPut seller = new SellerRequestPut(
                "Ismael",
                "Lima",
                "ismael@email.com",
                new Date()
        );
        return  seller;
    }

    public List<Seller> mockSellerList(){
        List<Seller> sellers = new ArrayList<Seller>();
        for(int i = 0; i < 10; i++){
            sellers.add(mockEntity(i));
        }
        return sellers;
    }

    public List<SellerRequestDto> mockSellerDtoList(){
        List<SellerRequestDto> sellers = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            sellers.add(mockDto(i));
        }
        return sellers;
    }

    public List<SellerResponse> getSellers(){
        List<SellerResponse> sellers = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            sellers.add(mockResponse(i));
        }
        return sellers;
    }
}
