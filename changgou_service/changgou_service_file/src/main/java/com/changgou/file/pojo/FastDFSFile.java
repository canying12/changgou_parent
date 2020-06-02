package com.changgou.file.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 残影
 * @date 2020/5/12 14:31
 */
@ApiModel("文件上传")
@Data
@AllArgsConstructor
public class FastDFSFile {
    @ApiModelProperty("文件名字")
    private String name;

    @ApiModelProperty("文件内容")
    private byte[] content;

    @ApiModelProperty("文件扩展名")
    private String ext;

    @ApiModelProperty("文件MD5摘要值")
    private String md5;

    @ApiModelProperty("文件创建作者")
    private String author;

    public FastDFSFile(String name, byte[] content, String ext) {
        super();
        this.name = name;
        this.content = content;
        this.ext = ext;
    }
}
