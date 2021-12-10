package top.mphy.mallbackend.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.mphy.mallbackend.entity.Product;
import top.mphy.mallbackend.entity.ProductCategory;

import java.math.BigInteger;
import java.util.List;

@Mapper
public interface ProductCategoryMapper {
    // 查询所有商品类别
    @Select("SELECT * FROM product_category")
    List<ProductCategory> findAll();

    // 根据 category_id 查询此类所有商品
    @Select("SELECT * FROM product WHERE category_id=#{categoryId}")
    List<Product> findById(BigInteger categoryId);
}
