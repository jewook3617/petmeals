package com.example.petmeal.domain;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AccessLevel;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Products {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title1;
    
    @Column(length = 500, nullable = false)
    private String title2;

    @Column
    private String img_dir;

    @Column
    private String desc1;
    
    @Column
    private String desc2;
    
    @Column
    private String protein;

    @Column
    private String fat;
    
    @Column
    private String fiber;
    
    @Column
    private String moisture;
    
    @Column
    private String calorie;
    
    @Column
    private String color;
    
    @Column
    private Float price;
    
    @Builder
    public Products(String title1, String title2, String img_dir, String desc1, String desc2, String protein, String fat, String fiber, String moisture, String calorie, String color, Float price) {
        this.title1 = title1;
        this.title2 = title2;
        this.img_dir = img_dir;
        this.desc1=desc1;
        this.desc2=desc2;
        this.protein=protein;
        this.fat=fat;
        this.fiber=fiber;
        this.moisture=moisture;
        this.calorie=calorie;
        this.color=color;
        this.price=price;
    }
}