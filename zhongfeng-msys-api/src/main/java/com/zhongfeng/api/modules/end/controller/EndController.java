package com.zhongfeng.api.modules.end.controller;

import com.zhongfeng.api.modules.end.service.EndService;
import com.zhongfeng.api.modules.end.vo.params.EndParams;
import com.zhongfeng.api.modules.utils.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author blueCat
 * @date 2023/2/2 15:45
 * @motto life is a gift
 */
@RestController
@RequestMapping("/api/end")
public class EndController {

    @Autowired
    private EndService endService;

    /**
     * 查询全部下游信息
     * @param params
     * @return
     */
    @PostMapping("/queryAllEnd")
    public Result queryAllEnd(@RequestBody EndParams params,HttpServletRequest request) {
        return endService.queryAllEnd(params,request);
    }

    /**
     * 查询全部IP地址
     * @param params
     * @return
     */
    @PostMapping("/queryAllIp")
    public Result queryAllIp(@RequestBody EndParams params) {
        return endService.queryAllIp(params);
    }


    /**
     * 新增下游信息
     * @param params
     * @return
     */
    @PostMapping("/addEnd")
    public Result addEnd(@RequestBody EndParams params, HttpServletRequest request){
        return endService.addEnd(params,request);
    }

    /**
     * 新增IP地址
     * @param params
     * @return
     */
    @PostMapping("/addIp")
    public Result addIp(@RequestBody EndParams params){
        return endService.addIp(params);
    }

    /**
     * 删除下游信息
     * @param params
     * @return
     */
    @PostMapping("/deleteEnd")
    public Result deleteEnd(@RequestBody EndParams params){
        return endService.deleteEnd(params.getId());
    }

    /**
     * 删除IP地址
     * @param params
     * @return
     */
    @PostMapping("/deleteIp")
    public Result deleteIp(@RequestBody EndParams params){
        return endService.deleteIp(params.getIpId());
    }

    /**
     * 修改下游信息
     * @param params
     * @return
     */
    @PostMapping("/updateEnd")
    public Result updateEnd(@RequestBody EndParams params){
        return endService.updateEnd(params);
    }

    /**
     * 修改IP地址
     * @param params
     * @return
     */
    @PostMapping("/updateIp")
    public Result updateIp(@RequestBody EndParams params){
        return endService.updateIp(params);
    }
}
