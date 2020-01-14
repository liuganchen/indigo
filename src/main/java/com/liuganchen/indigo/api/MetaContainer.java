package com.liuganchen.indigo.api;

import com.liuganchen.indigo.entity.Metadata;
import com.liuganchen.indigo.service.MetaSev;
import org.jetbrains.annotations.NotNull;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/meta")
public class MetaContainer {
    @Resource
    private MetaSev metaSev;

    @PutMapping
    public Object addMetaData(@RequestBody @NotNull Metadata metadata) {
        return metaSev.add(metadata);
    }

    @RequestMapping("/list")
    @GetMapping
    @Transactional(readOnly = true)
    public List<Metadata> metaDataList(int type) {
        return this.metaSev.getList(type);
    }
}
