package com.liuganchen.indigo.service.impl;

import com.liuganchen.indigo.entity.User;
import com.liuganchen.indigo.repository.UserRepository;
import com.liuganchen.indigo.service.UserSev;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserSevImpl implements UserSev {
    @Resource
    private UserRepository userRep;

    @Override
    public User findOne(String account, String password) {
        return this.userRep.getUser(account, password);
    }

    @Override
    public User saveOne(User user) {
        return this.userRep.save(user);
    }

    @Override
    public boolean isRegistered(String account) {
        var res = this.userRep.hasAccount(account);
        return res.getId() > 0;
    }
}
