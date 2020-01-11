package com.liuganchen.indigo.api;

import com.liuganchen.indigo.entity.Metadata;
import com.liuganchen.indigo.service.MetaSev;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/meta")
public class MetaContainer {
    @Resource
    private MetaSev metaSev;

    @PutMapping
    public Object addMetaData(Metadata metadata) {
        return null;
    }

    @GetMapping
    @RequestMapping("/list")
    public List<Metadata> metaDataList(int type) {
        return this.metaSev.getList(type);
    }
}
