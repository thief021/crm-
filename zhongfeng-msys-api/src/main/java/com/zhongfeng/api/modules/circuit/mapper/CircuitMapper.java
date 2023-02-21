package com.zhongfeng.api.modules.circuit.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhongfeng.api.modules.circuit.vo.PropertyVo;
import com.zhongfeng.api.modules.circuit.vo.params.CircuitParams;
import com.zhongfeng.api.modules.circuit.vo.CircuitVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface CircuitMapper {

    /**
     * 查询全部自有属性
     *
     * @return
     */
    List<CircuitVo> queryAllCircuits(Page<CircuitVo> page, @Param("params") CircuitParams params);

    /**
     * 查询全部线路属性
     * @return
     */
    List<PropertyVo> queryCircuitProperty(Page<PropertyVo> page, @Param("params") CircuitParams params);

    /**
     * 新增线路
     * @param params
     * @return
     */
    int addCircuit(@Param("params") CircuitParams params);

    /**
     * 删除线路
     * @param id
     * @return
     */
    int deleteCircuitProperty(Integer id);

    /**
     * 修改线路
     * @param params
     * @return
     */
    int updateCircuitProperty(@Param("params") CircuitParams params);

    /**
     * 添加线路属性
     * @param params
     * @return
     */
    int addCircuitProperty(@Param("params") CircuitParams params);

    /**
     * 检查属性名是否存在
     * @param property
     * @return
     */
    int checkProperty(String property);
}
