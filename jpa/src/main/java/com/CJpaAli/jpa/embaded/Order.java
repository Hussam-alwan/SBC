package com.CJpaAli.jpa.embaded;

import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ORDER_TBL")
public class Order {
    @EmbeddedId
    private OrderId orderId;
    @Embedded
    private Address address;
    private String orderInfo;
    private String anotherField;
}
