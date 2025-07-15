package com.myorganisation.wearly.service;

import com.myorganisation.wearly.dto.request.ProductRequestDTO;
import com.myorganisation.wearly.dto.response.GenericResponseDTO;
import com.myorganisation.wearly.dto.response.ProductResponseDTO;
import com.myorganisation.wearly.model.Product;
import com.myorganisation.wearly.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductResponseDTO addProduct(ProductRequestDTO productRequestDTO) {
        Product product = mapProductRequestDTOToProduct(productRequestDTO, new Product());

        productRepository.save(product);

        return mapProductToProductResponseDTO(product);
    }

    @Override
    public ProductResponseDTO getProductById(Long id) {
        return null;
    }

    @Override
    public Page<ProductResponseDTO> getProductPage(Integer pageNumber, Integer pageSize, String sortBy, String orderIn) {
        return null;
    }

    @Override
    public ProductResponseDTO updateProduct(Long id, ProductRequestDTO productRequestDTO) {
        return null;
    }

    @Override
    public GenericResponseDTO removeProduct(Long id) {
        return null;
    }

    //Helper methods

    //Map ProductRequestDTO to Product
    public Product mapProductRequestDTOToProduct(ProductRequestDTO productRequestDTO, Product product) {
        product.setName(productRequestDTO.getName());
        product.setDescription(productRequestDTO.getDescription());
        product.setPrice(productRequestDTO.getPrice());
        product.setQuantity(productRequestDTO.getQuantity());
        product.setBrand(productRequestDTO.getBrand());
        product.setCategory(productRequestDTO.getCategory());
        product.setImageUrl(productRequestDTO.getImageUrl());

        return product;
    }

    //Map Product to ProductResponseDTO
    public ProductResponseDTO mapProductToProductResponseDTO(Product product) {
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();

        productResponseDTO.setId(product.getId());
        productResponseDTO.setName(product.getName());
        productResponseDTO.setDescription(product.getDescription());
        productResponseDTO.setPrice(product.getPrice());
        productResponseDTO.setQuantity(product.getQuantity());
        productResponseDTO.setBrand(product.getBrand());
        productResponseDTO.setCategory(product.getCategory());
        productResponseDTO.setImageUrl(product.getImageUrl());
        productResponseDTO.setActive(product.getActive());
        productResponseDTO.setCreatedAt(product.getCreatedAt());
        productResponseDTO.setUpdatedAt(product.getUpdatedAt());
        productResponseDTO.setAverageRating(product.getAverageRating());
        productResponseDTO.setTotalReviews(product.getTotalReviews());

        return productResponseDTO;
    }
}
