package com.liuganchen.indigo.service;

import com.liuganchen.indigo.entity.Expenditure;

import java.util.List;

public interface ExpendSev {
    List<Expenditure> getList(int userId, long startTime, long endTime);

    Expenditure add(Expenditure expenditure);
}
