package com.liuganchen.indigo.entity;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;

public class ExpenditureVoForOneDay {
    private String title;
    private List<ExpenditureVo> list;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ExpenditureVo> getList() {
        return list;
    }

    public void setList(List<ExpenditureVo> list) {
        this.list = list;
    }

    public ExpenditureVoForOneDay(String title, List<ExpenditureVo> list) {
        this.title = title;
        this.list = list;
    }

    public ExpenditureVoForOneDay(@NotNull Map.Entry<String, List<ExpenditureVo>> entry) {
        this.title = entry.getKey();
        this.list = entry.getValue();
    }

    @Override
    public String toString() {
        return "{" +
                "title='" + title + '\'' +
                ", list=" + list +
                '}';
    }
}
