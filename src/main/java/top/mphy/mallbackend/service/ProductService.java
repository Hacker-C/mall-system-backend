package top.mphy.mallbackend.service;

import org.springframework.stereotype.Service;
import top.mphy.mallbackend.entity.Product;
import top.mphy.mallbackend.entity.ProductCategory;
import top.mphy.mallbackend.mapper.ProductMapper;

import java.math.BigInteger;
import java.util.List;

@Service
public class ProductService {

    private final ProductMapper productMapper;

    public ProductService(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    // *查询所有商品数据
    public List<Product> findAll() {
        return productMapper.findAll();
    }

    // *根据商品ID查询指定商品
    public Product findOne(BigInteger id) {
        return productMapper.findOne(id);
    }

}
