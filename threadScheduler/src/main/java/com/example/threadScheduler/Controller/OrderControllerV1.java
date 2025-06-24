package com.example.threadScheduler.Controller;

import com.example.threadScheduler.Dto.ApiResponseDtoV1;
import com.example.threadScheduler.Dto.OrderDtoV1;
import com.example.threadScheduler.Dto.OrderRequestDtoV1;
import com.example.threadScheduler.Service.CommonServiceImpl.CommonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
@Slf4j
public class OrderControllerV1 {
    private final CommonService commonService;

    @PostMapping("/save")
    public ResponseEntity<ApiResponseDtoV1> saveOrderDetails(
            @RequestBody(required = true) List<OrderDtoV1> orderDtoV1){
        ApiResponseDtoV1 response = new ApiResponseDtoV1();
        try{
            response = commonService.saveOrderDetails(orderDtoV1);
            if(response.getStatus() == null || response.getStatus().isEmpty()){
                response.setStatus("EXCEPTION");
                response.setStatusMessage("Failed to save order details");
            }
            log.info("Order details saved successfully with status: {}", response.getStatus());
        }catch(Exception e){
            log.error("Error while saving order details: {}", e.getMessage());
                response = ApiResponseDtoV1.builder()
                    .status("EXCEPTION")
                    .statusMessage(e.getMessage())
                    .build();
            return ResponseEntity.status(HttpStatusCode.valueOf(HttpStatus.BAD_REQUEST.value())).body(response);
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping("/delete")
    public ResponseEntity<ApiResponseDtoV1> deleteOrderDetails(
            @RequestBody(required = true) String orderId)
    {
        ApiResponseDtoV1 response = new ApiResponseDtoV1();
        try{
            response = commonService.deleteOrderDetails(orderId);
            if(response.getStatus() == null || response.getStatus().isEmpty()){
                response.setStatus("EXCEPTION");
                response.setStatusMessage("Failed to delete order details");
            }
            log.info("Order details deleted successfully with status: {}", response.getStatus());
        }catch(Exception e){
            log.error("Error while deleting order details: {}", e.getMessage());
            response = ApiResponseDtoV1.builder()
                    .status("EXCEPTION")
                    .statusMessage(e.getMessage())
                    .build();
            return ResponseEntity.status(HttpStatusCode.valueOf(HttpStatus.BAD_REQUEST.value())).body(response);
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping("/read")
    public ResponseEntity<ApiResponseDtoV1> getOrderDetails(
            @RequestBody OrderRequestDtoV1 requestDtoV1){

        ApiResponseDtoV1 response = new ApiResponseDtoV1();
        try{
            response = commonService.getOrderDetails(requestDtoV1.getOrderId());
            if(response.getStatus() == null || response.getStatus().isEmpty()){
                response.setStatus("EXCEPTION");
                response.setStatusMessage("Failed to fetch order details");
            }
            log.info("Order details fetched successfully with status: {}", response.getStatus());
        } catch (Exception e){
            log.error("Error while fetching order details");
            response = ApiResponseDtoV1.builder()
                    .status("EXCEPTION")
                    .statusMessage(e.getMessage())
                    .build();

            return ResponseEntity.status(HttpStatusCode.valueOf(HttpStatus.BAD_REQUEST.value())).body(response);
        }

        return ResponseEntity.ok(response);
    }

    @PostMapping("/update")
    public ResponseEntity<ApiResponseDtoV1> deleteOrderDetails(
            @RequestBody(required = true) OrderDtoV1 orderDtoV1)
    {
        ApiResponseDtoV1 response = new ApiResponseDtoV1();
        try{
            response = commonService.updateOrderDetails(orderDtoV1);
            if(response.getStatus() == null || response.getStatus().isEmpty()){
                response.setStatus("EXCEPTION");
                response.setStatusMessage("Failed to delete order details");
            }
            log.info("Order details deleted successfully with status: {}", response.getStatus());
        }catch(Exception e){
            log.error("Error while deleting order details: {}", e.getMessage());
            response = ApiResponseDtoV1.builder()
                    .status("EXCEPTION")
                    .statusMessage(e.getMessage())
                    .build();
            return ResponseEntity.status(HttpStatusCode.valueOf(HttpStatus.BAD_REQUEST.value())).body(response);
        }
        return ResponseEntity.ok(response);
    }

}
