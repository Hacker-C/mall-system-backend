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

    // *获取所有商品
    @GetMapping("/all")
    public List<Product> findAll() {
        return productService.findAll();
    }

    // *根据商品ID查询指定商品
    @GetMapping("/{id}")
    public Product findOne(@PathVariable("id") BigInteger id) {
        return productService.findOne(id);
    }

    // *查询最新上架商品：指定日期之后
    @GetMapping("/new")
    public List<Product> finNew() {
        return productService.findNew();
    }

    // *查询热门商品，销量高于指定售货量的商品
    @GetMapping("/hot")
    public List<Product> findHot() {
        return productService.findHot();
    }

}
