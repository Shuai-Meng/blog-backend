package com.blog.backend.dao;

import com.blog.backend.entity.BlogVisit;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author mengshuai
 * @since 2018.09.29
 */
@Repository
public interface BlogVisitMapper {
    int insert(BlogVisit record);

    BlogVisit select();

    int incrementByOne();
}