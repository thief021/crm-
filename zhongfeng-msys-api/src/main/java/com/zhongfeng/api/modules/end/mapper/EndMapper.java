package com.zhongfeng.api.modules.end.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhongfeng.api.modules.end.vo.EndVo;
import com.zhongfeng.api.modules.end.vo.IPVo;
import com.zhongfeng.api.modules.end.vo.params.EndParams;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 记账功能Mapper
 *
 * @author blueCat
 * @since 2022/2/24
 */
@Component
public interface EndMapper {

    /**
     * 查询全部下游
     *
     * @return
     */
    List<EndVo> queryAllEnd(Page<EndVo> page, @Param("params") EndParams params);

    /**
     * 添加下游
     *
     * @param params
     * @return
     */
    int addEnd(@Param("params") EndParams params);

    /**
     * 删除下游
     *
     * @param id
     * @return
     */
    int deleteEnd(Integer id);

    /**
     * 更新下游
     *
     * @param params
     * @return
     */
    int updateEnd(@Param("params") EndParams params);

    /**
     * 查询全部IP
     * @param page
     * @param params
     * @return
     */
    List<IPVo> queryAllIp(Page<IPVo> page, @Param("params") EndParams params);

    /**
     * 新增IP地址
     * @param params
     * @return
     */
    int addIp(@Param("params") EndParams params);

    /**
     * 删除IP地址
     * @param id
     * @return
     */
    int deleteIp(Integer id);

    /**
     * 根据id查询Ip
     * @param id
     * @return
     */
    IPVo queryIpById(Integer id);

    /**
     * 修改IP地址
     * @param params
     * @return
     */
    int updateIp(@Param("params") EndParams params);

    /**
     * 验证ip是否存在
     * @param ip
     * @return
     */
    int checkIp(String ip);
}
