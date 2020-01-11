package com.liuganchen.indigo.service;

import com.liuganchen.indigo.entity.Metadata;

import java.util.List;

public interface MetaSev {
    Metadata add(Metadata metadata);

    List<Metadata> getList(int type);
}
