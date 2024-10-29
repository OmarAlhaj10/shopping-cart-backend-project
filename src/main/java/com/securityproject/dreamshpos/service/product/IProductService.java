package com.securityproject.dreamshpos.service.product;

import com.securityproject.dreamshpos.dto.ProductDto;
import com.securityproject.dreamshpos.model.Product;
import com.securityproject.dreamshpos.request.AddProductRequest;
import com.securityproject.dreamshpos.request.ProductUpdateRequest;

import java.util.List;

public interface IProductService {
    Product addProduct(AddProductRequest product);
    Product getProductById(Long id);
    void deleteProductById(Long id);
    Product updateProduct(ProductUpdateRequest product, Long productId);
    List<Product> getAllProducts();
    List<Product> getProductsByCategory(String category);
    List<Product> getProductsByBrand(String brand);
    List<Product> getProductsByCategoryAndBrand(String category, String brand);
    List<Product> getProductsByName(String name);
    List<Product> getProductsByBrandAndName(String category, String name);
    Long countProductsByBrandAndName(String brand, String name);

    List<ProductDto> getConvertedProducts(List<Product> products);

    ProductDto convertToDto(Product product);

    List<Product> findDistinctProductsByName();

    List<String> getAllDistinctBrands();
}