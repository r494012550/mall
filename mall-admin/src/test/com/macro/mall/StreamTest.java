package com.macro.mall;

import lombok.*;
import lombok.experimental.Tolerate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class StreamTest {
    @Test
    public void streamTest(){

        //模拟 你查到的数据
        List<User> userlist = new ArrayList<>();
        userlist.add(new User("张3",10));
        userlist.add(new User("张4",11));
        userlist.add(new User("张5",12));
        userlist.add(new User("张6",13));
        userlist.add(new User("张7",14));
        userlist.add(new User("张8",15));
        userlist.add(new User("张9",16));



//        把每个人的年龄 都+2岁
//        int i = 0;
//        for (User user : userlist) {
//            user.setAge(user.getAge()+2);
//            i++;
//        }
//        System.out.println(userlist);

//        userlist.stream().forEach(user -> user.setAge(user.getAge()+2));
//        System.out.println(userlist);

        User user1 = new User("刘德华", 10);
        UserA userA = new UserA();
        BeanUtils.copyProperties(user1,userA);
        System.out.println(userA);

    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    class User{
        String name;
        int age;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    class UserA{
        String name;
        int age;
        int address;
    }
}
