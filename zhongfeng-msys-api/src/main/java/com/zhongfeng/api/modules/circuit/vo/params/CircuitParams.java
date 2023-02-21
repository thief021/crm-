package com.zhongfeng.api.modules.circuit.vo.params;

import com.zhongfeng.api.modules.utils.pojo.BasePageSearch;
import lombok.Data;
import java.util.List;

@Data
public class CircuitParams extends BasePageSearch {

    /**
     * 自增主键
     */
    private Integer id;

    /**
     * 盲区
     */
    private String blindArea;

    /**
     * 频率
     */
    private String frequency;

    /**
     * 外显
     */
    private String prefix;

    /**
     * 价格
     */
    private String price;

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
     * 更新时间
     */
    private String updateTime;

}
