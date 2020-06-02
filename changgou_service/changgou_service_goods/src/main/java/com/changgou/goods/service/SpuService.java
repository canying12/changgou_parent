package com.changgou.goods.service;

import com.changgou.entity.PageResult;
import com.changgou.pojo.Goods;
import com.changgou.pojo.Spu;

/**
 * @author 残影
 * @date 2020/5/12 17:19
 */
public interface SpuService {
    /**
     * 查询所有商品信息
     * @param page
     * @param limit
     * @return
     */
    PageResult<Spu> findAll(Integer page, Integer limit);

    /**
     * 添加商品信息
     * @param goods
     */
    void add(Goods goods);

    /**
     * 根据id查询商品信息
     * @param id
     * @return
     */
    Goods findById(Integer id);

    /**
     * 根据id进行修改
     * @param goods
     * @param id
     */
    void update(Goods goods, Integer id);
}
