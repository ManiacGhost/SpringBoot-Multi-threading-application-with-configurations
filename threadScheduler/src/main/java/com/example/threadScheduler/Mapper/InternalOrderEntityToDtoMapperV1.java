package com.example.threadScheduler.Mapper;

import com.example.threadScheduler.Dto.*;
import com.example.threadScheduler.Entity.InternalOrderEntityV1;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface InternalOrderEntityToDtoMapperV1 {

    @Mapping(target = "shippingAddress", expression = "java(mapShippingAddress(entity))")
    @Mapping(target = "billingAddress", expression = "java(mapBillingAddress(entity))")
    @Mapping(target = "paymentDetails", expression = "java(mapPaymentDetails(entity))")
    @Mapping(target = "items", expression = "java(mapItems(entity))")
    OrderDtoV1 toOrderDto(InternalOrderEntityV1 entity);

    List<OrderDtoV1> toOrderDtoList(List<InternalOrderEntityV1> entityList);

    // Helper for shipping address
    default AddressDtoV1 mapShippingAddress(InternalOrderEntityV1 entity) {
        return AddressDtoV1.builder()
                .street(entity.getShippingStreet())
                .city(entity.getShippingCity())
                .state(entity.getShippingState())
                .zipCode(entity.getShippingZipCode())
                .country(entity.getShippingCountry())
                .build();
    }

    // Helper for billing address
    default AddressDtoV1 mapBillingAddress(InternalOrderEntityV1 entity) {
        return AddressDtoV1.builder()
                .street(entity.getBillingStreet())
                .city(entity.getBillingCity())
                .state(entity.getBillingState())
                .zipCode(entity.getBillingZipCode())
                .country(entity.getBillingCountry())
                .build();
    }

    // Helper for payment
    default PaymentDtoV1 mapPaymentDetails(InternalOrderEntityV1 entity) {
        return PaymentDtoV1.builder()
                .paymentId(entity.getPaymentId())
                .paymentMethod(entity.getPaymentMethod())
                .transactionId(entity.getTransactionId())
                .paidAmount(entity.getPaidAmount())
                .paymentConfirmed(entity.getPaymentConfirmed())
                .build();
    }

    // Helper for item list
    default List<ItemDtoV1> mapItems(InternalOrderEntityV1 entity) {
        if (entity.getItemIds() == null) return new ArrayList<>();

        String[] ids = entity.getItemIds().split(",");
        String[] names = entity.getItemNames() != null ? entity.getItemNames().split(",") : new String[0];
        String[] categories = entity.getItemCategories() != null ? entity.getItemCategories().split(",") : new String[0];
        String[] quantities = entity.getItemQuantities() != null ? entity.getItemQuantities().split(",") : new String[0];
        String[] prices = entity.getItemPrices() != null ? entity.getItemPrices().split(",") : new String[0];

        List<ItemDtoV1> items = new ArrayList<>();
        for (int i = 0; i < ids.length; i++) {
            ItemDtoV1 item = new ItemDtoV1();
            item.setItemId(ids[i]);
            item.setItemName(i < names.length ? names[i] : null);
            item.setCategory(i < categories.length ? categories[i] : null);
            item.setQuantity(i < quantities.length ? Integer.parseInt(quantities[i]) : 0);
            item.setPrice(i < prices.length ? Double.parseDouble(prices[i]) : 0.0);
            items.add(item);
        }

        return items;
    }
}
