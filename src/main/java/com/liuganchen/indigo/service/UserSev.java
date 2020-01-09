package com.liuganchen.indigo.service;

import com.liuganchen.indigo.entity.User;

public interface UserSev {
    User findOne(String account, String password);

    User saveOne(User user);

    boolean isRegistered(String account);
}
