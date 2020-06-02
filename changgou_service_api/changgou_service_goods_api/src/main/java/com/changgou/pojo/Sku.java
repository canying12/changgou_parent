package com.changgou.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author 残影
 * @date 2020/5/14 10:04
 */
@ApiModel("商品表")
@Table(name = "tb_sku")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Sku {
    @Id
    @ApiModelProperty("商品id")
    private Long id;

    @ApiModelProperty("商品条码")
    private String sn;

    @ApiModelProperty("sku名称")
    private String name;

    @ApiModelProperty("价格（分）")
    private Integer price;

    @ApiModelProperty("库存数量")
    private Integer num;

    @ApiModelProperty("库存预警数量")
    private Integer alertNum;

    @ApiModelProperty("商品图片")
    private String image;

    @ApiModelProperty("商品图片列表")
    private String images;

    @ApiModelProperty("重量（克）")
    private Integer weight;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    @ApiModelProperty("spuid")
    private Long spuId;

    @ApiModelProperty("类目id")
    private Integer categoryId;

    @ApiModelProperty("类目名称")
    private String categoryName;

    @ApiModelProperty("品牌名称")
    private String brandName;

    @ApiModelProperty("规格")
    private String spec;

    @ApiModelProperty("销量")
    private Integer saleNum;

    @ApiModelProperty("_num int(11)")
    private Integer commentNum;

    @ApiModelProperty("商品状态 1-正常，2-下架，3-删除")
    private String status;
}
