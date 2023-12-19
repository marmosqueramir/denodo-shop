package com.denodo.challenge.entity.prices;

import com.denodo.challenge.entity.util.SchemaVariables;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "prices", schema = SchemaVariables.SCHEMA_APP)
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "item_price")
    private Long itemPrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Long itemPrice) {
        this.itemPrice = itemPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return Objects.equals(id, price.id) && Objects.equals(itemPrice, price.itemPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, itemPrice);
    }

    @Override
    public String toString() {
        return "Price{" +
                "id=" + id +
                ", itemPrice=" + itemPrice +
                '}';
    }
}
