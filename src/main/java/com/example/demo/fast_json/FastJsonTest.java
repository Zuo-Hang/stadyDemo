package com.example.demo.fast_json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: hang hang
 * @Date: 2020/10/26/11:43
 * @Description:
 */
public class FastJsonTest {

    public class A1 {
        private int id;
//FieldInfo可以配置在getter/setter⽅法或者字段上。
        @JSONField(name="ID")
        public int getId() {return id;}
        @JSONField(name="ID")
        public void setId(int value) {this.id = id;}
    }

    public class A2 {
        //配置在field上
        @JSONField(name="ID")
        private int id;

        public int getId() {return id;}
        public void setId(int value) {this.id = id;}
    }

    /**使⽤format配置⽇期格式化*/
    public static class A3 {
        // 配置date序列化和反序列使⽤yyyyMMdd⽇期格式
        @JSONField(format="yyyyMMdd")
        public Date date;
        public A3() {
            this.date = new Date();
        }
    }

    public static class A4 {
        //使⽤serialize/deserialize指定字段不序列化
        @JSONField(serialize=false)
        public Date date;

        public A4() {
            this.date = new Date();
        }
    }

    public static class VO {
        /**
         * 使⽤ordinal指定字段的顺序
         *   *注:缺省fastjson序列化⼀个java bean，是根据fieldName的字母序进⾏序列的你可以通过ordinal指定字段的顺序。
         */
        @JSONField(ordinal = 1)
        private int f0;
        @JSONField(ordinal = 2)
        private int f1;
        @JSONField(ordinal = 3)
        private int f2;
        public VO(int f0, int f1, int f2) {
            this.f0 = f0;
            this.f1 = f1;
            this.f2 = f2;
        }

        public int getF0() {
            return f0;
        }

        public void setF0(int f0) {
            this.f0 = f0;
        }

        public int getF1() {
            return f1;
        }

        public void setF1(int f1) {
            this.f1 = f1;
        }

        public int getF2() {
            return f2;
        }

        public void setF2(int f2) {
            this.f2 = f2;
        }
    }

    public static void main(String[] args) {
        System.out.println(JSON.toJSON(new VO(0,1,2)));
        System.out.println(JSON.toJSON(new A3()));
        System.out.println(JSON.toJSON(new A4()));
    }
}
