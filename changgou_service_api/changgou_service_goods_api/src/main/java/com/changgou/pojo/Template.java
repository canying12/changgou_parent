package com.changgou.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

/**
 * @author 残影
 * @// TODO: 2020/5/10
 */
@ApiModel("规格模板")
@Table(name = "tb_template")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Template {

    @Id
    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("模板名称")
    private String name;

    @ApiModelProperty("规格数量")
    private Integer specNum;

    @ApiModelProperty("参数数量")
    private Integer paraNum;

    @ApiModelProperty("规格")
    private List<Spec> spec;
}