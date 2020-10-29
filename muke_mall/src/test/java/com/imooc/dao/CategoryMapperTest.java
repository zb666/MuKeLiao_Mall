package com.imooc.dao;

import com.imooc.mall.dao.ICategoryMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoryMapperTest extends MallApplicationTest {

    @Autowired
    private ICategoryMapper categoryMapper;

    @Test
    public void testCategory(){
        categoryMapper.findCategoryById(100002);
    }

}
