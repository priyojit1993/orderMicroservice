package com.priyojitpal.ordermicroservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderRequest {
    private String orderName;
    private String productId;
    private String productName;
    private String inventoryId;
}
