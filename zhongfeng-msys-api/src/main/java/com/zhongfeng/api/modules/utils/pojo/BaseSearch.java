package com.zhongfeng.api.modules.utils.pojo;


import java.io.Serializable;

/**
 * 基础搜索类
 * @author blueCat
 * @since 2022/2/25
 */
public class BaseSearch implements Serializable {
    /**
     * 要查询的表名
     */
    private String tableName;

    /**
     * 开始时间
     */
    private String startTime;

    /**
     * 结束时间
     */
    private String endTime;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
