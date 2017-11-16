package com.tcc.news.controller;

import com.tcc.news.dto.FeedDto;
import com.tcc.news.service.logic.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/feed")
public class FeedController {

    @Autowired
    private FeedService feedService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public FeedDto findFeed(@RequestParam(name = "id") Long id) {
        return feedService.findFeed(id);
    }
}