package top.mphy.mallbackend.controller;

import org.springframework.web.bind.annotation.*;
import top.mphy.mallbackend.entity.Product;
import top.mphy.mallbackend.service.ProductService;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // 获取所有商品
    @GetMapping("/all")
    public List<Product> findAll() {
        return productService.findAll();
    }

}
