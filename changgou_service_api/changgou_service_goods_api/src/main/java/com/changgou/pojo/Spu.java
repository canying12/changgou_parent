package com.changgou.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 残影
 * @date 2020/5/12 16:20
 */
@ApiModel("Spu")
@Table(name = "tb_spu")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Spu {
    @Id
    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty("货号")
    private String sn;

    @ApiModelProperty("spu名")
    private String name;

    @ApiModelProperty("副标题")
    private String caption;

    @ApiModelProperty("品牌id")
    private Integer brandId;

    @ApiModelProperty("一级分类")
    private Integer category1Id;

    @ApiModelProperty("二级分类")
    private Integer category2Id;

    @ApiModelProperty("三级分类")
    private Integer category3Id;

    @ApiModelProperty("模板id")
    private Integer templateId;

    @ApiModelProperty("运费模板id")
    private Integer freightId;

    @ApiModelProperty("图片")
    private String image;

    @ApiModelProperty("图片列表")
    private String images;

    @ApiModelProperty("售后服务")
    private String saleService;

    @ApiModelProperty("介绍")
    private String introduction;

    @ApiModelProperty("规格列表")
    private String specItems;

    @ApiModelProperty("参数列表")
    private String paraItems;

    @ApiModelProperty("销量")
    private Integer saleNum;

    @ApiModelProperty("_num int(11)")
    private Integer commentNum;

    @ApiModelProperty("是否上架，0已下架，1已上架")
    private String isMarketable;

    @ApiModelProperty("是否启用规格")
    private String isEnableSpec;

    @ApiModelProperty("是否删除，0:未删除，1：已删除")
    private String isDelete;

    @ApiModelProperty("审核状态，0：未审核，1：已审核，2：审核不通过")
    private String status;
}
