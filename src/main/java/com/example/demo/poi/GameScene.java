package com.example.demo.poi;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author gonefuture  gonefuture@qq.com
 * time 2018/9/29 16:13
 * @version 1.00
 * Description: 场景
 */

@Slf4j
@Data
public class GameScene {

    @EntityName(column = "ID")
    private Integer id;

    @EntityName(column = "名字")
    private String name;

    @EntityName(column = "相邻场景")
    private String neighbors = "";

    @EntityName(column = "地图类型")
    private Integer type;

    @EntityName(column = "场景对象")
    private String gameObjectIds;

}
