package com.example.threadScheduler.Mapper;

import com.example.threadScheduler.Dto.*;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface InternalOrderMapperV1 {

    InternalOrderMapperV1 INSTANCE = Mappers.getMapper(InternalOrderMapperV1.class);

    @Mapping(target = "shippingStreet", source = "shippingAddress.street")
    @Mapping(target = "shippingCity", source = "shippingAddress.city")
    @Mapping(target = "shippingState", source = "shippingAddress.state")
    @Mapping(target = "shippingZipCode", source = "shippingAddress.zipCode")
    @Mapping(target = "shippingCountry", source = "shippingAddress.country")
    @Mapping(target = "billingStreet", source = "billingAddress.street")
    @Mapping(target = "billingCity", source = "billingAddress.city")
    @Mapping(target = "billingState", source = "billingAddress.state")
    @Mapping(target = "billingZipCode", source = "billingAddress.zipCode")
    @Mapping(target = "billingCountry", source = "billingAddress.country")
    @Mapping(target = "paymentId", source = "paymentDetails.paymentId")
    @Mapping(target = "paymentMethod", source = "paymentDetails.paymentMethod")
    @Mapping(target = "transactionId", source = "paymentDetails.transactionId")
    @Mapping(target = "paidAmount", source = "paymentDetails.paidAmount")
    @Mapping(target = "paymentConfirmed", source = "paymentDetails.paymentConfirmed")
    @Mapping(target = "itemIds", expression = "java(flattenItemIds(orderDto.getItems()))")
    @Mapping(target = "itemNames", expression = "java(flattenItemNames(orderDto.getItems()))")
    @Mapping(target = "itemCategories", expression = "java(flattenItemCategories(orderDto.getItems()))")
    @Mapping(target = "itemQuantities", expression = "java(flattenItemQuantities(orderDto.getItems()))")
    @Mapping(target = "itemPrices", expression = "java(flattenItemPrices(orderDto.getItems()))")
    @Mapping(target = "totalItemValue", expression = "java(computeTotalValue(orderDto.getItems()))")
    InternalOrderDto mapToInternal(OrderDto orderDto);

    // Flattening helper methods

    default String flattenItemIds(List<ItemDto> items) {
        return items == null ? null : items.stream()
                .map(ItemDto::getItemId)
                .collect(Collectors.joining(","));
    }

    default String flattenItemNames(List<ItemDto> items) {
        return items == null ? null : items.stream()
                .map(ItemDto::getItemName)
                .collect(Collectors.joining(","));
    }

    default String flattenItemCategories(List<ItemDto> items) {
        return items == null ? null : items.stream()
                .map(ItemDto::getCategory)
                .collect(Collectors.joining(","));
    }

    default String flattenItemQuantities(List<ItemDto> items) {
        return items == null ? null : items.stream()
                .map(i -> String.valueOf(i.getQuantity()))
                .collect(Collectors.joining(","));
    }

    default String flattenItemPrices(List<ItemDto> items) {
        return items == null ? null : items.stream()
                .map(i -> String.valueOf(i.getPrice()))
                .collect(Collectors.joining(","));
    }

    default Double computeTotalValue(List<ItemDto> items) {
        return items == null ? 0.0 : items.stream()
                .mapToDouble(i -> i.getPrice() * i.getQuantity())
                .sum();
    }
}
