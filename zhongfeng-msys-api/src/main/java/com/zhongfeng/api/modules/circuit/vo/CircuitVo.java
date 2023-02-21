package com.zhongfeng.api.modules.circuit.vo;


import lombok.Data;

@Data
public class CircuitVo {

    /**
     * 自增主键
     */
    private Integer id;

    /**
     * 线路属性id
     */
    private String propertyId;

    /**
     * 线路属性
     */
    private String property;

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
     * 频率
     */

    private String frequency;

    /**
     * 价格
     */
    private String price;

    /**
     * 更新时间
     */

    private String updateTime;

    /**
     * 线路属性
     */
    private String circuitProperty;

    /**
     * 时间段
     */
    private String timeSpan;
}
