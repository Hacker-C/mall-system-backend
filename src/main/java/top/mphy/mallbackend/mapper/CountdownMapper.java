package top.mphy.mallbackend.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.sql.Timestamp;

@Mapper
public interface CountdownMapper {

    @Select("SELECT new_time FROM countdown WHERE id=1")
    Timestamp getTime();

    @Update("UPDATE countdown SET new_time=#{newTime} WHERE id=1")
    void setTime(String newTime);

}
