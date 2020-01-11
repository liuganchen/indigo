package com.liuganchen.indigo.api;

import com.liuganchen.indigo.entity.Expenditure;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/expenditure")
public class ExpenditureContainer {
    @PutMapping
    public Object addNewOrder(Expenditure expenditure) {
        return null;
    }
}
