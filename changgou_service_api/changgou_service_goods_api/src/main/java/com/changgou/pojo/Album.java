package com.changgou.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * album
 * @author 残影 2020-05-09
 */

@ApiModel("相册")
@Table(name = "tb_album")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Album {
    @Id
    @ApiModelProperty("编号")
    private Long id;

    @ApiModelProperty("相册名称")
    private String title;

    @ApiModelProperty("相册封面")
    private String image;

    @ApiModelProperty("图片列表")
    private String imageItems;

}