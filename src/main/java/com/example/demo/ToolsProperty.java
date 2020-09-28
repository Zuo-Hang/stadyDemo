package com.example.demo;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: hang hang
 * @Date: 2020/08/17/21:33
 * @Description: 装备的属性实体类
 */
@Data
public class ToolsProperty {
    private Integer id;
    private String name;
    private Integer value;
    private String type;
    private String describe;

    public ToolsProperty(Integer id, String name, Integer value, String type, String describe) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.type = type;
        this.describe = describe;
    }
}
