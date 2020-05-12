package com.changgou.goods.service;

import com.changgou.entity.PageResult;
import com.changgou.pojo.Album;
import com.changgou.vo.AlbumVo;

/**
 * 相册service
 * @author 残影 
 * @// TODO: 2020/5/9
 */
public interface AlbumService {
    //分页查询所有
    PageResult<AlbumVo> pageListCount(Integer page, Integer limit);

    //通过id进行删除
    int deleteById(Integer id);

    //通过相册名称进行模糊查询
    PageResult<Album> fuzzySearch(String search, Integer page, Integer limit);
}
