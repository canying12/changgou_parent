package com.changgou.goods.controller;

import com.changgou.entity.PageResult;
import com.changgou.entity.Result;
import com.changgou.entity.StatusCode;
import com.changgou.goods.service.ParaService;
import com.changgou.vo.ParaVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 残影
 * @date 2020/5/11 18:58
 */
@Api(tags = "规格参数")
@RestController
@RequestMapping("/para")
public class ParaController {
    @Autowired
    private ParaService paraService;

    @ApiOperation("根据模板id查询所有规格")
    @GetMapping("/findAllByTemplateId")
    public Result findAllByTemplateId(@RequestParam Integer templateId,@RequestParam Integer page,
                                      @RequestParam Integer limit){
        PageResult<ParaVo> paraVoPageResult = paraService.findAllByTemplateId(templateId,page,limit);
        return new Result(true, StatusCode.OK,"查询成功",paraVoPageResult);
    }

    @ApiOperation("模糊搜索")
    @GetMapping("/search")
    public Result fuzzyQuery (@RequestParam Integer templateId,@RequestParam String search,
                              @RequestParam Integer page,@RequestParam Integer limit ){
        PageResult<ParaVo> paraVoPageResult =paraService.fuzzyQuery(templateId,search,page,limit);
        return new Result(true,StatusCode.OK,"查询成功",paraVoPageResult);
    }
}
