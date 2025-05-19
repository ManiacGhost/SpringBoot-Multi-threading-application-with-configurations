package com.example.threadScheduler.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InternalOrderDto {
    private String orderId;
    private String customerId;
    private String orderDate;
    private String status;
    private Double totalAmount;
    private String deliveryDate;
    private String createdBy;
    private String updatedBy;

    private String shippingStreet;
    private String shippingCity;
    private String shippingState;
    private String shippingZipCode;
    private String shippingCountry;

    private String billingStreet;
    private String billingCity;
    private String billingState;
    private String billingZipCode;
    private String billingCountry;

    private String paymentId;
    private String paymentMethod;
    private String transactionId;
    private Double paidAmount;
    private Boolean paymentConfirmed;

    private String itemIds;
    private String itemNames;
    private String itemCategories;
    private String itemQuantities;
    private String itemPrices;
    private Double totalItemValue;
}
