package top.mphy.mallbackend.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.mphy.mallbackend.entity.Notice;

@Mapper
public interface NoticeMapper {
    // 获取公告信息
    @Select("SELECT * FROM notice")
    Notice findNotice();

    // 修改公告
    @Select("UPDATE notice SET text=#{text}")
    void setNotice(Notice notice);
}
