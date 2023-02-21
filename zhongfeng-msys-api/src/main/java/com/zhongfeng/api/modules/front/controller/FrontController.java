package com.zhongfeng.api.modules.front.controller;

import com.zhongfeng.api.modules.front.service.FrontService;
import com.zhongfeng.api.modules.front.vo.params.FrontParams;
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
@RequestMapping("/api/front")
public class FrontController {

    @Autowired
    private FrontService frontService;

    /**
     * 查询上游信息
     * @param params
     * @return
     */
    @PostMapping("/queryAllFront")
    public Result queryAllFront(@RequestBody FrontParams params, HttpServletRequest request) {
        return frontService.queryAllFront(params,request);
    }

    /**
     * 新增上游信息
     * @param params
     * @return
     */
    @PostMapping("/addFront")
    public Result addFront(@RequestBody FrontParams params,HttpServletRequest request){
        return frontService.addFront(params,request);
    }

    /**
     * 删除上游信息
     * @param params
     * @return
     */
    @PostMapping("/deleteFront")
    public Result deleteFront(@RequestBody FrontParams params){
        return frontService.deleteFront(params.getId());
    }

    /**
     * 修改上游信息
     * @param params
     * @return
     */
    @PostMapping("/updateFront")
    public Result updateFront(@RequestBody FrontParams params){
        return frontService.updateFront(params);
    }
}
