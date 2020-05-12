package com.changgou.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Id;

/**
 * @author 残影
 * @date 2020/5/11 10:37
 */
@ApiModel("规格视图")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SpecVo {
    @Id
    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("规格名称")
    private String name;

    @ApiModelProperty("模板名称")
    private  String templateName;

    @ApiModelProperty("规格选项")
    private String options;

    @ApiModelProperty("排序")
    private Integer seq;

    @ApiModelProperty("模板id")
    private Integer templateId;

}
