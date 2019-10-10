package com.example.petmeal.dto;



import com.example.petmeal.domain.Order;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateOrderDto {

	private Long buyer_id;
    private Long products_id;
    private String r_name;
    private String r_petname;
    private String r_phonenumber;
    private String r_address;
    private String deposit_name;
    private String deposit_bank;
    private Long quantity;

    public Order toEntity(){
        return Order.builder()
                .buyer_id(buyer_id)
                .products_id(products_id)
                .r_name(r_name)
                .r_petname(r_petname)
                .r_phonenumber(r_phonenumber)
                .r_address(r_address)
                .deposit_name(deposit_name)
                .deposit_bank(deposit_bank)
                .quantity(quantity)
                .build();
    }
}