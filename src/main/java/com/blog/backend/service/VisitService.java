package com.blog.backend.service;

import com.blog.backend.dao.BlogVisitMapper;
import com.blog.backend.dao.PostVisitMapper;
import com.blog.backend.entity.PostVisit;
import com.blog.backend.entity.PostVisitExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author mengshuai
 * @since 2018.09.28
 */
@Service
public class VisitService {
    @Autowired
    private PostVisitMapper postVisitMapper;
    @Autowired
    private BlogVisitMapper blogVisitMapper;

    @Transactional(rollbackFor = Exception.class)
    public int addVisitForPost(String postId) {
        PostVisitExample postVisitExample = new PostVisitExample();
        postVisitExample.createCriteria().andPostIdEqualTo(postId);

        List<PostVisit> list = postVisitMapper.selectByExample(postVisitExample);
        PostVisit postVisit;
        int original = 0;
        if (list.size() == 0) {
            postVisit = new PostVisit();
            postVisit.setPostId(postId);
            postVisit.setVisit(1);
            postVisitMapper.insertSelective(postVisit);
        } else {
            postVisit = list.get(0);
            original = postVisit.getVisit();
            postVisit.setVisit(original + 1);
        }

        addBlogVisit();
        return original;
    }

    public long getVisitForBlog() {
        return blogVisitMapper.select().getVisit();
    }

    @Transactional(rollbackFor = Exception.class)
    public int addBlogVisit() {
        return blogVisitMapper.incrementByOne();
    }
}
