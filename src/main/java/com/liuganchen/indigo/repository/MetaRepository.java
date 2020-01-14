package com.liuganchen.indigo.repository;

import com.liuganchen.indigo.entity.Metadata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;

public interface MetaRepository extends JpaRepository<Metadata, Integer> {
    @Query("select m from Metadata m")
    Stream<Metadata> getList();
}
