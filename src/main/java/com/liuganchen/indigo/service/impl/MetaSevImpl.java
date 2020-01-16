package com.liuganchen.indigo.service.impl;

import com.liuganchen.indigo.entity.Metadata;
import com.liuganchen.indigo.repository.MetaRepository;
import com.liuganchen.indigo.service.MetaSev;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MetaSevImpl implements MetaSev {
    @Resource
    private MetaRepository metaRepository;
    public static Map<Integer, Metadata> metadataMap = null;

    public MetaSevImpl() {
    }

    public void initMetadataMap() {
        metadataMap = new HashMap<Integer, Metadata>();
        var list = this.metaRepository.findAll();
        assert list.size() > 0;
        list.forEach(t -> {
            metadataMap.put(t.getId(), t);
        });
    }

    public String translateMetaId(Integer id) {
        if (metadataMap == null) {
            this.initMetadataMap();
        }
        return metadataMap.get(id).getValue();
    }

    @Override
    public Metadata add(Metadata metadata) {
        return this.metaRepository.save(metadata);
    }

    @Override
    public List<Metadata> getList(int type) {
        return this.metaRepository.getList().filter(s -> s.getType() == type).collect(Collectors.toList());
    }
}
