package com.example.threadScheduler.Service.CommonServiceImpl.CommonServiceImpl;

import com.example.threadScheduler.Dto.ApiResponseDtoV1;
import com.example.threadScheduler.Dto.InternalDtoV1;
import com.example.threadScheduler.Dto.OrderDtoV1;
import com.example.threadScheduler.Entity.InternalOrderEntityV1;
import com.example.threadScheduler.Mapper.InternalDtoToEntityMapper;
import com.example.threadScheduler.Mapper.InternalOrderMapperV1;
import com.example.threadScheduler.Repository.InternalOrderRepositoryV1;
import com.example.threadScheduler.Service.CommonServiceImpl.CommonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommonServiceImpl implements CommonService {

    private final InternalOrderMapperV1 internalOrderMapper;
    private final InternalOrderRepositoryV1 internalOrderRepositoryV1;
    private final InternalDtoToEntityMapper internalDtoToEntityMapper;

    public ApiResponseDtoV1 saveOrderDetails(List<OrderDtoV1> orderDtoV1) {
        ApiResponseDtoV1 apiResponseDtoV1 = new ApiResponseDtoV1();
        try{
            List<InternalDtoV1> internalDto = internalOrderMapper.toDtoList(orderDtoV1);
            List<InternalOrderEntityV1> mappedEntities = internalDtoToEntityMapper.mapToInternalOrderEntityV1(internalDto);
            if(!internalDto.isEmpty()){
                List<InternalOrderEntityV1> savedInternalDto = internalOrderRepositoryV1.saveAll(mappedEntities);
                if(!savedInternalDto.isEmpty()){
                    apiResponseDtoV1.setStatus(HttpStatus.OK.toString());
                    apiResponseDtoV1.setStatusMessage("Order details saved successfully");
                    apiResponseDtoV1.setOrderId(savedInternalDto.get(0).getOrderId());
                } else {
                    apiResponseDtoV1.setStatus(HttpStatus.EXPECTATION_FAILED.toString());
                    apiResponseDtoV1.setStatusMessage("Failed to save order details");
                }
            } else {
                apiResponseDtoV1.setStatus(HttpStatus.BAD_REQUEST.toString());
                apiResponseDtoV1.setStatusMessage("Order details are empty after mapping");
            }

        }
        catch(Exception e){
            log.error("Error while saving order details: {}", e.getMessage());
            apiResponseDtoV1.setStatus(HttpStatus.EXPECTATION_FAILED.toString());
            apiResponseDtoV1.setStatusMessage(e.getMessage());
        }
        return apiResponseDtoV1;
    }

}
