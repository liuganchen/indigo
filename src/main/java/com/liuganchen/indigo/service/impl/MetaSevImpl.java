package com.liuganchen.indigo.service.impl;

import com.liuganchen.indigo.entity.Metadata;
import com.liuganchen.indigo.repository.MetaRepository;
import com.liuganchen.indigo.service.MetaSev;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MetaSevImpl implements MetaSev {
    @Resource
    private MetaRepository metaRepository;

    @Override
    public Metadata add(Metadata metadata) {
        return this.metaRepository.save(metadata);
    }

    @Override
    public List<Metadata> getList(int type) {
        return this.metaRepository.getList(type).filter(s -> s.getType() == type).collect(Collectors.toList());
    }
}
