package top.mphy.mallbackend.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import top.mphy.mallbackend.entity.OrderDetail;
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

    // 查出某个店下的所有商品
    //    @Select("SELECT * FROM product WHERE shop_id=(SELECT shop_id FROM shop WHERE owner_id=#{ownerId})")
    //    List <Product> findByShopId(BigInteger ownerId);

    // !分页查询
    @Select("SELECT * FROM product WHERE shop_id=(SELECT shop_id FROM shop WHERE owner_id=#{ownerId}) AND product_name like '%${key}%' limit #{offset},#{pageSize}")
    List<Product> findByPage(@Param("offset") Integer offset, @Param("pageSize") Integer pageSize, @Param("key") String key, @Param("ownerId") Integer ownerId);

    // !查询某个商家的商品
    @Select("SELECT count(*) FROM product WHERE shop_id=(SELECT shop_id FROM shop WHERE owner_id=#{ownerId})")
    Integer countShopProduct(Integer ownerId);

    // !商家修改商品信息
    @Select("UPDATE product SET product_name=#{productName},product_price=#{productPrice},category_id=#{categoryId},weight=#{weight},discount=#{discount},`left`=#{left},product_desc=#{productDesc}, img_src=#{imgSrc} WHERE product_id=#{productId}")
    void updateProduct(Product product);

    // !获取某一订单的所有商品信息
    @Select("SELECT img_src, product_name, product_price, product.product_id as product_id, count, count*product_price*discount as orderProductPrice FROM order_detail, product WHERE product.product_id=order_detail.product_id AND order_number=#{orderNumber}")
    List<OrderDetail> findOrderDetail(String orderNumber);

    // !添加新产品
    @Insert("INSERT INTO product(product_name,product_price,category_id,weight,product_desc,discount,`left`,img_src, shop_id, sold) VALUE(#{productName},#{productPrice},#{categoryId},#{weight},#{productDesc},#{discount},#{left},#{imgSrc},#{shopId},#{sold})")
    void addProduct(Product product);

    // !根据shopId 获取所有商品
    @Select("SELECT * FROM product WHERE shop_id=#{shopId}")
    List<Product> findByShopId(BigInteger shopId);

    // !搜索
    @Select("SELECT * FROM product WHERE CONCAT(product_name,' ', product_desc) LIKE '%${key}%'")
    List<Product> search(String key);

    // !删除商品
    @Delete("DELETE FROM  product WHERE product_id=#{productId}")
    void deleteP(BigInteger productId);
}
