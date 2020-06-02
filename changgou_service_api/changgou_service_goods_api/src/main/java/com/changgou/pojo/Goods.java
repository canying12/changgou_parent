package com.changgou.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * @author 残影
 * @date 2020/5/14 10:13
 */
@ApiModel("商品组合实体类")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Goods {
    @ApiModelProperty("商品基本信息")
    private Spu spu;
    @ApiModelProperty("商品详细信息")
    private List<Sku> skuList;
}
