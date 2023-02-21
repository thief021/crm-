package com.zhongfeng.api.modules.user.vo.params;

import com.zhongfeng.api.modules.utils.pojo.BasePageSearch;
import lombok.Data;

/**
 * @author blueCat
 * @date 2023/2/3 16:06
 * @motto life is a gift
 */
@Data
public class UserParams extends BasePageSearch {

    /**
     * 用户id
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户类型：0为普通用户，1为运维，2为技术
     */
    private Integer type;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 微信号
     */
    private String wechat;
}
