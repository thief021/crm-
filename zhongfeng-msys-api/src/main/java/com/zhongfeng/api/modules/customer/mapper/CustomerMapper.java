package com.zhongfeng.api.modules.customer.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhongfeng.api.modules.customer.vo.CustomerVo;
import com.zhongfeng.api.modules.customer.vo.params.CustomerParams;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author blueCat
 * @date 2023/2/8 10:21
 * @motto life is a gift
 */
public interface CustomerMapper {

    /**
     * 查询全部客户信息
     * @param page
     * @param params
     * @return
     */
    List<CustomerVo> queryAllCustomer(Page<CustomerVo> page,@Param("params") CustomerParams params);


    /**
     * 添加客户
     * @param params
     * @return
     */
    int addCustomer(@Param("params") CustomerParams params);

    /**
     * 删除客户
     * @param id
     * @return
     */
    int deleteCustomer(Integer id);

    /**
     * 更新客户
     * @param params
     * @return
     */
    int updateCustomer(@Param("params") CustomerParams params);

    /**
     * 查询IP
     * @param idList
     * @return
     */
    List<String> queryIp(List<Integer> idList);

    /**
     * 检查公司名是否存在
     * @param company
     * @return
     */
    int checkCompany(@Param("params") CustomerParams params);
}
