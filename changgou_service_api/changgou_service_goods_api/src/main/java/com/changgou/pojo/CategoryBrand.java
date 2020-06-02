package com.changgou.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Table;

/**
 * 分类品牌中间表对象
 * @author 残影
 * @date 2020/5/12 11:34
 */
@ApiModel("分类品牌中间表对象")
@Table(name = "tb_category_brand")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CategoryBrand {
    @ApiModelProperty("分类id")
    private Integer categoryId;

    @ApiModelProperty("品牌id")
    private Integer brandId;

}
