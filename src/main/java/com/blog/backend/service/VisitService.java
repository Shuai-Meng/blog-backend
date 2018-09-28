package com.blog.backend.service;

import org.springframework.stereotype.Service;

/**
 * @author mengshuai
 */
@Service
public class VisitService {
    public int addVisitForPost(String postId) {
        int original = 4;
        //now add 1 for post and blog
        return original;
    }

    public int getVisitForBlog() {
        return 333;
    }
}
