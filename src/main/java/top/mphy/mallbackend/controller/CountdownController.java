package top.mphy.mallbackend.controller;

import org.springframework.web.bind.annotation.*;
import top.mphy.mallbackend.common.ResponseData;
import top.mphy.mallbackend.common.ResponseDataUtils;
import top.mphy.mallbackend.service.CountdownService;

import java.sql.Timestamp;

@CrossOrigin(origins = "http://119.23.46.102:8081", maxAge = 3600)
@RestController
@RequestMapping("/countdown")
public class CountdownController {

    private final CountdownService countdownService;

    public CountdownController(CountdownService countdownService) {
        this.countdownService = countdownService;
    }

    @GetMapping
    public ResponseData<?> getTime() {
        Timestamp time = countdownService.getTime();
        return ResponseDataUtils.buildSuccess("0", "获取时间成功",time);
    }

    @PatchMapping("/{newTime}")
    public ResponseData<?> setCountdown(@PathVariable String newTime) {
        countdownService.setTime(newTime);
        return ResponseDataUtils.buildSuccess("0", "倒计时修改成功");
    }

}
