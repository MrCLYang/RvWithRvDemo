package com.example.rvwithrvdemo;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CListdemo
 * @Description TODO
 * @Author YangChengLei
 * @Date 2023/6/16 10:56
 * @Version 1.0
 */
public class CListdemo {
    public CListdemo() {
        OrderNo = "";
        items = new ArrayList<>();
    }
    public String OrderNo;
    public List<Citem> items;

    public String getOrderNo() {
        return OrderNo;
    }

    public void setOrderNo(String orderNo) {
        OrderNo = orderNo;
    }

    public List<Citem> getItems() {
        return items;
    }

    public void setItems(List<Citem> items) {
        this.items = items;
    }
}
