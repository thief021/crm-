package com.zhongfeng.api.modules.customer.service;

import com.zhongfeng.api.modules.customer.vo.params.CustomerParams;
import com.zhongfeng.api.modules.utils.pojo.Result;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @author blueCat
 * @date 2023/2/8 10:18
 * @motto life is a gift
 */
public interface CustomerService {

    /**
     * 查询全部顾客信息
     * @param params
     * @return
     */
    Result queryAllCustomer(CustomerParams params, HttpServletRequest request);


    /**
     * 新增客户信息
     * @param params
     * @return
     */
    Result addCustomer(CustomerParams params, HttpServletRequest request);

    /**
     * 删除客户信息
     * @param id
     * @return
     */
    Result deleteCustomer(Integer id);

    /**
     * 更新客户信息
     * @param params
     * @return
     */
    Result updateCustomer(CustomerParams params,HttpServletRequest request);
}
