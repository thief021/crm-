package com.zhongfeng.api.modules.customer.controller;

import com.zhongfeng.api.modules.customer.service.CustomerService;
import com.zhongfeng.api.modules.customer.vo.params.CustomerParams;
import com.zhongfeng.api.modules.end.vo.params.EndParams;
import com.zhongfeng.api.modules.utils.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author blueCat
 * @date 2023/2/8 10:17
 * @motto life is a gift
 */
@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /**
     * 查询全部客户信息
     * @param params
     * @return
     */
    @PostMapping("/queryAllCustomer")
    public Result queryAllCustomer(@RequestBody CustomerParams params, HttpServletRequest request) {
        return customerService.queryAllCustomer(params,request);
    }

    /**
     * 新增客户信息
     * @param params
     * @return
     */
    @PostMapping("/addCustomer")
    public Result addCustomer( @RequestBody CustomerParams params , HttpServletRequest request){
        return customerService.addCustomer( params,request);
    }

    /**
     * 删除客户信息
     * @param params
     * @return
     */
    @PostMapping("/deleteCustomer")
    public Result deleteCustomer(@RequestBody CustomerParams params){
        return customerService.deleteCustomer(params.getId());
    }

    /**
     * 修改客户信息
     * @param params
     * @return
     */
    @PostMapping("/updateCustomer")
    public Result updateCustomer(@RequestBody CustomerParams params,HttpServletRequest request){
        return customerService.updateCustomer(params,request);
    }
}
