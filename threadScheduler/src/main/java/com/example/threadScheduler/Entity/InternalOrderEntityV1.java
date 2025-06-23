package com.example.threadScheduler.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "internal_orders",schema = "order_schema")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InternalOrderEntityV1 {

    @Id
    @Column(name = "order_id")
    private String orderId;

    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "order_date")
    private String orderDate;

    @Column(name = "status")
    private String status;

    @Column(name = "total_amount")
    private Double totalAmount;

    @Column(name = "delivery_date")
    private String deliveryDate;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "shipping_street")
    private String shippingStreet;

    @Column(name = "shipping_city")
    private String shippingCity;

    @Column(name = "shipping_state")
    private String shippingState;

    @Column(name = "shipping_zip_code")
    private String shippingZipCode;

    @Column(name = "shipping_country")
    private String shippingCountry;

    @Column(name = "billing_street")
    private String billingStreet;

    @Column(name = "billing_city")
    private String billingCity;

    @Column(name = "billing_state")
    private String billingState;

    @Column(name = "billing_zip_code")
    private String billingZipCode;

    @Column(name = "billing_country")
    private String billingCountry;

    @Column(name = "payment_id")
    private String paymentId;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "transaction_id")
    private String transactionId;

    @Column(name = "paid_amount")
    private Double paidAmount;

    @Column(name = "payment_confirmed")
    private Boolean paymentConfirmed;

    @Column(name = "item_ids")
    private String itemIds;

    @Column(name = "item_names")
    private String itemNames;

    @Column(name = "item_categories")
    private String itemCategories;

    @Column(name = "item_quantities")
    private String itemQuantities;

    @Column(name = "item_prices")
    private String itemPrices;

    @Column(name = "total_item_value")
    private Double totalItemValue;

    @Column(name = "is_Active")
    private boolean active;
}