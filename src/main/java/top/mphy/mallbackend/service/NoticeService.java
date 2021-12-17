package top.mphy.mallbackend.service;

import org.springframework.stereotype.Service;
import top.mphy.mallbackend.entity.Notice;
import top.mphy.mallbackend.mapper.NoticeMapper;

@Service
public class NoticeService {

    private final NoticeMapper noticeMapper;

    public NoticeService(NoticeMapper noticeMapper) {
        this.noticeMapper = noticeMapper;
    }

    public Notice findNotice() {
        return noticeMapper.findNotice();
    }

    public void setNotice(Notice notice) {
        noticeMapper.setNotice(notice);
    }

}
