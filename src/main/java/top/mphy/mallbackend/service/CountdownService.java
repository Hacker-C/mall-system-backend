package top.mphy.mallbackend.service;

import org.springframework.stereotype.Service;
import top.mphy.mallbackend.mapper.CountdownMapper;

import java.sql.Timestamp;

@Service
public class CountdownService {

    private final CountdownMapper countdownMapper;

    public CountdownService(CountdownMapper countdownMapper) {
        this.countdownMapper = countdownMapper;
    }

    public Timestamp getTime() {
        return countdownMapper.getTime();
    }

    public void setTime(String newTime) {
        countdownMapper.setTime(newTime);
    }
}
