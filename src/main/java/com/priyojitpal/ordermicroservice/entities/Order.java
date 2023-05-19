package com.priyojitpal.ordermicroservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @MongoId
    private String orderId;
    private String orderName;
    private String productId;
    private String productName;
    private String inventoryId;

}
