package lk.ijse.dep12.jpa.relationships.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "customer")
@ToString(exclude = "orders")
public class Customer implements Serializable {
    @Id
    private String id;
    private String name;
    private String address;
    @OneToMany(mappedBy = "customer",cascade = {CascadeType.PERSIST,CascadeType.DETACH})
    @Setter(AccessLevel.NONE)
    private List<Order> orders = new ArrayList<>();

    public Customer(String id, String name, String address, List<Order> orders) {
        if (orders != null && !orders.isEmpty()) {
            orders.stream().filter(order -> order.getCustomer()==null).
                    forEach(order -> order.setCustomer(this));
        }

        if (orders != null && !orders.isEmpty()) {
            orders.forEach(order -> {
                if (order.getCustomer() !=this)
                    throw new IllegalStateException("An Order:%sOrder is already associated with another customer".
                            formatted(order.getId()));
            });
        }
        this.id = id;
        this.name = name;
        this.address = address;
        this.orders = orders;
    }

    public Customer(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
}
