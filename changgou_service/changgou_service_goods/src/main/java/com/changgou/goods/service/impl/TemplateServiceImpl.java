package com.changgou.goods.service.impl;

import com.changgou.entity.PageResult;
import com.changgou.goods.dao.TemplateMapper;
import com.changgou.goods.service.TemplateService;
import com.changgou.pojo.Template;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

/**
 * @author 残影
 * @date 2020/5/10 9:51
 */
@Service
public class TemplateServiceImpl implements TemplateService {
    @Autowired
    private TemplateMapper templateMapper;

    @Override
    public PageResult<Template> findAll(Integer page, Integer limit) {
        Page<Template> pageList = PageHelper.startPage(page, limit).doSelectPage(() -> templateMapper.selectAll());
        PageResult<Template> pageResult = new PageResult<>(pageList.getTotal(), pageList.getResult());
        return pageResult;
    }

    @Override
    public int delById(Integer id) {
        int num = templateMapper.deleteByPrimaryKey(id);
        return num;
    }

    @Override
    public PageResult<Template> fuzzyQuery(String search, Integer page, Integer limit) {
        Example example = new Example(Template.class);
        Example.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(search)) {
            criteria.andLike("name", "%" + search + "%");
        }
        Page<Template> pageList = PageHelper.startPage(page, limit).doSelectPage(() -> templateMapper.selectByExample(example));
        PageResult<Template> pageResult = new PageResult(pageList.getTotal(), pageList.getResult());

        return pageResult;
    }

    @Override
    public void insert(Template template) {
        templateMapper.insertSelective(template);
    }
}
