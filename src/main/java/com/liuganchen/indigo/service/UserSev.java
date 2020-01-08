package com.liuganchen.indigo.service;

import com.liuganchen.indigo.entity.User;

public interface UserSev {
    public User findOne(String account, String password);
    public User saveOne(User user);
}
