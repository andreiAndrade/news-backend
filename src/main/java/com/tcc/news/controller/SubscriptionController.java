package com.tcc.news.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.tcc.news.dto.FeedDto;
import com.tcc.news.dto.SubscriptionDto;
import com.tcc.news.service.logic.FeedService;
import com.tcc.news.service.logic.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public List<SubscriptionDto> list(@RequestParam(name = "token") String token) {
        return subscriptionService.list(token);
    }
}