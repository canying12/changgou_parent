package com.changgou.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * admin
 *
 * @author yxr 2020-04-28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("admin")
@Table(name = "tb_admin")
public class Admin {
    @Id
    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("用户名")
    private String loginName;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("状态")
    private String status;

}