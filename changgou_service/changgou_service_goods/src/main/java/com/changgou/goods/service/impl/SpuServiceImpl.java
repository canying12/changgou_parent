package com.changgou.goods.service.impl;

import com.alibaba.fastjson.JSON;
import com.changgou.entity.PageResult;
import com.changgou.goods.dao.*;
import com.changgou.goods.service.SpuService;
import com.changgou.pojo.*;
import com.changgou.util.IdWorker;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author 残影
 * @date 2020/5/12 17:22
 */
@Service
public class SpuServiceImpl implements SpuService {
    @Autowired
    private SpuMapper spuMapper;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private BrandMapper brandMapepr;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private SkuMapper skuMapper;

    @Autowired
    private CategoryBrandMapper categoryBrandMapper;

    @Override
    public PageResult<Spu> findAll(Integer page, Integer limit) {
        Page<Spu> pageList = PageHelper.startPage(page, limit).doSelectPage(() -> spuMapper.selectAll());
        PageResult<Spu> pageResult = new PageResult(pageList.getTotal(), pageList.getResult());
        return pageResult;
    }

    /**
     * 保存商品 SPU+SKU列表
     *
     * @param goods 商品组合实体类
     */
    @Override
    public void add(Goods goods) {
        //生成spuId
        long spuId = idWorker.nextId();
        //将spuId放入Spu对象中
        goods.getSpu().setId(spuId);
        //添加保存Spu数据
        spuMapper.insertSelective(goods.getSpu());

        //保存Sku集合数据到数据库
        saveSkuList(goods);
    }

    @Override
    public Goods findById(Integer id) {
        //查询spu
        Spu spu = spuMapper.selectByPrimaryKey(id);

        //查询SKU 列表
        Example example = new Example(Sku.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("spuId",id);
        List<Sku> skuList = skuMapper.selectByExample(example);

        //封装，返回
        Goods goods =new Goods();
        goods.setSpu(spu);
        goods.setSkuList(skuList);
        return goods;
    }

    @Override
    public void update(Goods goods, Integer id) {
        //取出spu部分
        Spu spu = goods.getSpu();
        spuMapper.updateByPrimaryKey(spu);

        //删除原sku列表
        Example example = new Example(Sku.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("spuId",spu.getId());
        skuMapper.deleteByExample(example);

        saveSkuList(goods);
    }

    /**
     * 保存sku表
     *
     * @param goods
     */
    private void saveSkuList(Goods goods) {
        //获取spu对象
        Spu spu = goods.getSpu();
        //当前日期
        Date date = new Date();
        //获取品牌对象
        Brand brand = brandMapepr.selectByPrimaryKey(spu.getBrandId());
        //获取分类对象
        Category category = categoryMapper.selectByPrimaryKey(spu.getCategory3Id());

        /**
         * 添加分类与品牌之间的关联
         */
        CategoryBrand categoryBrand = new CategoryBrand();
        categoryBrand.setBrandId(spu.getBrandId());
        categoryBrand.setCategoryId(spu.getCategory3Id());
        int count = categoryBrandMapper.selectCount(categoryBrand);
        //判断是否有这个品牌和分类的关系数据
        if (count == 0){
            //如果没有关系数据则添加品牌和分类关系数据
            categoryBrandMapper.insert(categoryBrand);
        }
        //获取sku集合对象
        List<Sku> skuList = goods.getSkuList();
        if (skuList != null) {
            for (Sku sku : skuList) {
                //设置sku主键ID
                sku.setId(idWorker.nextId());
                //设置sku规格
                if (StringUtils.isEmpty(sku.getSpec())) {
                    sku.setSpec("{}");
                }
                //设置sku名称(商品名称 + 规格)
                String name = spu.getName();
                //将规格json字符串转换成Map
                Map<String, String> map = JSON.parseObject(sku.getSpec(), Map.class);
                if (map != null && map.size() > 0) {
                    for (String value : map.values()) {
                        name += value;
                    }
                }
                sku.setName(name);//名称
                sku.setSpuId(spu.getId());//设置spu的ID
                sku.setCreateTime(date);//创建日期
                sku.setUpdateTime(date);//修改日期
                sku.setCategoryId(category.getId());//商品分类ID
                sku.setCategoryName(category.getName());//商品分类名称
                sku.setBrandName(brand.getName());//品牌名称
                skuMapper.insertSelective(sku);//插入sku表数据

            }
        }
    }

}
