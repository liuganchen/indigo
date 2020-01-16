package com.liuganchen.indigo.entity;

import com.liuganchen.indigo.service.MetaSev;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExpenditureVo extends Expenditure {
    @Resource
    private MetaSev metaSev;
    private String date;
    private String type;

    public ExpenditureVo() {
    }

    public ExpenditureVo(@NotNull Expenditure expenditure) {
        this.setId(expenditure.getId());
        this.setContent(expenditure.getContent());
        this.setType(this.metaSev.translateMetaId(expenditure.getTypeId()));
        this.setKindId(expenditure.getId());
        this.date = new SimpleDateFormat("yyyy 年 MM 月 dd 日 E HH 点 mm 分 ss 秒").format(expenditure.getCreateTime());
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ExpenditureVo{" +
                "date='" + date + '\'' +
                '}';
    }
}
