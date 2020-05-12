package com.changgou.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 残影
 * @// TODO: 2020/5/9
 */
@ApiModel("相册页面对象")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlbumVo {
    @Id
    @ApiModelProperty("编号")
    private Long id;

    @ApiModelProperty("相册名称")
    private String title;

    @ApiModelProperty("相册封面")
    private String image;

    @ApiModelProperty("数量")
    private Integer number;

    @ApiModelProperty("描述")
    private String describe;

    @ApiModelProperty("图片列表")
    private String imageItems;
}
