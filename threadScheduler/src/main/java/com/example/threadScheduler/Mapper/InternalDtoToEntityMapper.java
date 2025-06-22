package com.example.threadScheduler.Mapper;

import com.example.threadScheduler.Dto.InternalDtoV1;
import com.example.threadScheduler.Entity.InternalOrderEntityV1;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InternalDtoToEntityMapper {

    @Mapping(target = "orderId", source = "orderId")
    @Mapping(target = "customerId", source = "customerId")
    @Mapping(target = "orderDate", source = "orderDate")
    @Mapping(target = "status", source = "status")
    @Mapping(target = "totalAmount", source = "totalAmount")
    @Mapping(target = "shippingStreet", source = "shippingStreet")
    @Mapping(target = "shippingCity", source = "shippingCity")
    @Mapping(target = "shippingState", source = "shippingState")
    @Mapping(target = "shippingZipCode", source = "shippingZipCode")
    @Mapping(target = "shippingCountry", source = "shippingCountry")
    @Mapping(target = "billingStreet", source = "billingStreet")
    @Mapping(target = "billingCity", source = "billingCity")
    @Mapping(target = "billingState", source = "billingState")
    @Mapping(target = "billingZipCode", source = "billingZipCode")
    @Mapping(target = "billingCountry", source = "billingCountry")
    @Mapping(target = "deliveryDate", source = "deliveryDate")
    @Mapping(target = "createdBy", source = "createdBy")
    @Mapping(target = "updatedBy", source = "updatedBy")
    @Mapping(target = "paymentId", source = "paymentId")
    @Mapping(target = "paymentMethod", source = "paymentMethod")
    @Mapping(target = "transactionId", source = "transactionId")
    @Mapping(target = "paidAmount", source = "paidAmount")
    @Mapping(target = "paymentConfirmed", source = "paymentConfirmed")
    @Mapping(target = "itemIds", source = "itemIds")
    @Mapping(target = "itemNames", source = "itemNames")
    @Mapping(target = "itemCategories", source = "itemCategories")
    @Mapping(target = "itemQuantities", source = "itemQuantities")
    @Mapping(target = "itemPrices", source = "itemPrices")
    @Mapping(target = "totalItemValue", source = "totalItemValue")
    InternalOrderEntityV1 mapToInternalOrderEntityV1(InternalDtoV1 dto);

    List<InternalOrderEntityV1> mapToInternalOrderEntityV1(List<InternalDtoV1> dtos);
}
