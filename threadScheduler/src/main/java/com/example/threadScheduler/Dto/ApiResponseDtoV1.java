package com.example.threadScheduler.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponseDtoV1 {
    private String orderId;
    private String statusMessage;
    private String status;
    private OrderDtoV1 data;
}