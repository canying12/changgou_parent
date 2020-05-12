package com.changgou.goods.controller;

import com.changgou.entity.PageResult;
import com.changgou.entity.Result;
import com.changgou.entity.StatusCode;
import com.changgou.goods.service.TemplateService;
import com.changgou.pojo.Template;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 规格参数
 * @author 残影
 * @date 2020/5/10 9:48
 */
@Api("模板参数")
@RestController
@RequestMapping("/template")
public class TemplateController {
    @Autowired
    private TemplateService templateService;

    @ApiOperation("通过id进行删除")
    @DeleteMapping("/{id}")
    public Result delById(@PathVariable Integer id){
        int num = templateService.delById(id);
        if (num > 0){
            return new Result(true,StatusCode.OK,"删除成功");
        }
        return new Result(false,StatusCode.ERROR,"删除失败");
    }
    @ApiOperation("分页查询所有")
    @GetMapping("/findAll")
    public Result findAll(@RequestParam Integer page,@RequestParam Integer limit){
        PageResult<Template> pageResult = templateService.findAll(page,limit);
        return new Result(true, StatusCode.OK,"查询成功",pageResult);
    }

    @ApiOperation("根据模板名称进行模糊查询")
    @GetMapping("/search")
    public Result fuzzyQuery(@RequestParam String search,@RequestParam Integer page,
                             @RequestParam Integer limit){
        PageResult<Template> pageResult = templateService.fuzzyQuery(search,page,limit);
        return new Result(true,StatusCode.OK,"查询成功",pageResult);
    }

}
