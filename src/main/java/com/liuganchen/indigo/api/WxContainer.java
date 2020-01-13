package com.liuganchen.indigo.api;

import com.alibaba.fastjson.JSON;
import com.liuganchen.indigo.entity.User;
import com.liuganchen.indigo.entity.WxAuth;
import com.liuganchen.indigo.service.UserSev;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.util.UriTemplateHandler;

import javax.annotation.Resource;
import java.net.URI;
import java.util.Map;

/**
 * secret = 88bd7ac61d22821f71a00d8f7d781563
 * appid = wxcd1cce2474cfc5cd
 */
@RestController
@RequestMapping("/api/wx")
public class WxContainer {
    @Value("${wx.config.secret}")
    private String secret;
    @Value("${wx.config.appid}")
    private String appid;
    private RestTemplate restTemplate = new RestTemplate();
    @Resource
    private UserSev userSev;

    public WxContainer() {
    }

    @RequestMapping("/register")
    @GetMapping
    public User register(String code, String userName, String avatar) {
        var url = "https://api.weixin.qq.com/sns/jscode2session?appid={1}&secret={2}&js_code={3}&grant_type=authorization_code";
        var wxRes = this.restTemplate.getForObject(url, String.class, this.appid, this.secret, code);
        var wxAuth = JSON.parseObject(wxRes, WxAuth.class);
        assert wxAuth != null;
        return wxAuth.getErrcode() != null ? new User() : this.userSev.saveOne(new User(wxAuth.getOpenid(), avatar, userName));
    }
}
