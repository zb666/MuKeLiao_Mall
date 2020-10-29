package com.imooc.mall.dao;

import com.imooc.mall.pojo.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
public interface ICategoryMapper {

    @Select("select * from mall_category where id = #{id}")
    Category findCategoryById(@Param("id") Integer id);

}
