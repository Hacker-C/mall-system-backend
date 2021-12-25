package top.mphy.mallbackend.controller;

import org.springframework.web.bind.annotation.*;
import top.mphy.mallbackend.common.ResponseData;
import top.mphy.mallbackend.common.ResponseDataUtils;
import top.mphy.mallbackend.entity.Notice;
import top.mphy.mallbackend.service.NoticeService;
@CrossOrigin(origins = "http://119.23.46.102:8081", maxAge = 3600)
@RestController
@RequestMapping("/notice")
public class NoticeController {

    private final NoticeService noticeService;

    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    @GetMapping
    public ResponseData findNotice() {
        Notice notice =  noticeService.findNotice();
        return ResponseDataUtils.buildSuccess("0", "获取公告成功！", notice);
    }

    @PatchMapping
    public ResponseData updateNotice(@RequestBody Notice notice) {
        noticeService.setNotice(notice);
        return ResponseDataUtils.buildSuccess("0", "公告保存成功！", notice);
    }
}
