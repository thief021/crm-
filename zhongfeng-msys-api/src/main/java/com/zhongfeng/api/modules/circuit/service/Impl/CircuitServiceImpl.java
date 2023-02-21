package com.zhongfeng.api.modules.circuit.service.Impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhongfeng.api.modules.circuit.vo.PropertyVo;
import com.zhongfeng.api.modules.circuit.vo.params.CircuitParams;
import com.zhongfeng.api.modules.end.mapper.EndMapper;
import com.zhongfeng.api.modules.circuit.mapper.CircuitMapper;
import com.zhongfeng.api.modules.circuit.service.CircuitService;
import com.zhongfeng.api.modules.circuit.vo.CircuitVo;
import com.zhongfeng.api.modules.utils.function.Transfer;
import com.zhongfeng.api.modules.utils.pojo.PageDataInfo;
import com.zhongfeng.api.modules.utils.pojo.Result;
import com.zhongfeng.api.modules.utils.service.HttpStatus;
import com.zhongfeng.api.modules.utils.service.ReturnCodes;
import com.zhongfeng.api.modules.utils.service.ReturnMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CircuitServiceImpl implements CircuitService {
    @Autowired
    private CircuitMapper circuitMapper;

    /**
     * 分页查询所有的自有线路
     *
     * @param params
     * @return
     */
    @Override
    public Result queryAllCircuits(CircuitParams params) {
        Page<CircuitVo> page = new Page<>(params.getPageNum(), params.getPageSize());
        List<CircuitVo> circuitVos = circuitMapper.queryAllCircuits(page, params);
        return Result.setSuccess(HttpStatus.SUCCESS, "", new PageDataInfo(page, circuitVos));
    }

    /**
     * 查询线路属性
     *
     * @param params
     * @return
     */
    @Override
    public Result queryCircuitProperty(CircuitParams params) {
        Page<PropertyVo> page = new Page<>(params.getPageNum(), params.getPageSize());
        List<PropertyVo> propertyVos = circuitMapper.queryCircuitProperty(page,params);
        return Result.setSuccess(HttpStatus.SUCCESS, "", new PageDataInfo(page,propertyVos));
    }

    /**
     * 新增线路
     *
     * @param params
     * @return
     */
    @Override
    public Result addCircuit(CircuitParams params) {
        int i = circuitMapper.addCircuit(params);
        if (i == 1) {
            return Result.setSuccess(HttpStatus.SUCCESS, "添加线路成功！");
        } else {
            return Result.setFail(ReturnCodes.ADD_OWN_FAIL, ReturnMessage.ADD_OWN_FAIL);
        }
    }

    /**
     * 删除线路
     *
     * @param id
     * @return
     */
    @Override
    public Result deleteCircuitProperty(Integer id) {
        int i = circuitMapper.deleteCircuitProperty(id);
        if (i == 1) {
            return Result.setSuccess(HttpStatus.SUCCESS, "删除线路成功！");
        } else {
            return Result.setFail(ReturnCodes.DELETE_OWNCIRCUIT_FAIL, ReturnMessage.DELETE_OWNCIRCUIT_FAIL);
        }
    }

    /**
     * 更新线路
     *
     * @param params
     * @return
     */
    @Override
    public Result updateCircuitProperty(CircuitParams params) {
        int i = circuitMapper.updateCircuitProperty(params);
        if (i == 1){
            return Result.setSuccess(HttpStatus.SUCCESS, "修改线路成功！");
        }else {
            return Result.setFail(ReturnCodes.UPDATE_OWN_FAIL, ReturnMessage.UPDATE_OWN_FAIL);
        }
    }

    /**
     * 新增线路属性
     * @param params
     * @return
     */
    @Override
    public Result addCircuitProperty(CircuitParams params) {
        int num = circuitMapper.checkProperty(params.getProperty());
        if (num == 0){
            int i = circuitMapper.addCircuitProperty(params);
            if (i == 1) {
                return Result.setSuccess(HttpStatus.SUCCESS, "添加线路属性成功！");
            } else {
                return Result.setFail(ReturnCodes.ADD_CIRCUIT_PROPERTY_FAIL, ReturnMessage.ADD_CIRCUIT_PROPERTY_FAIL);
            }
        }else {
            return Result.setFail(ReturnCodes.PROPERTY_EXIST, ReturnMessage.PROPERTY_EXIST);
        }
    }
}
