package com.isiyi.hikari.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * ip的实体类
 * @author 思意
 * @date 2020/12/26
 */
@Data
@TableName("crawl_ip")
public class IpDomain {
    /**
     * id
     */
    @TableId(value = "id",type = IdType.AUTO)//指定自增策略
    private  Long id;
    /**
     * ip
     */
    private String ipStr;
    /**
     * 端口
     */
    private Integer port;
    /**
     * 隐秘类型 0-透明，1-高度隐秘
     */
    private Integer secretType;
    /**
     * 请求类型 http OR https
     */
    private String requestType;
    /**
     * 区域
     */
    private String area;
    /**
     * 运营商
     */
    private String  operator;
    /**
     * 响应速度
     */
    private String speed;
    /**
     * 检查时间
     */
    private Date checkTime;
    /**
     * 数据来源
     */
    private String source;

    /**
     * 是否可用 0-不可用， 1-可用
     */
    private Integer status;
    /**
     * 使用次数
     */
    private Long useTimes;

}
