package com.tcc.news.service.logic;

import com.tcc.news.dto.FeedDto;
import org.springframework.stereotype.Service;

@Service
public class FeedService {

    public FeedDto findFeed(Long id) {
        return new FeedDto();
    }
}
