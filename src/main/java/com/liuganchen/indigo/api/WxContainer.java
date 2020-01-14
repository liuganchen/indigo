package com.liuganchen.indigo.api;

import com.alibaba.fastjson.JSON;
import com.liuganchen.indigo.entity.User;
import com.liuganchen.indigo.entity.WxAuth;
import com.liuganchen.indigo.service.UserSev;
import com.liuganchen.indigo.util.AuthUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

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
    @Value("${wx.config.url}")
    private String wxUrl;
    private RestTemplate restTemplate = new RestTemplate();
    @Resource
    private UserSev userSev;

    public WxContainer() {
    }

    @RequestMapping("/register")
    @GetMapping
    public String register(String code, String userName, String avatar) {
        var wxRes = this.restTemplate.getForObject(this.wxUrl, String.class, this.appid, this.secret, code);
        var wxAuth = JSON.parseObject(wxRes, WxAuth.class);
        assert wxAuth != null : "请求微信认证失败接口失败";
        assert wxAuth.getErrcode() == null : "微信认证错误：" + wxAuth.getErrmsg();
        var userId = this.userSev.saveOne(new User(wxAuth.getOpenid(), avatar, userName)).getId() + "";
        // 加密一下
        return AuthUtil.encryption(userId);
    }
}
