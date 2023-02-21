package com.zhongfeng.api.modules.circuit.service;

import com.zhongfeng.api.modules.circuit.vo.params.CircuitParams;
import com.zhongfeng.api.modules.utils.pojo.Result;

public interface CircuitService {

    /**
     * 分页查询所有的自有线路
     * @param params
     * @return
     */
    Result queryAllCircuits(CircuitParams params);

    /**
     * 查询线路属性
     * @param params
     * @return
     */
    Result queryCircuitProperty(CircuitParams params);

    /**
     * 新增线路
     * @param params
     * @return
     */
    Result addCircuit(CircuitParams params);

    /**
     * 删除线路
     * @param circuitId
     * @return
     */
    Result deleteCircuitProperty(Integer circuitId);

    /**
     * 更新线路
     * @param params
     * @return
     */
    Result updateCircuitProperty(CircuitParams params);

    /**
     * 新增线路属性
     * @param params
     * @return
     */
    Result addCircuitProperty(CircuitParams params);
}
