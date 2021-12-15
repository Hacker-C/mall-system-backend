package top.mphy.mallbackend.controller;

import org.apache.ibatis.annotations.Delete;
import org.springframework.web.bind.annotation.*;
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

    // 用户删除收藏商品
    @DeleteMapping("/{userId}")
    public ResponseData deleteById(@PathVariable("userId") BigInteger userId) {
        likeService.delete(userId);
        return ResponseDataUtils.buildSuccess("0", "收藏删除成功！");
    }

    // 用户添加收藏
    @PostMapping
    public ResponseData addLikeItem(@RequestBody Like queryLike) {
        BigInteger productId = queryLike.getProductId();
        BigInteger userId = queryLike.getUserId();
        Like like = likeService.findById(productId, userId);
        if (like != null) {
            return ResponseDataUtils.buildSuccess("1", "您已经收藏该商品！");
        }
        likeService.save(productId, userId);
        return ResponseDataUtils.buildSuccess("0", "收藏商品成功！");
    }

}
