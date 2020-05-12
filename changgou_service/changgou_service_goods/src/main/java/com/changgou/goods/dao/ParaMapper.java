package com.changgou.goods.dao;

import com.changgou.pojo.Para;
import com.changgou.vo.ParaVo;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author 残影
 * @date 2020/5/11 19:02
 */
public interface ParaMapper extends Mapper<Para> {

    /**
     * 根据模板id查询规格
     * @param templateId
     * @return
     */
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "name",column = "name"),
            @Result(property = "options",column = "options"),
            @Result(property = "seq",column = "seq"),
            @Result(property = "templateName",column = "templateName"),
    })
    @Select("select b.id,b.name, b.options,b.seq,b.template_id,a.name as templateName  " +
            "from tb_template a inner join tb_para b  " +
            "on a.id = b.template_id and a.id = #{templateId} ")
    List<ParaVo> findAllByTemplateId(Integer templateId);
}
