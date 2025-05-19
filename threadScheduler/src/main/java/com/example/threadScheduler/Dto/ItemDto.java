package com.example.threadScheduler.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {
    private String itemId;
    private String itemName;
    private Integer quantity;
    private Double price;
    private String category;
}
