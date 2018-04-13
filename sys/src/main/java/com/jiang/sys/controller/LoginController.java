package com.jiang.sys.controller;

import com.alibaba.fastjson.JSON;
import com.jiang.common.result.CodeMessage;
import com.jiang.common.result.Result;
import com.jiang.sys.annotation.ControllerLog;
import com.jiang.sys.domain.SysUser;
import com.jiang.sys.service.systemservice.interfaceclass.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
@Slf4j
public class LoginController {
    @Resource
    private SysUserService sysUserService;
    private Result result=null;

    @ControllerLog(description="登入系统")
    @GetMapping ("/login")
    public String to_login(HttpServletResponse response, HttpServletRequest request, Model model) throws Exception {
        model.addAttribute("title", "jiang");
        return "login/login";
    }
    @ControllerLog(description="登入系统")
    @ResponseBody
    @PostMapping("/login")
    public Result do_login(String username,String password) throws Exception {
        Result result =Result.success();
        return result;
    }

    @ControllerLog(description="登入系统")
    @GetMapping ("/index")
    public String to_index(HttpServletResponse response, HttpServletRequest request, Model model) throws Exception {
        model.addAttribute("main", "/sys/sysDept");
        return "login/index";
    }


}