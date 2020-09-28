package com.example.demo.poi;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: hang hang
 * @Date: 2020/08/10/15:20
 * @Description:
 */
public class Main {
    public static void main(String[] args) throws Exception {
//        Demo2 demo2 = new Demo2();
////        demo2.createExcel();
//        demo2.readExcel();
        SceneExcelUtil sceneExcelUtil = new SceneExcelUtil("C:\\java_project\\demo\\src\\main\\resources\\template.xls");
        Map<Integer, GameScene> map = sceneExcelUtil.getMap();
        return;

    }
}
