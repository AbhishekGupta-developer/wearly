package com.myorganisation.wearly.service;

import com.myorganisation.wearly.dto.request.ProductRequestDTO;
import com.myorganisation.wearly.dto.response.GenericResponseDTO;
import com.myorganisation.wearly.dto.response.ProductResponseDTO;
import org.springframework.data.domain.Page;

public interface ProductService {
    ProductResponseDTO addProduct(ProductRequestDTO productRequestDTO);
    ProductResponseDTO getProductById(Long id);
    Page<ProductResponseDTO> getProductPage(Integer pageNumber, Integer pageSize, String sortBy, String orderIn);
    ProductResponseDTO updateProduct(Long id, ProductRequestDTO productRequestDTO);
    GenericResponseDTO removeProduct(Long id);
}
