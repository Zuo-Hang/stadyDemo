package com.example.demo.optional;

import lombok.Data;

import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: hang hang
 * @Date: 2020/08/12/10:39
 * @Description: 对于Java 8 提供的Optional类进行学习
 */
public class OptionalTest {
    @Data
    static class User{
        public Name name;
    }
    static class Name{
        public Integer toUpperCase(){
            System.out.println("Name.toUpperCase");
            return  1;
        }
    }

    /**
     * Optional 是一个final类，旨在解决NullPointException
     *
     * 构造：
     * 由于构造器私有 Optional 提供了三种构造方式: Optional.of(obj),  Optional.ofNullable(obj) 和明确的 Optional.empty()
     *
     * Optional.of(obj): 它要求传入的 obj 不能是 null 值的, 否则还没开始进入角色就倒在了 NullPointerException 异常上了.
     * Optional.empty():
     * Optional.ofNullable(obj): 它以一种智能的, 宽容的方式来构造一个 Optional 实例. 来者不拒, 传 null 进到就得到
     *                           Optional.empty(), 非 null 就调用 Optional.of(obj).
     *
     * Optional.of()的使用情况：
     *      1. 当我们非常非常的明确将要传给 Optional.of(obj) 的 obj 参数不可能为 null 时, 比如它是一个刚 new 出来的对象
     *      (Optional.of(new User(...))), 或者是一个非 null 常量时;
     *
     *      2. 当想为 obj 断言不为 null 时, 即我们想在万一 obj 为 null 立即报告 NullPointException 异常, 立即修改,
     *      而不是隐藏空指针异常时, 我们就应该果断的用 Optional.of(obj) 来构造 Optional 实例, 而不让任何不可预计的 null
     *      值有可乘之机隐身于 Optional 中.
     * 使用方式：
     * 判断：isPresent()   获取：get()
     * isPresent() 与 obj != null 无任何分别, 但几乎很少用. 没有 isPresent() 作铺垫的 get() 调用会收到告警
     * 所以很少使用以上两个方法。
     *
     */
    public static void main(String[] args) {
        User user=null;
        /**
         * 存在即返回, 无则提供默认值
         * 可以代替:
         * if(user!=null){
         *     return user;
         * }else{
         *     return null;
         * }
         */
        Optional.ofNullable(user).orElse(null);
        /** 存在即返回, 无则由函数来产生
         * 可替代 return user.isPresent() ? user: new User();
         */
        Optional.ofNullable(user).orElseGet(()->new User());

        Optional<User> user1 = Optional.ofNullable(user);
        /**存在才对它做点什么  对应if(){}
         * 可替代：
         * if (user1.isPresent()) {
         *   System.out.println(user1.get());
         * }
         */
        user1.ifPresent(System.out::println);
        /**
         * map 对应 if(){}else{}
         * 多层嵌套
         */
        user1.map(u -> u.getName())
                .map(name -> name.toUpperCase())
                .orElse(null);
    }
}

