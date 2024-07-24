package lk.ijse.dep12.jpa.relationships.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemPK implements Serializable {
    private Order order;
    private Item item;
}
