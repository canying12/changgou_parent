package com.changgou.goods.controller;

import com.changgou.entity.PageResult;
import com.changgou.entity.Result;
import com.changgou.entity.StatusCode;
import com.changgou.goods.service.AlbumService;
import com.changgou.pojo.Album;
import com.changgou.vo.AlbumVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 残影
 * @// TODO: 2020/5/9
 */
@Api(tags = "相册模块")
@RestController
@RequestMapping("/album")
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @ApiOperation("分页查询所有")
    @GetMapping("/findAll")
    public Result pageListCount(@RequestParam Integer page, @RequestParam Integer limit) {
        PageResult<AlbumVo> pageResult = albumService.pageListCount(page, limit);
        return new Result(true, StatusCode.OK, "查询成功", pageResult);
    }

    @ApiOperation("通过id进行删除")
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id){
        int num  =  albumService.deleteById(id);
        if (num >0){
            return new Result(true,StatusCode.OK,"删除成功");
        }
        return new Result(false,StatusCode.ERROR,"删除失败");
    }

    @ApiOperation("通过相册名称进行模数查询")
    @GetMapping("/search")
    public  Result fuzzySearch(@RequestParam String search,@RequestParam Integer page,
                               @RequestParam Integer limit){
        PageResult<Album> pageResult = albumService.fuzzySearch(search,page,limit);
        return new Result(true,StatusCode.OK,"查询成功",pageResult);
    }
}
