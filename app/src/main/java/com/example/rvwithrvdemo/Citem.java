package com.example.rvwithrvdemo;

/**
 * @ClassName Citem
 * @Description TODO
 * @Author YangChengLei
 * @Date 2023/6/16 10:55
 * @Version 1.0
 */
public class Citem {
    public String Code;
    public String Name;

    public Citem(String code, String name) {
        Code = code;
        Name = name;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
