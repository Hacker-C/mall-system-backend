package top.mphy.mallbackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.mphy.mallbackend.entity.DetailsComment;
import top.mphy.mallbackend.service.CommentService;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("comment")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/{productId}")
    public List<DetailsComment> findCommentsById(@PathVariable("productId")BigInteger productId) {
        return commentService.findCommentsById(productId);
    }

    @GetMapping("count/{productId}")
    public BigInteger getCountById(@PathVariable("productId") BigInteger productId) {
        return commentService.getCountById(productId);
    }

}
