package com.giv.giftproject.services.converters;

import com.giv.giftproject.domain.model.User;
import com.giv.giftproject.domain.model.WishList;
import com.giv.giftproject.domain.model.dto.WishListDTO;
import com.giv.giftproject.services.UserService;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

@ExtendWith(MockitoExtension.class)
public class WishListConverterTest {

    @InjectMocks
    private WishListConverter wishListConverter;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private UserService userService;

    @Test
    void shouldConvertWishListDTOtoWishList() {
        WishListDTO wishListDTO = new WishListDTO();
        wishListDTO.setName("name");
        wishListDTO.setDescription("description");
        wishListDTO.setIdUser(1234);
        WishList expected = new WishList();
        expected.setName("name");
        expected.setDescription("description");
        Mockito.when(modelMapper.map(Mockito.any(), Mockito.any())).thenReturn(expected);
        User user = new User();
        user.setId(1234);
        Mockito.when(userService.searchUser(Mockito.anyInt())).thenReturn(user);

        WishList result = wishListConverter.convertDTOtoEntity(wishListDTO);
       
        Assertions.assertThat(result.getName()).isEqualTo(wishListDTO.getName());
        Assertions.assertThat(result.getDescription()).isEqualTo(wishListDTO.getDescription());
        Assertions.assertThat(result.getUsers().get(0).getId()).isEqualTo(wishListDTO.getIdUser());
    }
    
}
