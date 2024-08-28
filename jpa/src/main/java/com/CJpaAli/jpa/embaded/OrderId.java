package com.CJpaAli.jpa.embaded;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class OrderId implements Serializable {

    private String userName;
    private LocalDateTime orderDate;
}
