package com.example.threadScheduler.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDtoV1 {
    private String orderId;
    private String customerId;
    private String orderDate;
    private String status;
    private Double totalAmount;
    private AddressDtoV1 shippingAddress;
    private AddressDtoV1 billingAddress;
    private List<ItemDtoV1> items;
    private PaymentDtoV1 paymentDetails;
    private String deliveryDate;
    private String createdBy;
    private String updatedBy;
}