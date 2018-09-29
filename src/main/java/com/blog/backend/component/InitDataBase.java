package com.blog.backend.component;

import com.blog.backend.dao.BlogVisitMapper;
import com.blog.backend.entity.BlogVisit;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author mengshuai
 * @since 2018.09.29
 */
@Component
public class InitDataBase implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        BlogVisitMapper blogVisitMapper = contextRefreshedEvent.getApplicationContext().getBean(BlogVisitMapper.class);

        if (blogVisitMapper.select() == null) {
            BlogVisit blogVisit = new BlogVisit();
            blogVisit.setVisit(0L);
            blogVisitMapper.insert(blogVisit);
        }
    }
}
