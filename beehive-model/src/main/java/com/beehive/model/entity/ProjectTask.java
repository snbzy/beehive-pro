package com.beehive.model.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class ProjectTask {
    @TableId
    private Integer id;
    private String taskName;
}