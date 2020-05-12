package com.changgou.goods.service.impl;

import com.changgou.entity.PageResult;
import com.changgou.goods.dao.AlbumMapper;
import com.changgou.goods.service.AlbumService;
import com.changgou.pojo.Album;
import com.changgou.vo.AlbumVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 残影
 * @// TODO: 2020/5/9
 */
@Service
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    private AlbumMapper albumMapper;

    @Override
    public PageResult<AlbumVo> pageListCount(Integer page, Integer limit) {
        List<AlbumVo> albumVoList = new ArrayList<>();
        PageHelper.startPage(page, limit);
        List<Album> albumList = albumMapper.selectAll();

        List<Album> albumList2 = albumMapper.selectAll();
        for (Album album : albumList) {
            AlbumVo albumVo = new AlbumVo();
            albumVo.setId(album.getId());
            albumVo.setTitle(album.getTitle());
            albumVo.setImage(album.getImage());
            albumVo.setImageItems(album.getImageItems());
            albumVoList.add(albumVo);
        }
        PageResult<AlbumVo> pageResult = new PageResult((long) albumList2.size(), albumVoList);
        return pageResult;
    }

    @Override
    public int deleteById(Integer id) {
        return albumMapper.deleteByPrimaryKey(id);
    }

    @Override
    public PageResult<Album> fuzzySearch(String search, Integer page, Integer limit) {
        Example example = new Example(Album.class);
        Example.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(search)) {
            criteria.andLike("title", "%" + search + "%");
        }
        Page<Album> pageList = PageHelper.startPage(page, limit).doSelectPage(() -> albumMapper.selectByExample(example));

        PageResult<Album> pageResult = new PageResult(pageList.getTotal(), pageList.getResult());
        return pageResult;
    }
}