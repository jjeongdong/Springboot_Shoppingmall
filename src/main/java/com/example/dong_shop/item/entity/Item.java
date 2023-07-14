package com.example.dong_shop.item.entity;

import com.example.dong_shop.item.constant.ItemSellStatus;
import com.example.dong_shop.utils.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;            // 상품 코드

    @Column(nullable = false, length = 50)
    private String itemNm;      // 상품 이름

    @Column(nullable = false)
    private int price;          // 상품 가격

    @Column(nullable = false, name = "number")
    private int stockNumber;    // 상품 수량

    @Enumerated(EnumType.STRING)
    private ItemSellStatus itemSellStatus;

    @Lob
    @Column(nullable = false)
    private String itemDetail;  // 상품 상세 설명

}
