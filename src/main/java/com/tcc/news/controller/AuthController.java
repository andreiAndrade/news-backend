package com.tcc.news.controller;

import com.tcc.news.service.logic.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public Object auth() {
        return authService.auth();
    }

    @RequestMapping(value = "token", method = RequestMethod.POST)
    @ResponseBody
    public Object token(@RequestParam(name = "code") String authUri) {
        return authService.token(authUri);
    }


}