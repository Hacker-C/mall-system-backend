package top.mphy.mallbackend.service;

import org.springframework.stereotype.Service;
import top.mphy.mallbackend.entity.Product;
import top.mphy.mallbackend.entity.ProductCategory;
import top.mphy.mallbackend.mapper.ProductCategoryMapper;

import java.math.BigInteger;
import java.util.List;

@Service
public class ProductCategoryService {

    private ProductCategoryMapper productCategoryMapper;

    public ProductCategoryService(ProductCategoryMapper productCategoryMapper) {
        this.productCategoryMapper = productCategoryMapper;
    }

    // *查询所有商品类别数据
    public List<ProductCategory> findAll() {
        return productCategoryMapper.findAll();
    }

    // 根据 category_id 查询此类所有商品
    public List<Product> findById(BigInteger categoryId) {
        return productCategoryMapper.findById(categoryId);
    }

}
