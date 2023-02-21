package com.zhongfeng.api.modules.front.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhongfeng.api.modules.front.vo.FrontVo;
import com.zhongfeng.api.modules.front.vo.params.FrontParams;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 * @author blueCat
 * @since 2022/2/24
 */
public interface FrontMapper {

    /**
     * 查询上游
     *
     * @return
     */
    List<FrontVo> queryAllFront(Page<FrontVo> page, @Param("params") FrontParams params);

    /**
     * 添加上游
     *
     * @param params
     * @return
     */
    int addFront(@Param("params") FrontParams params);

    /**
     * 删除上游
     *
     * @param id
     * @return
     */
    int deleteFront(Integer id);

    /**
     * 更新上游
     *
     * @param params
     * @return
     */
    int updateFront(@Param("params") FrontParams params);
}
