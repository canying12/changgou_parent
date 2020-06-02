package com.changgou.goods.service;

import com.changgou.entity.PageResult;
import com.changgou.pojo.Template;

/**
 * 规格参数
 * @author 残影
 * @date 2020/5/10 9:50
 */
public interface TemplateService {
    //分页查询
    PageResult<Template> findAll(Integer page, Integer limit);

    //通过id进行删除
    int delById(Integer id);

    //根据模板名称进行模糊查询
    PageResult<Template> fuzzyQuery(String search, Integer page, Integer limit);

    //新增模板
    void insert(Template template);
}
