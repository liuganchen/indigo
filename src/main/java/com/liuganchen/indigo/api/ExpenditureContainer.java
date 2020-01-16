package com.liuganchen.indigo.api;

import com.liuganchen.indigo.entity.Expenditure;
import com.liuganchen.indigo.entity.ExpenditureVo;
import com.liuganchen.indigo.service.ExpendSev;
import com.liuganchen.indigo.util.AuthUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collections;

@RestController
@RequestMapping("/api/expenditure")
public class ExpenditureContainer {
    @Resource
    private ExpendSev expendSev;

    @PutMapping
    public Object addNewOrder(@RequestHeader("Authorization") String token, @RequestBody Expenditure expenditure) {
        expenditure.setUserId(Integer.parseInt(AuthUtil.decrypt(token)));
        return this.expendSev.add(expenditure);
    }

    @RequestMapping("/list")
    @GetMapping
    public Object getList(@RequestHeader("Authorization") String token, long sTime, long eTime) {
        return this.expendSev.getList(Integer.parseInt(AuthUtil.decrypt(token)), sTime, eTime)
                .stream()
                .map(ExpenditureVo::new);
    }
}
