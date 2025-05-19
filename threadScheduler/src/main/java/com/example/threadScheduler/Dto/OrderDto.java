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
public class OrderDto {
    private String orderId;
    private String customerId;
    private String orderDate;
    private String status;
    private Double totalAmount;
    private AddressDto shippingAddress;
    private AddressDto billingAddress;
    private List<ItemDto> items;
    private PaymentDto paymentDetails;
    private String deliveryDate;
    private String createdBy;
    private String updatedBy;
}
