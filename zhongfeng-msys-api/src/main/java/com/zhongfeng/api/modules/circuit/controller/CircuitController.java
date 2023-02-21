package com.zhongfeng.api.modules.circuit.controller;

import com.zhongfeng.api.modules.circuit.service.CircuitService;
import com.zhongfeng.api.modules.circuit.vo.params.CircuitParams;
import com.zhongfeng.api.modules.utils.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/circuit")
public class CircuitController {
    @Autowired
    private CircuitService circuitService;

    /**
     * 查询全部自有线路信息
     * @param params
     * @return
     */
    @PostMapping("/queryAllCircuits")
    public Result queryAllCircuits(@RequestBody CircuitParams params) {
        return circuitService.queryAllCircuits(params);
    }

    /**
     * 查询线路属性
     * @param params
     * @return
     */
    @PostMapping("/queryCircuitProperty")
    public Result queryCircuitProperty(@RequestBody CircuitParams params){
        return circuitService.queryCircuitProperty(params);
    }

    /**
     * 新增线路
     * @param params
     * @return
     */
    @PostMapping("/addCircuit")
    public Result addCircuit(@RequestBody CircuitParams params){
        return circuitService.addCircuit(params);
    }

    /**
     * 新增线路属性
     * @param params
     * @return
     */
    @PostMapping("/addCircuitProperty")
    public Result addCircuitProperty(@RequestBody CircuitParams params){
        return circuitService.addCircuitProperty(params);
    }

    /**
     * 删除线路
     * @param params
     * @return
     */
    @PostMapping("/deleteCircuitProperty")
    public Result deleteCircuitProperty(@RequestBody CircuitParams params){
        return circuitService.deleteCircuitProperty(params.getId());
    }

    /**
     * 更新线路
     * @param params
     * @return
     */
    @PostMapping("/updateCircuitProperty")
    public Result updateCircuitProperty(@RequestBody CircuitParams params){
        return circuitService.updateCircuitProperty(params);
    }
}
