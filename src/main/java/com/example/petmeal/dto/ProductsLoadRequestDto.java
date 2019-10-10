package com.example.petmeal.dto;


import com.example.petmeal.domain.Products;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductsLoadRequestDto {

    private String title1;
    private String title2;
    private String img_dir;

    public Products toEntity(){
        return Products.builder()
                .title1(title1)
                .title2(title2)
                .img_dir(img_dir)
                .build();
    }
}