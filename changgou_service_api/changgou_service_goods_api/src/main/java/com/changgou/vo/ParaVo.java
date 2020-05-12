package com.changgou.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author 残影
 * @date 2020/5/11 18:57
 */
@ApiModel("参数表视图")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ParaVo implements Serializable {
    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("选项")
    private String options;

    @ApiModelProperty("排序")
    private Integer seq;

    @ApiModelProperty("模板id")
    private Integer templateId;

    @ApiModelProperty("模板名称")
    private String templateName;
}
