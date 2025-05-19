package com.example.threadScheduler.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentDto {
    private String paymentId;
    private String paymentMethod;
    private String transactionId;
    private Double paidAmount;
    private Boolean paymentConfirmed;
}
