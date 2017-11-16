package com.tcc.news.controller;

import com.tcc.news.dto.FeedDto;
import com.tcc.news.dto.UserDto;
import com.tcc.news.service.logic.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feed")
public class FeedController {

    @Autowired
    private FeedService feedService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public Object findFeed(@RequestParam(name = "token") String token) {
        return feedService.findFeed(token);
    }
}

