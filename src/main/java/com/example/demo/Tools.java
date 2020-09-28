package com.example.demo;


import lombok.Data;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: hang hang
 * @Date: 2020/08/11/17:30
 * @Description: 道具  可以在商店中出售，并且可以被放在背包当中
 */
@Data
public class Tools {
    private Integer  id;
    private String  name;
    private Integer  buffer;
    private Integer level;
    private Integer kind;
    private String toolsProperties = "";
    private String part;
    private Integer price ;
    private String describe;
    private Integer state;
    private Integer count;
    private List<ToolsProperty> toolsPropertie=null;

    public Tools(Integer id, String name, Integer buffer, Integer level, Integer kind, String toolsProperties, String part, Integer price, String describe, Integer state, Integer count, List<ToolsProperty> toolsPropertie) {
        this.id = id;
        this.name = name;
        this.buffer = buffer;
        this.level = level;
        this.kind = kind;
        this.toolsProperties = toolsProperties;
        this.part = part;
        this.price = price;
        this.describe = describe;
        this.state = state;
        this.count = count;
        this.toolsPropertie = toolsPropertie;
    }
}
