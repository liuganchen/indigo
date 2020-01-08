package com.liuganchen.indigo.service.impl;

import com.liuganchen.indigo.entity.User;
import com.liuganchen.indigo.repository.UserRepository;
import com.liuganchen.indigo.service.UserSev;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserSevImpl implements UserSev {
    @Resource
    private UserRepository userRep;

    @Override
    public User findOne(String account, String password) {
        var res = this.userRep.findOne(Example.of(new User(account, password)));
        return res.orElseGet(User::new);
    }

    @Override
    public User saveOne(User user) {
        return this.userRep.save(user);
    }
}
