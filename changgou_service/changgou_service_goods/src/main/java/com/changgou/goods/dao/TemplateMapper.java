package com.changgou.goods.dao;

import com.changgou.pojo.Template;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**模板参数
 * @author 残影
 * @date 2020/5/10 9:52
 */
public interface TemplateMapper extends Mapper<Template>{
    /**
     * 通过模板id查询规格信息
     * @param templateId
     * @return
     */

    @Results({
            @Result(id=true,property = "id" ,column = "id"),
            @Result(property = "name",column = "name"),
            @Result(property = "spec",column = "template_id" ,javaType = List.class,
                    many = @Many(select = "com.changgou.goods.dao.SpecMapper.findByTemplate")
            )
    })
    @Select("select name from tb_template where id = #{templateId}")
    List<Template> findAllByTemplateId(Integer templateId);
}
