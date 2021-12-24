package top.mphy.mallbackend.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Countdown {
    private Integer id;
    private Timestamp newTime;
    private Timestamp updateTime;
}
