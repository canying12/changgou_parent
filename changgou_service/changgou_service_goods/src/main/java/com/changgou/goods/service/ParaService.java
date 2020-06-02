package com.changgou.goods.service;

import com.changgou.entity.PageResult;
import com.changgou.vo.ParaVo;

/**
 * 规格参数
 * @author 残影
 * @date 2020/5/11 19:00
 */
public interface ParaService {
    /**
     * 根据模板id查询所有规格
     * @param templateId
     * @return
     */
    PageResult<ParaVo> findAllByTemplateId(Integer templateId,Integer page,Integer limit);

    /**
     * 模糊搜搜
     * @param templateId
     * @param search
     * @param page
     * @param limit
     * @return
     */
    PageResult<ParaVo> fuzzyQuery(Integer templateId, String search, Integer page, Integer limit);
}
