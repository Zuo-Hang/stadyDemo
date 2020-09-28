package com.example.demo;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: hang hang
 * @Date: 2020/07/27/11:57
 * @Description:
 */
public class AddressBookProtosPOJO {

    @Protobuf(fieldType = FieldType.OBJECT, order=1, required = false)
    public Person person;

    @Protobuf(fieldType = FieldType.OBJECT, order=2, required = false)
    public List<Person> personList;

    @Protobuf(fieldType = FieldType.STRING, order=3, required = false)
    public List<String> stringList;

    @Protobuf(fieldType = FieldType.INT32, order=3, required = false)
    public List<Integer> intList;
}
