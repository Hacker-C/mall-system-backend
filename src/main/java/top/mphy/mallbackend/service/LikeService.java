package top.mphy.mallbackend.service;

import org.springframework.stereotype.Service;
import top.mphy.mallbackend.entity.Like;
import top.mphy.mallbackend.mapper.LikeMapper;

import java.math.BigInteger;
import java.util.List;

@Service
public class LikeService {

    private final LikeMapper likeMapper;

    public LikeService(LikeMapper likeMapper) {
        this.likeMapper = likeMapper;
    }

    public List<Like> findAll(BigInteger userId) {
        return likeMapper.findAll(userId);
    }

    ;

    public BigInteger count(BigInteger userId) {
        return likeMapper.count(userId);
    }
}
