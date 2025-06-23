package com.example.threadScheduler.Service.CommonServiceImpl;

import com.example.threadScheduler.Dto.ApiResponseDtoV1;
import com.example.threadScheduler.Dto.OrderDtoV1;

import java.util.List;

public interface CommonService {
    ApiResponseDtoV1 saveOrderDetails(List<OrderDtoV1> orderDtoV1);
    ApiResponseDtoV1 deleteOrderDetails(String orderId);
    ApiResponseDtoV1 updateOrderDetails(OrderDtoV1 orderDtoV1);
    ApiResponseDtoV1 getOrderDetails(String orderId);
}
