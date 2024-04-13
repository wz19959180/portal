package com.record.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author wz
 * @since 2024-04-13
 */
@Getter
@Setter
@TableName("t_hepatoCAR")
@ApiModel(value = "HepatoCAR对象", description = "")
public class HepatoCAR implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("性别")
    @TableField("sex")
    private String sex;

    @ApiModelProperty("年龄")
    @TableField("age")
    private String age;

    @ApiModelProperty("是否饮酒 0是1否")
    @TableField("isaod")
    private String isaod;

    @ApiModelProperty("是否有慢性乙肝感染 0是1否")
    @TableField("ischbi")
    private String ischbi;

    @ApiModelProperty("乙肝病毒DNA")
    @TableField("hbvdna")
    private String hbvdna;

    @ApiModelProperty("谷丙转氨酶")
    @TableField("alt")
    private String alt;

    @ApiModelProperty("谷草转氨酶")
    @TableField("ast")
    private String ast;

    @ApiModelProperty("白蛋白")
    @TableField("alb")
    private String alb;

    @ApiModelProperty("总胆红素")
    @TableField("tbil")
    private String tbil;

    @ApiModelProperty("血小板计数")
    @TableField("plt")
    private String plt;

    @ApiModelProperty("甲胎蛋白")
    @TableField("afp")
    private String afp;

    @ApiModelProperty("MiRNA-15a")
    @TableField("MiRNA15a")
    private String miRNA15a;

    @ApiModelProperty("MiRNA-16")
    @TableField("MiRNA16")
    private String miRNA16;

    @ApiModelProperty("评估得分")
    @TableField("score")
    private String score;

    @TableField("createtime")
    private String createtime;
}
