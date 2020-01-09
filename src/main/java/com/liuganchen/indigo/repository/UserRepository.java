package com.liuganchen.indigo.repository;

import com.liuganchen.indigo.entity.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Override
    void delete(@NotNull User user);

    @NotNull
    @Override
    <S extends User> S save(@NotNull S s);

    @NotNull
    @Override
    <S extends User> Optional<S> findOne(@NotNull Example<S> example);

    @Query(nativeQuery = true, value = "select u.* from user u where u.account = ?1 and u.password = ?2")
    User getUser(String account, String password);

    @Query(nativeQuery = true, value = "select u.* from user u where u.account = ?1")
    User hasAccount(String account);
}
