package com.blog.backend.controller;

import com.blog.backend.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mengshuai
 * @since 2018.09.28
 */
@RestController
@CrossOrigin({"http://localhost:4000", "http://shuai-meng.github.io"})
public class VisitController {
    @Autowired
    private VisitService visitService;

    @GetMapping("/getBlogVisit")
    public Long getBlogVisit() {
        return visitService.getVisitForBlog();
    }

    @PostMapping("/addPostVisit")
    public Integer addPostVisit(@RequestParam("postId") String postId) {
        return visitService.addVisitForPost(postId);
    }
}
