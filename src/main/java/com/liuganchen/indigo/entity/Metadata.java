package com.liuganchen.indigo.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 类型 衣（衣服，鞋子，包）食（饮食）住（）行（），人情礼份（份子钱，请客吃饭），电子产品（手机，手表），日常开销
 * type = 100 代表相关记账类型
 * type = 0 代表测试类型
 * 衣 = 10000; 食 = 20000； 住 = 30000； 行 = 40000 ； 礼 = 50000 ； 上层建筑（精神生活)
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Metadata {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Integer type;
    private String value;
    private String note;
    @CreatedDate
    private Timestamp createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
