package com.practice.springwebquick.controller;


import com.practice.springwebquick.pojo.Address;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class getDateController {
    @RequestMapping("/getHello")
    public String getHello(){
        System.out.println("hello world");
        return "hello world";
    }

    @RequestMapping("/getAddr")
    public Address getAddr(){
        Address addr = new Address();
        addr.setProvince("四川");
        addr.setCity("成都");
        return addr;
    }
    @RequestMapping("/getList")
    public List<Address> getList(){
        List<Address> list  = new ArrayList<>();
        Address addr = new Address();
        addr.setProvince("广东");
        addr.setCity("深圳");
        list.add(addr);
        return list;
    }
}
