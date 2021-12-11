package top.mphy.mallbackend.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.mphy.mallbackend.entity.Product;

import java.math.BigInteger;
import java.util.List;

@Mapper
public interface ProductMapper {
    // 查询所有商品信息
    @Select("SELECT * FROM `product`")
    List<Product> findAll();

    // 根据商品ID查询指定商品
    @Select("SELECT * FROM product WHERE product_id=#{id}")
    Product findOne(BigInteger id);

    // 查询最新上架商品：指定日期之后
    @Select("SELECT * FROM product WHERE DATE_FORMAT(create_time, '%Y-%m-%d') >= '2021-12-10'")
    List<Product> findNew();

    // 查询热门商品，销量高于指定售货量的商品
    @Select("SELECT * FROM product WHERE sold >= 500")
    List<Product> findHot();

}
