package com.changgou.goods.controller;

import com.changgou.entity.PageResult;
import com.changgou.entity.Result;
import com.changgou.entity.StatusCode;
import com.changgou.goods.service.SpuService;
import com.changgou.pojo.Goods;
import com.changgou.pojo.Spu;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 残影
 * @date 2020/5/12 17:16
 */
@Api(tags = "商品基本信息")
@RestController
@RequestMapping("/spu")
public class SpuController {
    @Autowired
    private SpuService spuService;

    @ApiOperation("查询所有商品信息")
    @GetMapping("/findAll")
    public Result findAll(@RequestParam Integer page,@RequestParam Integer limit){
        PageResult<Spu> pageResult = spuService.findAll(page,limit);
        return new Result(true, StatusCode.OK,"查询成功",pageResult);
    }

    @ApiOperation("添加商品")
    @PostMapping("/add")
    public Result add(@RequestBody Goods goods){
        spuService.add(goods);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    @ApiOperation("根据id查询商品信息")
    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id){
        Goods goods = spuService.findById(id);
        return new Result(true,StatusCode.OK,"查询成功",goods);
    }

    @PutMapping("/{id}")
    public Result update(@RequestBody Goods goods,@PathVariable Integer id){
        spuService.update(goods,id);
        return new Result(true,StatusCode.OK,"修改成功");
    }
}
