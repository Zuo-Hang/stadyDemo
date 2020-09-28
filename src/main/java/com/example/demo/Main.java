package com.example.demo;


import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import lombok.Data;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: hang hang
 * @Date: 2020/07/27/11:51
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
//        Codec<SimpleTypeTest> simpleTypeCodec = ProtobufProxy
//                .create(SimpleTypeTest.class);
//
//        //创建并赋值
//        SimpleTypeTest stt = new SimpleTypeTest();
//        stt.setName("abc");
//        stt.setValue(100);
//        String code = ProtobufIDLGenerator.getIDL(SimpleTypeTest.class);
//        System.out.println(DigestUtils.md5DigestAsHex("原串".getBytes()));
//        System.out.println(code);
//        System.out.println(DigestUtils.md5DigestAsHex("原串".getBytes()));
//        int a=1;
//        System.out.println((byte)a);
//        try {
//            // 序列化
//            byte[] bb = simpleTypeCodec.encode(stt);
//            System.out.println(Arrays.toString(bb));
//            // 反序列化
//            SimpleTypeTest newStt = simpleTypeCodec.decode(bb);
//            System.out.println(newStt.toString());
//        } catch (IOException e) {
//            e.printStackTrace();

//        Functiondemo functiondemo=new Functiondemo();
//        Iface iface = Mapmap.map.get(2);
//        Optional.ofNullable(iface).ifPresent(i->System.out.println(i));
//        ToolsProperty toolsProperty = new ToolsProperty(1, "减速", 5, "buf", "测试");
//        ToolsProperty toolsProperty1 = new ToolsProperty(1, "燃烧", 5, "buf", "测试");
//        ArrayList<ToolsProperty> toolsProperties = new ArrayList<>();
//        toolsProperties.add(toolsProperty);
//        toolsProperties.add(toolsProperty1);
//        Tools tools = new Tools(1, "冰霜长矛", null, 11, 2, "1,2", "手臂", 1888, "攻击减速", 2, 2, toolsProperties);
//        Tools tools1 = new Tools(2, "破军", null, 11, 2, "1,2", "手臂", 1888, "攻击减速", 2, 2, toolsProperties);
//        ArrayList<Tools> tools2 = new ArrayList<>();
//        tools2.add(tools);
//        tools2.add(tools1);
//        Gson gson = new Gson();
//        String s = gson.toJson(tools2);
//        System.out.println(s);
//        ArrayList<Tools> toolslist = (ArrayList<Tools>) gson.fromJson(s, new TypeToken<ArrayList<Tools>>() {}.getType());
//        for(int i=1;i<27;i++){
//        int i=2080;
//            System.out.print(i/2);
////        }
//        for(Integer i=0;i<10;i++){
//            System.out.println(Math.random() * 100);
//        }



        Gson gson = new Gson();
        String s = gson.toJson(new TaskCondition(1, 2));

        //int i = Runtime.getRuntime().availableProcessors() * 2 + 1;
        System.out.println(s);

        //ParameterizedType
        //Class


    }

    @Data
    public static class TaskCondition {
        /**
         * 条件
         */
        Integer condition;
        /**
         * 目标
         */
        Integer aim;

        public TaskCondition(Integer condition, Integer aim) {
            this.condition = condition;
            this.aim = aim;
        }
    }

}
