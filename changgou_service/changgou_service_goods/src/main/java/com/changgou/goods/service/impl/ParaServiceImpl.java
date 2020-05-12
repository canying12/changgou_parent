package com.changgou.goods.service.impl;

import com.changgou.entity.PageResult;
import com.changgou.goods.dao.ParaMapper;
import com.changgou.goods.service.ParaService;
import com.changgou.vo.ParaVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 残影
 * @date 2020/5/11 19:01
 */
@Service
public class ParaServiceImpl implements ParaService {
    @Autowired
    private ParaMapper paraMapper;
    @Override
    public PageResult<ParaVo> findAllByTemplateId(Integer templateId,Integer page,Integer limit) {
        Page<ParaVo> pageList = PageHelper.startPage(page, limit).doSelectPage(() -> paraMapper.findAllByTemplateId(templateId));
        PageResult<ParaVo> paraVoPageResult = new PageResult(pageList.getTotal(),pageList.getResult());
        return paraVoPageResult;
    }
}
