package com.marketplace.marketplace.service;

import com.marketplace.marketplace.dtos.SellerRequestDto;
import com.marketplace.marketplace.dtos.SellerRequestPut;
import com.marketplace.marketplace.dtos.SellerResponse;
import com.marketplace.marketplace.exception.RequiredObjectIsNull;
import com.marketplace.marketplace.mapper.SellerMapper;
import com.marketplace.marketplace.mocks.SellerMock;
import com.marketplace.marketplace.model.Seller;
import com.marketplace.marketplace.repository.SellerRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class SellerServiceTest {

    SellerMock input;

    @Mock
    private SellerRepository sellerRepository;

    @Mock
    private SellerMapper sellerMapper;

    @InjectMocks
    private SellerService sellerService;

    @BeforeEach
    void setUp() {
        input = new SellerMock(); // Instância do mock helper
    }

    @Test
    void findSellerById() {
        // Arrange (preparar)
        Seller seller = input.mockEntity(1);
        seller.setId(1L);

        when(sellerRepository.findById(1L)).thenReturn(Optional.of(seller));

        // Act (executar)
        var result = sellerService.findSellerById(1L);

        // Assert (verificar)
        assertNotNull(result);
        assertNotNull(result.getName());
        assertNotNull(result.getLastName());
        assertNotNull(result.getEmail());
        assertNotNull(result.getBirthday());

        assertEquals("Ismael", result.getName());
        assertEquals("Lima", result.getLastName());
    }

    @Test
    void shouldSaveASeller(){
        Seller seller = input.mockEntity(1);
        SellerRequestDto sellerDto = input.mockDto(1);

        Seller persisted = seller;
        when(sellerMapper.toEntityPost(sellerDto)).thenReturn(seller);
        when(sellerRepository.save(seller)).thenReturn(persisted);


        var result = sellerService.saveSeller(sellerDto);

        assertNotNull(result);
        assertNotNull(result.getLastName());
        assertNotNull(result.getName());
        assertNotNull(result.getEmail());


    }

    @Test
    public void shouldUpdateASeller(){
        Seller seller = input.mockEntity(1);
        SellerRequestPut sellerDto = input.mockDtoPut(1);

        Seller persisted = seller;
        when(sellerMapper.toEntityPut(sellerDto)).thenReturn(seller);
        when(sellerRepository.findById(1L)).thenReturn(Optional.of(seller));
        when(sellerRepository.save(seller)).thenReturn(persisted);


        var result = sellerService.updateSeller(sellerDto);

        assertNotNull(result);
        assertNotNull(result.getLastName());
        assertNotNull(result.getName());
        assertNotNull(result.getEmail());
    }

    @Test
    void shouldDeleteASeller(){
        Seller seller = input.mockEntity(1);
        when(sellerRepository.findById(1L)).thenReturn(Optional.of(seller));

        sellerService.deleteSeller(seller.getId());
        verify(sellerRepository, times(1)).findById(anyLong());
        verify(sellerRepository, times(1)).delete(any(Seller.class));
        verifyNoMoreInteractions(sellerRepository);
    }

    @Test
    void testCreateWithNullSeller(){
        Exception exception = assertThrows(RequiredObjectIsNull.class,
                () -> {
            sellerService.saveSeller(null);
            sellerService.updateSeller(null);
                });
        String expectedmessage = "It's not allowed to persist a null entity";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedmessage));

    }
    @Test
    void shouldGetAllSellers(){
        List<Seller> sellers = input.mockSellerList();
        List<SellerResponse> sellersDto = input.getSellers();

        when(sellerRepository.findAll()).thenReturn(sellers);
        when(sellerMapper.toDtoList(sellers)).thenReturn(sellersDto);

        List<SellerResponse> result = sellerService.getSellers();

        assertNotNull(result);
        assertEquals(10, result.size());

        var oneSeller = result.get(1);
        assertEquals("Joana", oneSeller.name());
        assertEquals("Arruda", oneSeller.lastName());
    }

}
