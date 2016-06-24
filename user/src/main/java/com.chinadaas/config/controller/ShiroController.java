package com.chinadaas.config.controller;

import com.chinadaas.base.BaseController;
import com.chinadaas.config.shiro.ShiroConfig;
import com.chinadaas.dao.UserDao;
import com.chinadaas.entity.User;
import com.chinadaas.vo.UserVO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by xie on 16/6/23.
 */
@RestController
public class ShiroController extends BaseController{

    private static final Log LOG = LogFactory.getLog(ShiroConfig.class);

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/login")
    public Object login(@Valid UserVO user, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return getErrorDTO(bindingResult);
        }

        String username = user.getUsername();
        String password = user.getPassword();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        Subject currentUser = SecurityUtils.getSubject();

        try{
            currentUser.login(token);
        }catch (UnknownAccountException ue) {
            LOG.info("对用户[" + username + "]进行登录验证..验证未通过,未知账户");
            throw new UnknownAccountException("账号不存在");
        }catch (IncorrectCredentialsException ie) {
            LOG.info("对用户[" + username + "]进行登录验证..验证未通过,密码不正确");
            throw new IncorrectCredentialsException("账号密码不正确");
        }
        return getSuccessDTO();
    }

}
