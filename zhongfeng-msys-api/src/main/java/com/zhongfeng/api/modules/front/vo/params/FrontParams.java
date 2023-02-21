package com.zhongfeng.api.modules.front.vo.params;

import com.zhongfeng.api.modules.utils.pojo.BasePageSearch;
import lombok.Data;

import java.util.List;

/**
 * @author blueCat
 * @date 2023/2/2 13:48
 * @motto life is a gift
 */
@Data
public class FrontParams extends BasePageSearch {

    /**
     * 上游id
     */
    private Integer id;

    /**
     * 公司名
     */
    private String company;

    /**
     * 客户id
     */
    private Integer customerId;

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
     * 对接人
     */
    private String username;

    /**
     * 上有类型(个人上游，团队上游，公司上游)
     */
    private String frontType;

    /**
     * 更新时间
     */
    private String updateTime;

    /**
     * 线路属性
     */
    private String circuitProperty;

    /**
     * 线路属性id
     */
    private Integer circuitId;
}