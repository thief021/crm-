package com.zhongfeng.api.modules.customer.vo.params;

import com.zhongfeng.api.modules.utils.pojo.BasePageSearch;
import lombok.Data;

import java.util.List;

/**
 * @author blueCat
 * @date 2023/2/8 10:24
 * @motto life is a gift
 */
@Data
public class CustomerParams extends BasePageSearch {

    /**
     * 客户id
     */
    private Integer id;

    /**
     * 公司名
     */
    private String company;

    /**
     * 微信名
     */
    private String wechatName;

    /**
     * 微信账号
     */
    private String wechatAccount;

    /**
     * 手机号
     */
    private String phoneNumber;

    /**
     * 用户名
     */
    private String username;

    /**
     * ipId集合
     */
    private List<Integer> ipIdList;

    /**
     * ipId
     */
    private Integer ipId;

    /**
     * ip
     */
    private String ip;
    /**
     * 图片
     */
    private Integer licenseId;
    /**
     * 图片的名字(url)
     */
    private String license;
}
