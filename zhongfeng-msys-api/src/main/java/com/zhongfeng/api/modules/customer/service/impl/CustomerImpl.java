package com.zhongfeng.api.modules.customer.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhongfeng.api.modules.customer.mapper.CustomerMapper;
import com.zhongfeng.api.modules.customer.service.CustomerService;
import com.zhongfeng.api.modules.customer.vo.CustomerVo;
import com.zhongfeng.api.modules.customer.vo.params.CustomerParams;
import com.zhongfeng.api.modules.end.vo.EndVo;
import com.zhongfeng.api.modules.img.mapper.ImgMapper;
import com.zhongfeng.api.modules.utils.function.Transfer;
import com.zhongfeng.api.modules.utils.pojo.PageDataInfo;
import com.zhongfeng.api.modules.utils.pojo.Result;
import com.zhongfeng.api.modules.utils.service.HttpStatus;
import com.zhongfeng.api.modules.utils.service.ReturnCodes;
import com.zhongfeng.api.modules.utils.service.ReturnMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author blueCat
 * @date 2023/2/8 10:18
 * @motto life is a gift
 */
@Service
@Slf4j
public class CustomerImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private ImgMapper imgMapper;

    /**
     * 查询全部顾客信息
     *
     * @param params
     * @return
     */
    @Override
    public Result queryAllCustomer(CustomerParams params, HttpServletRequest request) {
        Page<CustomerVo> page = new Page<>(params.getPageNum(), params.getPageSize());
        params.setUserId((Integer) request.getSession().getAttribute("userId"));
        params.setUserType((Integer) request.getSession().getAttribute("userType"));
        List<CustomerVo> customerVos = customerMapper.queryAllCustomer(page, params);
        //回填IP
        for (CustomerVo customerVo : customerVos) {
            //处理照片路径
            String license ="../../../img/license/" +customerVo.getLicense();
            customerVo.setLicense(license);
            String ipId = customerVo.getIpId();
            if (ipId != null && !ipId.equals("")) {
                List<Integer> ipIdList = Transfer.transferString(ipId);
                customerVo.setIpIdList(ipIdList);
                List<String> ipList = customerMapper.queryIp(ipIdList);
                String ipStr = Transfer.combineList(ipList);
                customerVo.setIp(ipStr);
            }
        }
        return Result.setSuccess(HttpStatus.SUCCESS, "", new PageDataInfo(page, customerVos));
    }

    /**
     * 新增客户信息
     *
     * @param params
     * @return
     */
    @Override
    public Result addCustomer( CustomerParams params , HttpServletRequest request) {
        //得到图片的名字
        String license =(String) request.getSession().getAttribute("imgUrl");
        //查询图片id
        Integer licenseId = imgMapper.queryImg(license);
        params.setLicenseId(licenseId);
        log.info("这是新增营业执照路径"+request.getSession().getAttribute("imgUrl")+"");
        params.setUserId((Integer) request.getSession().getAttribute("userId"));
        request.getSession().removeAttribute("imgUrl");
        params.setIp(Transfer.combineList(params.getIpIdList()));
        int j = customerMapper.checkCompany(params);
        if (j == 0){
            int i = customerMapper.addCustomer(params);
            if (i == 1) {
                return Result.setSuccess(HttpStatus.SUCCESS, "添加客户成功！");
            } else {
                return Result.setFail(ReturnCodes.ADD_CUSTOMER_FAIL, ReturnMessage.ADD_CUSTOMER_FAIL);
            }
        }else {
            return Result.setFail("该公司名已存在");
        }
    }

    /**
     * 删除客户信息
     *
     * @param id
     * @return
     */
    @Override
    public Result deleteCustomer(Integer id) {
        int i = customerMapper.deleteCustomer(id);
        if (i == 1) {
            return Result.setSuccess(HttpStatus.SUCCESS, "删除客户成功！");
        } else {
            return Result.setFail(ReturnCodes.DELETE_CUSTOMER_FAIL, ReturnMessage.DELETE_CUSTOMER_FAIL);
        }
    }

    /**
     * 更新客户信息
     *
     * @param params
     * @return
     */
    @Override
    public Result updateCustomer(CustomerParams params,HttpServletRequest request) {
        String license =(String) request.getSession().getAttribute("imgUrl");
        //查询图片id
        Integer licenseId = imgMapper.queryImg(license);
        params.setLicenseId(licenseId);
        log.info("这是修改的图片路径"+request.getSession().getAttribute("imgUrl"));
        request.getSession().removeAttribute("imgUrl");
        params.setIp(Transfer.combineList(params.getIpIdList()));
        int i = customerMapper.updateCustomer(params);
        if (i == 1) {
            return Result.setSuccess(HttpStatus.SUCCESS, "修改客户成功！");
        } else {
            return Result.setFail(ReturnCodes.UPDATE_CUSTOMER_FAIL, ReturnMessage.UPDATE_CUSTOMER_FAIL);
        }
    }
}
