package com.liuganchen.indigo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    // 类型 吃饭，下馆子，红包，等等等等
    private Integer type;
    // 种类 支出 0 ，收入  1
    private Integer kind;
}
