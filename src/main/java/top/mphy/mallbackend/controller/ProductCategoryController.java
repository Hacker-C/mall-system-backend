package top.mphy.mallbackend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.mphy.mallbackend.entity.Product;
import top.mphy.mallbackend.entity.ProductCategory;
import top.mphy.mallbackend.service.ProductCategoryService;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/category")
public class ProductCategoryController {

    private final ProductCategoryService productCategoryService;

    public ProductCategoryController(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @GetMapping("/all")
    public List<ProductCategory> findAll() {
        return productCategoryService.findAll();
    }


    // 根据 category_id 查询此类所有商品
    // {id}是占位符，接口示例：http://127.0.0.1:8080/user/6
    @GetMapping("/{categoryId}")
    public List<Product> deleteById(@PathVariable("categoryId") BigInteger categoryId) {
        return productCategoryService.findById(categoryId);
    }
}
