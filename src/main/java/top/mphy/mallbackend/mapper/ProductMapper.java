package top.mphy.mallbackend.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.GetMapping;
import top.mphy.mallbackend.entity.Product;

import java.util.List;

@Mapper
public interface ProductMapper {
    @Select("SELECT * FROM `product`")
    List<Product> findAll();
}
