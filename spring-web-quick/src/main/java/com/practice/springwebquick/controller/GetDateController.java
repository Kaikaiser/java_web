package com.practice.springwebquick.controller;


import com.practice.springwebquick.pojo.Address;
import com.practice.springwebquick.pojo.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GetDateController {
    @RequestMapping("/getHello")
    public Result getHello() {

        System.out.println("hello world");
        return new Result("succes!", 1, "hello world");
    }

    @RequestMapping("/getAddr")
    public Result getAddr(){
        Address addr = new Address();
        addr.setProvince("四川");
        addr.setCity("成都");
        //return new Result("succes!", 1, addr);
        return Result.error();
    }
    @RequestMapping("/getList")
    public Result getList(){
        List<Address> list  = new ArrayList<>();
        Address addr = new Address();
        addr.setProvince("广东");
        addr.setCity("深圳");
        list.add(addr);
        //return new Result("succes", 1, list);
        return Result.success(list);
    }
}
