package com.zhongfeng.api.modules.utils.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 基础分页
 * @author blueCat
 * @since 2022/2/25
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BasePageSearch extends BaseSearch implements Serializable {
    /**
     * 每页大小
     */
    private long pageSize;

    /**
     * 用户类型(0为超级管理员，1为销售，2为运维，3为技术)
     */
    private Integer userType;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 用户姓名
     */
    private String realName;

    /**
     * 第几页
     */
    private long pageNum;

    /**
     * 排序列
     */
    private String orderByColumn;

    /**
     * 排序的方向“desc”或者“asc”
     */
    private String isAsc;

}
