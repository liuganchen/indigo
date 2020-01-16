package com.liuganchen.indigo.api;

import com.liuganchen.indigo.entity.Expenditure;
import com.liuganchen.indigo.entity.ExpenditureVo;
import com.liuganchen.indigo.entity.ExpenditureVoForOneDay;
import com.liuganchen.indigo.service.ExpendSev;
import com.liuganchen.indigo.util.AuthUtil;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/expenditure")
public class ExpenditureContainer {
    @Resource
    private ExpendSev expendSev;

    @PutMapping
    public Object addNewOrder(@RequestHeader("Authorization") String token, @NotNull @RequestBody Expenditure expenditure) {
        expenditure.setUserId(Integer.parseInt(AuthUtil.decrypt(token)));
        return this.expendSev.add(expenditure);
    }

    @RequestMapping("/list")
    @GetMapping
    public List<ExpenditureVoForOneDay> getList(@RequestHeader("Authorization") String token, long sTime, long eTime) {
        return this.expendSev
                .getList(Integer.parseInt(AuthUtil.decrypt(token)), sTime, eTime)
                .stream()
                .map(ExpenditureVo::new)
                .collect(Collectors.groupingBy(ExpenditureVo::getDate))
                .entrySet()
                .stream()
                .map(ExpenditureVoForOneDay::new)
                .collect(Collectors.toList());
    }
}
