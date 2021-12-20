package top.mphy.mallbackend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.mphy.mallbackend.common.ResponseData;
import top.mphy.mallbackend.common.ResponseDataUtils;
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

    // 添加分类
    @PostMapping
    public ResponseData<?> addCategory(@RequestBody ProductCategory productCategory) {
        productCategoryService.addCategory(productCategory);
        return ResponseDataUtils.buildSuccess("0", "添加分类成功！");
    }

    // 编辑分类
    @PutMapping
    public ResponseData<?> setCategory(@RequestBody ProductCategory productCategory) {
        productCategoryService.setCategory(productCategory);
        return ResponseDataUtils.buildSuccess("0", "修改分类成功！");
    }
}
