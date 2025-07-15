package com.myorganisation.wearly.jobs;

import com.myorganisation.wearly.dto.request.ProductRequestDTO;
import com.myorganisation.wearly.model.enums.ProductCategory;
import com.myorganisation.wearly.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Random;

@Component
public class CronJobs {

    @Autowired
    private ProductService productService;

    private int productModel = 1;
    private BigDecimal productPrice = new BigDecimal("25000");


    //CRON job to add random product at every minute
    @Scheduled(cron = "0 * * * * ?")
    public void addRandomProduct() {
        Random quantity = new Random();

        ProductRequestDTO productRequestDTO = new ProductRequestDTO();

        int currentModel = productModel++;

        productRequestDTO.setName("zPhone " + currentModel);
        productRequestDTO.setDescription("It's a brand new zPhone series (" + currentModel + ") with latest features.");
        productRequestDTO.setPrice(productPrice);
        productRequestDTO.setQuantity(quantity.nextInt(100) + 1);
        productRequestDTO.setBrand("PineApple");
        productRequestDTO.setCategory(ProductCategory.ELECTRONICS);
        productRequestDTO.setImageUrl("your-product-image-url");

        productService.addProduct(productRequestDTO);
        productPrice = productPrice.multiply(new BigDecimal("1.5"));
    }


//
//    //CRON job runs at every five seconds
//    @Scheduled(cron = "*/5 * * * * ?")
//    public void jobRunsAtEveryMinute() {
//        System.out.println("Hello, " + flag++);
//    }

}
