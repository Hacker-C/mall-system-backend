package top.mphy.mallbackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.mphy.mallbackend.common.ResponseData;
import top.mphy.mallbackend.common.ResponseDataUtils;
import top.mphy.mallbackend.entity.Like;
import top.mphy.mallbackend.service.LikeService;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/like")
public class LikeController {
    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    // 获取用户的收藏商品
    @GetMapping("/{userId}")
    public ResponseData getLikeItemsById(@PathVariable("userId") BigInteger userId) {
        List<Like> likes = likeService.findAll(userId);
        return ResponseDataUtils.buildSuccess("0", "数据获取成功！", likes);
    }

    // 获取用户收藏商品的总数
    @GetMapping("/count/{userId}")
    public ResponseData countById(@PathVariable("userId") BigInteger userId) {
        BigInteger count = likeService.count(userId);
        return ResponseDataUtils.buildSuccess("0", "数据获取成功！", count);
    }
}
