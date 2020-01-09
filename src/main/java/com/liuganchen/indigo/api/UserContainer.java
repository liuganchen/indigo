package com.liuganchen.indigo.api;

import com.liuganchen.indigo.entity.User;
import com.liuganchen.indigo.service.UserSev;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/user")
public class UserContainer {
    @Resource
    private UserSev userSev;

    @PostMapping
    public User login(@NotNull @RequestBody User user) {
        return this.userSev.findOne(user.getAccount(), user.getPassword());
    }

    @PutMapping
    public Object register(@NotNull @RequestBody User user) {
        return userSev.isRegistered(user.getAccount()) ? 0 : this.userSev.saveOne(user);
    }
}
