package com.myorganisation.wearly.dto.request;

import com.myorganisation.wearly.model.enums.ProductCategory;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ProductRequestDTO {
    private String name;
    private String description;
    private BigDecimal price;
    private Integer quantity;
    private String brand;
    private ProductCategory category;
    private String imageUrl;
}
