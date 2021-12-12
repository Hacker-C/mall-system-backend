package top.mphy.mallbackend.service;

import org.springframework.stereotype.Service;
import top.mphy.mallbackend.entity.DetailsComment;
import top.mphy.mallbackend.mapper.CommentMapper;

import java.math.BigInteger;
import java.util.List;

@Service
public class CommentService {
    private final CommentMapper commentMapper;

    public CommentService(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    public List<DetailsComment> findCommentsById(BigInteger productId) {
        return commentMapper.findCommentsById(productId);
    }

    public BigInteger getCountById(BigInteger productId) {
        return commentMapper.getCountById(productId);
    }

}
