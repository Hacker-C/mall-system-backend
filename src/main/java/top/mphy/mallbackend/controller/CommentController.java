package top.mphy.mallbackend.controller;

import org.springframework.web.bind.annotation.*;
import top.mphy.mallbackend.common.ResponseData;
import top.mphy.mallbackend.common.ResponseDataUtils;
import top.mphy.mallbackend.entity.Comment;
import top.mphy.mallbackend.entity.DetailsComment;
import top.mphy.mallbackend.service.CommentService;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/{productId}")
    public List<DetailsComment> findCommentsById(@PathVariable("productId")BigInteger productId) {
        return commentService.findCommentsById(productId);
    }

    @GetMapping("/count/{productId}")
    public BigInteger getCountById(@PathVariable("productId") BigInteger productId) {
        return commentService.getCountById(productId);
    }

    // !添加评论
    @PostMapping
    public ResponseData<?> comment(@RequestBody Comment comment) {
        commentService.comment(comment);
        return ResponseDataUtils.buildSuccess("0", "评论成功！");
    }

    // !用户删除自己的评论
    @DeleteMapping("/{commentId}")
    public ResponseData<?> delete(@PathVariable BigInteger commentId) {
        commentService.delete(commentId);
        return ResponseDataUtils.buildSuccess("0", "删除评论成功！");
    }

}
