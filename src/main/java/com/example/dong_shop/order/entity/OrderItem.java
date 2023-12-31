package com.example.dong_shop.order.entity;

import com.example.dong_shop.item.entity.Item;
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
public class OrderItem extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    private int price;

    private int count;

    public static OrderItem createOrderItem(Item item, int count) {
        OrderItem orderItem = new OrderItem();
        orderItem.setItem(item);
        orderItem.setCount(count);

        orderItem.setPrice(item.getPrice());
        item.removeStock(count);

        return orderItem;
    }

    public int getTotalPrice() {
        return price * count;
    }

    public void cancel() {
        this.getItem().addStock(count);
    }
}
