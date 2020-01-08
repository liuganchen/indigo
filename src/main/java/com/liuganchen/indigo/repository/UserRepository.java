package com.liuganchen.indigo.repository;

import com.liuganchen.indigo.entity.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Override
    void delete(User user);

    @Override
    <S extends User> S save(S s);

    @Override
    <S extends User> Optional<S> findOne(Example<S> example);
}
