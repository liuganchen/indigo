package com.liuganchen.indigo.service.impl;

import com.liuganchen.indigo.entity.Expenditure;
import com.liuganchen.indigo.repository.ExpenditureRepository;
import com.liuganchen.indigo.service.ExpendSev;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpendSevImpl implements ExpendSev {
    @Resource
    private ExpenditureRepository repository;

    @Override
    public List<Expenditure> getList(int userId, long startTime, long endTime) {
        return this.repository.findAll().stream()
                .filter(s -> s.getId() == userId)
                .filter(s -> s.getCreateTime().getTime() > endTime)
                .filter(s -> s.getCreateTime().getTime() <= startTime)
                .sorted(Comparator.comparing(Expenditure::getId).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public Expenditure add(Expenditure expenditure) {
        return this.repository.save(expenditure);
    }
}
