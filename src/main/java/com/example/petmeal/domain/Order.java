package com.example.petmeal.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;
    @Column(name="buyer_id")
    private Long buyerId;
    @Column
    private Long products_id;
    @Column
    private String r_name;
    @Column
    private String r_petname;
    @Column
    private String r_phonenumber;
    @Column
    private String r_address;
    @Column
    private String deposit_name;
    @Column
    private String deposit_bank;
    @Column
    private Long quantity;


    @Builder
    public Order(Long buyer_id, Long products_id, String r_name, String r_petname, String r_phonenumber, String r_address, String deposit_name, String deposit_bank, Long quantity) {
        this.buyerId = buyer_id;
        this.products_id = products_id;
        this.r_name = r_name;
        this.r_petname=r_petname;
        this.r_phonenumber=r_phonenumber;
        this.r_address=r_address;
        this.deposit_name=deposit_name;
        this.deposit_bank=deposit_bank;
        this.quantity=quantity;
        
        		
    }
}