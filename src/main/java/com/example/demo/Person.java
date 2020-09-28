package com.example.demo;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: hang hang
 * @Date: 2020/07/27/11:58
 * @Description:
 */
public class Person {

    @Protobuf(fieldType = FieldType.STRING, order=1, required = true)
    public String name;
    @Protobuf(fieldType = FieldType.INT32, order=2, required = true)
    public int id;
    @Protobuf(fieldType = FieldType.STRING, order=3, required = false)
    public String email;

    @Protobuf(fieldType = FieldType.DOUBLE, order=4, required = false)
    public Double doubleF;


    @Protobuf(fieldType = FieldType.FLOAT, order=5, required = false)
    public Float floatF;

    @Protobuf(fieldType = FieldType.BYTES, order=6, required = false)
    public byte[] bytesF;

    @Protobuf(fieldType=FieldType.BOOL, order=7, required=false)
    public Boolean boolF;
}