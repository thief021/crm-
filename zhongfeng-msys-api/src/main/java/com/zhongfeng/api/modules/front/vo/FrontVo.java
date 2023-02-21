package com.zhongfeng.api.modules.front.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author blueCat
 * @date 2023/2/2 13:40
 * @motto life is a gift
 */
@Data
public class FrontVo implements Serializable {
    /**
     * 上游id
     */
    private Integer id;

    /**
     * 用户Id
     */
    private Integer userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 客户id
     */
    private Integer customerId;

    /**
     * 公司名
     */
    private String company;

    /**
     * 线路属性
     */
    private String circuitProperty;

    /**
     * 线路id
     */
    private Integer circuitId;

    /**
     * 时间段
     */
    private String timeSpan;

    /**
     * 开始时间
     */
    private String startTime;

    /**
     * 结束时间
     */
    private String endTime;

    /**
     * 外显
     */
    private String prefix;

    /**
     * 盲区
     */
    private String blindArea;

    /**
     * 频次
     */
    private String frequency;

    /**
     * 价格
     */
    private Double price;

    /**
     * 更新时间
     */
    private String updateTime;

}
