package lk.ijse.dep12.jpa.relationships.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orderItem")
@IdClass(OrderItemPK.class)
public class OrderItem {
    @Id
    @ManyToOne
    @JoinColumn(name = "order_id",referencedColumnName = "id")
    private Order order;
    @Id
    @ManyToOne
    @JoinColumn(name = "item_code",referencedColumnName = "code")
    private Item item;
    private int discount;
    private BigDecimal price;
}
